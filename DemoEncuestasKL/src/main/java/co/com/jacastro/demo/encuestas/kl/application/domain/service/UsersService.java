package co.com.jacastro.demo.encuestas.kl.application.domain.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import co.com.jacastro.demo.encuestas.kl.application.port.in.IUsersCaseUse;
import co.com.jacastro.demo.encuestas.kl.application.port.out.IUsersPort;

@Service
public class UsersService implements IUsersCaseUse {
	
	@Autowired
	private IUsersPort usersPort;

	@Override
	public Optional<User> save(User authenticatedUser) {
		return usersPort.save(authenticatedUser);
	}
}
