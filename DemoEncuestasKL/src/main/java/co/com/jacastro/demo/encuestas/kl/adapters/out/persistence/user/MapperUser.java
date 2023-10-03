package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user;

import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.User;

@Component
public class MapperUser {

	public UserEntity mapDomainToEntity(User authenticatedUser) {
		UserEntity authenticatedUserEntity = new UserEntity();
		if (authenticatedUser != null) {
			authenticatedUserEntity.setEmail(authenticatedUser.getEmail());
			authenticatedUserEntity.setExpiredDate(authenticatedUser.getExpiredDate());
			authenticatedUserEntity.setRol(authenticatedUser.getRol());
			authenticatedUserEntity.setStatus(authenticatedUser.getStatus());
			authenticatedUserEntity.setToken(authenticatedUser.getToken());
			authenticatedUserEntity.setUsername(authenticatedUser.getUsername());
			authenticatedUserEntity.setPassword(authenticatedUser.getPassword());
		}
		return authenticatedUserEntity;
	}
	
	public User mapEntityToDomain(UserEntity authenticatedUserEntity) {
		User authenticatedUser = new User();
		if (authenticatedUserEntity != null) {
			authenticatedUser.setEmail(authenticatedUserEntity.getEmail());
			authenticatedUser.setExpiredDate(authenticatedUserEntity.getExpiredDate());
			authenticatedUser.setRol(authenticatedUserEntity.getRol());
			authenticatedUser.setStatus(authenticatedUserEntity.getStatus());
			authenticatedUser.setToken(authenticatedUserEntity.getToken());
			authenticatedUser.setUsername(authenticatedUserEntity.getUsername());
			authenticatedUser.setPassword(authenticatedUserEntity.getPassword());
		}
		return authenticatedUser;
	}

}
