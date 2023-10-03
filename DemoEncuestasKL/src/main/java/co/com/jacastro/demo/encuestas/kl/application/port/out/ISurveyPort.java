package co.com.jacastro.demo.encuestas.kl.application.port.out;

import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Survey;

public interface ISurveyPort {

	public Optional<Survey> createsurvey(Survey survey);

	public Optional<Survey> findAll();

}
