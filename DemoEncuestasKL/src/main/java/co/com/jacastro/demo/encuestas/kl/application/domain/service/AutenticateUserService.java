package co.com.jacastro.demo.encuestas.kl.application.domain.service;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.LoginUser;
import co.com.jacastro.demo.encuestas.kl.application.port.in.IAuthenticateUserCaseUse;
import co.com.jacastro.demo.encuestas.kl.application.port.out.IAuthenticateUserPort;

@Service
public class AutenticateUserService implements IAuthenticateUserCaseUse {

	@Autowired
	private IAuthenticateUserPort authenticateUserPort;
	private User authenticatedUser;

	public AutenticateUserService() {
		authenticatedUser = new User();
		authenticatedUser.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 24));
		authenticatedUser.setStatus(User.USER_NOT_EXIST);
	}

	@Override
	public Optional<User> authenticateUser(LoginUser loginUser) {
		if (validteLoginUser(loginUser)) {
			try {
				Optional<User> userOP = authenticateUserPort.authenticateUserByName(loginUser.getUsername());
				if ((userOP.isPresent()) && (loginUser.getPassword().equals(userOP.get().getPassword())
						&& User.USER_AUTHORIZED.equals(userOP.get().getStatus()))) {
					userOP.get().setPassword(null);
					return userOP;
				}
			} catch (UsernameNotFoundException e) {
				authenticatedUser.setUsername(loginUser.getUsername());
				authenticatedUser.setExpiredDate(null);
				return Optional.of(authenticatedUser);
			}
		}
		authenticatedUser.setUsername(loginUser.getUsername());
		authenticatedUser.setExpiredDate(null);
		return Optional.of(authenticatedUser);
	}

	private boolean validteLoginUser(LoginUser loginUser) {
		if (loginUser == null)
			return false;
		if (loginUser.getUsername() == null || loginUser.getUsername().isEmpty())
			return false;
		return !(loginUser.getPassword() == null || loginUser.getPassword().isEmpty());
	}

}
