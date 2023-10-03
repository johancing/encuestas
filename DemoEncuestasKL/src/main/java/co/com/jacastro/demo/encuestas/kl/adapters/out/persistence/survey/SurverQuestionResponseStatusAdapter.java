package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.SurverQuestionResponseStatus;
import co.com.jacastro.demo.encuestas.kl.application.port.out.ISurverQuestionResponseStatusPort;

@Component
public class SurverQuestionResponseStatusAdapter implements ISurverQuestionResponseStatusPort {

	@Autowired
	private SurverQuestionResponseStatusRepository surverQuestionResponseStatusRepository;
	@Autowired
	private MapperSurverQuestionResponseStatus mapper;

	@Override
	public Optional<List<SurverQuestionResponseStatus>> save(
			List<SurverQuestionResponseStatus> surverQuestionResponseStatus) {
		List<SurverQuestionResponseStatusEntity> response = surverQuestionResponseStatusRepository
				.saveAll(mapper.getDomainToEntity(surverQuestionResponseStatus));
		if (!response.isEmpty()) {
			List<SurverQuestionResponseStatus> sendResponse = mapper.getEntityToDomain(response);
			return Optional.of(sendResponse);
		}
		return Optional.empty();
	}

}
