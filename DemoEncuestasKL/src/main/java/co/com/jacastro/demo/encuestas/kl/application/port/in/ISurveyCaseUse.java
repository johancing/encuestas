package co.com.jacastro.demo.encuestas.kl.application.port.in;

import java.util.List;
import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Question;

public interface ISurveyCaseUse {

	Optional<List<Question>> createSurvey(List<Question> questions);

	Optional<List<Question>> findAll();

}
