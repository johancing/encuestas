package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByUsername(String username);

}
