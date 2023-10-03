package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;
import co.com.jacastro.demo.encuestas.kl.application.domain.service.JwtService;
import co.com.jacastro.demo.encuestas.kl.application.port.out.IAuthenticateUserPort;
import co.com.jacastro.demo.encuestas.kl.application.port.out.IUsersPort;

@Component
public class UsersAdapter implements IAuthenticateUserPort, IUsersPort {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UsersRepository authenticateUserRepository;
	@Autowired
	private MapperUser mapperAuthenticatedUser;

	@Override
	public Optional<User> authenticateUserByName(String username) {
		Optional<UserEntity> authOptional = authenticateUserRepository.findByUsername(username);
		return handleUser(authOptional);
	}

	@Override
	public Optional<User> save(User authenticatedUser) {
		authenticatedUser.setStatus(User.USER_AUTHORIZED);
		UserEntity authenticatedUserEntity = null;
		try {
	 		authenticatedUserEntity = authenticateUserRepository
					.save(mapperAuthenticatedUser.mapDomainToEntity(authenticatedUser));
			authenticatedUserEntity.setStatus(User.USER_CREATED);
			authenticatedUserEntity.setPassword(null);
			return Optional.of(mapperAuthenticatedUser.mapEntityToDomain(authenticatedUserEntity));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	private Optional<User> handleUser(Optional<UserEntity> authOptional) {
		if (!authOptional.isPresent()) {
			throw new UsernameNotFoundException("User not found.");
		}
		User user = mapperAuthenticatedUser.mapEntityToDomain(authOptional.get());
		if (User.USER_AUTHORIZED.equals(user.getStatus())) {
			user.setToken(jwtService.createJwtToken(user));
		} else {
			user.setExpiredDate(null);
		}
		return Optional.of(user);
	}

}
