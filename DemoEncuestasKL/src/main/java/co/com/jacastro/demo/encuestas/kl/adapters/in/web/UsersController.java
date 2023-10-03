package co.com.jacastro.demo.encuestas.kl.adapters.in.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jacastro.demo.encuestas.kl.adapters.exception.UserException;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import co.com.jacastro.demo.encuestas.kl.application.port.in.IUsersCaseUse;

@RestController
@RequestMapping("/demo/kl/users")
public class UsersController {
	
	@Autowired
	private IUsersCaseUse usersCaseUse;

	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@RequestBody User authenticatedUser) {
		authenticatedUser.setRol("USER");
		Optional<User> authenticatedUser2 = usersCaseUse.save(authenticatedUser);
		if (!authenticatedUser2.isPresent()) {
			throw new UserException("User not created. Username already exist.");
		}
		return ResponseEntity.ok(authenticatedUser2.get());		
	}

}
