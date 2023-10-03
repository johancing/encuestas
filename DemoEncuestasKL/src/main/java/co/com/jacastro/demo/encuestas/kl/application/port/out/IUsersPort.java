package co.com.jacastro.demo.encuestas.kl.application.port.out;

import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;

public interface IUsersPort {
	
	public Optional<User> save(User authenticatedUser);

}
