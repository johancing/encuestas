package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<QuestionEntity, Integer>{

}
