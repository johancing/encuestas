package co.com.jacastro.demo.encuestas.kl.application.port.in;

import java.util.Optional;

import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.LoginUser;

public interface IAuthenticateUserCaseUse {
	
	public Optional<User> authenticateUser(LoginUser loginUser);

}
