package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurverQuestionResponseStatusRepository extends JpaRepository<SurverQuestionResponseStatusEntity, Integer> {

}
