package co.com.jacastro.demo.encuestas.kl.application.port.in;

import java.util.List;
import java.util.Optional;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.SurverQuestionResponseStatus;

public interface ISurverQuestionResponseCaseUse {
	
	Optional<List<SurverQuestionResponseStatus>> save(List<SurverQuestionResponseStatus> surverQuestionResponseStatus);

}
