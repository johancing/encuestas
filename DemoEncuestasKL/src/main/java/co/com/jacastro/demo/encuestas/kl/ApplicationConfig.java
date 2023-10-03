package co.com.jacastro.demo.encuestas.kl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user.UserEntity;
import co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user.UsersRepository;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;

@Configuration
public class ApplicationConfig {

	@Bean
	CommandLineRunner commandLineRunner(UsersRepository userRepository) {
		return inserts -> {
			UserEntity user = new UserEntity("konradadmin", "konradadmin", "konradadmin@gmail.com", "ADMIN",
					User.USER_AUTHORIZED, null, null);
			userRepository.save(user);
		};
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	AuthenticationProvider authenticationProvider(UsersRepository userRepository) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService(userRepository));
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService getUserDetailsService(UsersRepository userRepository) {
		return userName -> userRepository.findByUsername(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User not found."));

	}

}
