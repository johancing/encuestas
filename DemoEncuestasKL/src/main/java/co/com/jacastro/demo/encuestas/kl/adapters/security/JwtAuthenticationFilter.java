package co.com.jacastro.demo.encuestas.kl.adapters.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import co.com.jacastro.demo.encuestas.kl.application.domain.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String token = extractTokenFromRequest(request);
		String username = null;
		if (token == null || token.isEmpty()) {
			filterChain.doFilter(request, response);
			return;
		}
		username = jwtService.extractUserName(token);
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (validateAuthorities(request, token)) {
				throw new ServletException("URL not authorized");
			}
			if (jwtService.isValidToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

	private boolean validateAuthorities(HttpServletRequest request, String token) {
		String url = jwtService.extractURL(request);
		String rol = jwtService.extractRol(token);
		return (protectedURLFromUsers(url) && "USER".equals(rol));
	}

	/*
	 * Esta validaciopn podraia ser un servicio pero me dio mamera
	 */
	private boolean protectedURLFromUsers(String url) {
		List<String> list = new ArrayList<>();
		list.add("/demo/kl/api/v1/survey/create");
		list.add("/demo/kl/api/v1/survey/stadistics");
		return list.contains(url);
	}

	private String extractTokenFromRequest(HttpServletRequest request) {
		final String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			return token.substring(7);
		}
		return null;
	}

}
