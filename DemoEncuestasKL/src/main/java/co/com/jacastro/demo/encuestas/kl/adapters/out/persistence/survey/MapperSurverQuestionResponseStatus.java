package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.SurverQuestionResponseStatus;

@Component
public class MapperSurverQuestionResponseStatus {

	public List<SurverQuestionResponseStatusEntity> getDomainToEntity(
			List<SurverQuestionResponseStatus> surverQuestionResponseStatus) {
		List<SurverQuestionResponseStatusEntity> responseList = new LinkedList<>();
		if (surverQuestionResponseStatus != null && !surverQuestionResponseStatus.isEmpty()) {
			surverQuestionResponseStatus
					.forEach(response -> responseList.add(new SurverQuestionResponseStatusEntity(response.getUsername(),
							response.getQuestionResponseId(), response.isSeleted())));
			return responseList;
		}
		return responseList;
	}

	public List<SurverQuestionResponseStatus> getEntityToDomain(
			List<SurverQuestionResponseStatusEntity> surverQuestionResponseStatus) {
		List<SurverQuestionResponseStatus> responseList = new LinkedList<>();
		if (surverQuestionResponseStatus != null && !surverQuestionResponseStatus.isEmpty()) {
			surverQuestionResponseStatus
					.forEach(response -> responseList.add(new SurverQuestionResponseStatus(response.getId(),
							response.getUsername(), response.getQuestionResponseId(), response.isSelected())));
			return responseList;
		}
		return responseList;
	}

}
