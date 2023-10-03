package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Question;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.QuestionResponse;

@Component
public class MapperQuestion {

	public List<QuestionEntity> questionDomainToEntity(List<Question> questions) {
		List<QuestionEntity> list = new LinkedList<>();
		if (questions != null && !questions.isEmpty()) {
			questions.forEach(question -> {
				QuestionEntity q = new QuestionEntity(null, question.getTitle(), null);
				q.setResponse(questionResponseDomainToEntity(q, question.getResponse()));
				list.add(q);
			});
		}
		return list;
	}

	private List<QuestionResponseEntity> questionResponseDomainToEntity(QuestionEntity questionEntity,
			List<QuestionResponse> response) {
		List<QuestionResponseEntity> list = new LinkedList<>();
		if (response != null && !response.isEmpty()) {
			response.forEach(res -> {
				QuestionResponseEntity q = new QuestionResponseEntity(null, questionEntity, res.getTitle(), false);
				list.add(q);
			});
		}
		return list;
	}

	public List<Question> questionEntityToDomain(List<QuestionEntity> questions) {
		List<Question> list = new LinkedList<>();
		if (questions != null && !questions.isEmpty()) {
			questions.forEach(q -> {
				Question question = new Question(q.getId(), q.getTitle());
				question.setResponse(questionResponseEntityToDomain(q.getResponse()));
				list.add(question);
			});
		}
		return list;
	}

	private List<QuestionResponse> questionResponseEntityToDomain(List<QuestionResponseEntity> response) {
		List<QuestionResponse> list = new LinkedList<>();
		if (response != null && !response.isEmpty()) {
			response.forEach(res -> {
				QuestionResponse q = new QuestionResponse(res.getId(), res.getQuestionId().getId(), res.getTitle());
				res.setSelected(res.isSelected());
				list.add(q);
			});
		}
		return list;
	}

}
