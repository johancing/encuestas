package co.com.jacastro.demo.encuestas.kl.application.port.in;

import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;

public interface IUsersCaseUse {
	
	public Optional<User> save(User authenticatedUser);

}
