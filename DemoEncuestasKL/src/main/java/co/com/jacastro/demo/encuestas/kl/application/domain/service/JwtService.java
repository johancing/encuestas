package co.com.jacastro.demo.encuestas.kl.application.domain.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class JwtService {
	
	private static final String KEY = "CFDE34534sdfASDF3435swdfsSDVSDVG345sdfadbfaer54wASGFAEGQEVADV453";

	public String createJwtToken(User authenticatedUser) {
		return createJwtToken(new HashMap<>(), authenticatedUser);
	}

	private String createJwtToken(Map<String, Object> extraClaims, User authenticatedUser) {
		Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 24);
		authenticatedUser.setExpiredDate(expirationDate);
		extraClaims.put("rol", authenticatedUser.getRol());
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(authenticatedUser.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(expirationDate)
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String extractUserName(String token) {
		return getclaim(token, Claims::getSubject);
	}
	
	public String extractRol(String token) {
		return (String) getclaim(token, claim -> {
			if(claim.containsKey("rol"))
				return claim.get("rol");
			return null;
		});
	}

	public boolean isValidToken(String token, UserDetails userDetails) {
		final String username = extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !getExpirationDate(token));
	}

	public <T> T getclaim(String token, Function<Claims, T> claimHandler) {
		final Claims claims = getAllClaims(token);
		return claimHandler.apply(claims);
	}
	
	private Claims getAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	private boolean getExpirationDate(String token) {
		Date expirationdate = getclaim(token, Claims::getExpiration);
		return expirationdate.before(new Date(System.currentTimeMillis()));
	}

	public String extractURL(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		StringBuilder url = new StringBuilder();
		url.append(servletPath);
		return url.toString();
	}

}
