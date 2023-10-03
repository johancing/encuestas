package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user;

import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.LoginUser;

@Component
public class MapperLoginUser {

	public LoginUserEntity mapDomainToEntity(LoginUser loginUser) {
		LoginUserEntity loginUserEntity = new LoginUserEntity();
		if (loginUser != null) {
			loginUserEntity.setUsername(loginUser.getUsername());
			loginUserEntity.setPassword(loginUser.getPassword());
		}
		return loginUserEntity;
	}
	
	public LoginUser mapEntityToDomain(LoginUserEntity loginUserEntity) {
		LoginUser loginUser = new LoginUser();
		if (loginUserEntity != null) {
			loginUser.setPassword(loginUserEntity.getPassword());
			loginUser.setUsername(loginUserEntity.getUsername());
		}
		return loginUser;
		
	}

}
