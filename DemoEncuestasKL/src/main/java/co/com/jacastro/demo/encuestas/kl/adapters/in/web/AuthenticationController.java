package co.com.jacastro.demo.encuestas.kl.adapters.in.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.LoginUser;
import co.com.jacastro.demo.encuestas.kl.application.port.in.IAuthenticateUserCaseUse;

@RestController
@RequestMapping("/demo/kl/auth")
public class AuthenticationController {
	
	@Autowired
	private IAuthenticateUserCaseUse authenticateUserCaseUse;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginUser loginUser) {
		Optional<User> authOptional = authenticateUserCaseUse.authenticateUser(loginUser);
		if (!authOptional.isPresent()) {
			throw new UsernameNotFoundException("Username or password nor exist.");
		}
		return ResponseEntity.ok(authOptional.get());
	}
	
}
