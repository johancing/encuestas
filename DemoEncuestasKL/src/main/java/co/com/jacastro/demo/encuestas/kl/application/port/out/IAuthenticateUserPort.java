package co.com.jacastro.demo.encuestas.kl.application.port.out;

import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;

public interface IAuthenticateUserPort {
	
	Optional<User> authenticateUserByName(String username);

}
