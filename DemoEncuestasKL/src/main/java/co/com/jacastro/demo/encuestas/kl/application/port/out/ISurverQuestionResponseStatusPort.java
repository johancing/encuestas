package co.com.jacastro.demo.encuestas.kl.application.port.out;

import java.util.List;
import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.SurverQuestionResponseStatus;

public interface ISurverQuestionResponseStatusPort {
	
	Optional<List<SurverQuestionResponseStatus>> save(List<SurverQuestionResponseStatus> surverQuestionResponseStatus);

}
