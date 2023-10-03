package co.com.jacastro.demo.encuestas.kl.application.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.SurverQuestionResponseStatus;
import co.com.jacastro.demo.encuestas.kl.application.port.in.ISurverQuestionResponseCaseUse;
import co.com.jacastro.demo.encuestas.kl.application.port.out.ISurverQuestionResponseStatusPort;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class SurverQuestionResponseStatusService implements ISurverQuestionResponseCaseUse {

	@Autowired
	private ISurverQuestionResponseStatusPort surverQuestionResponseStatusPort;

	@Override
	public Optional<List<SurverQuestionResponseStatus>> save(
			List<SurverQuestionResponseStatus> surverQuestionResponseStatus) {
		return surverQuestionResponseStatusPort.save(surverQuestionResponseStatus);
	}

}
