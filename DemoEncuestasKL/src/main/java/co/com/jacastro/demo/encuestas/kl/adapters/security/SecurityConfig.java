package co.com.jacastro.demo.encuestas.kl.adapters.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter,
			AuthenticationProvider authenticationProvider) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(authRequest -> authRequest.requestMatchers("/demo/kl/auth/**").permitAll()
						.requestMatchers("/demo/kl/users/**").permitAll()
						.requestMatchers("/swagger-ui/**").permitAll()
						.requestMatchers("/swagger-ui/**",
		                        "/swagger-resources/*",
		                        "/v3/api-docs/**").permitAll()
						.anyRequest().authenticated())
				.sessionManagement(
						sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

}
