package co.com.jacastro.demo.encuestas.kl.application.domain.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Question;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.QuestionResponse;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Survey;
import co.com.jacastro.demo.encuestas.kl.application.port.in.ISurveyCaseUse;
import co.com.jacastro.demo.encuestas.kl.application.port.out.ISurveyPort;
import jakarta.transaction.Transactional;

@Component
public class SurveyService implements ISurveyCaseUse {

	@Autowired
	private ISurveyPort surveyPort;

	@Override
	@Transactional
	public Optional<List<Question>> createSurvey(List<Question> questions) {
		if (questions != null && !questions.isEmpty()) {
			for (int i = 0; i < questions.size(); i++) {
				questions.get(i).setId(i + 1);
				processResponses(questions.get(i).getId(), questions.get(i).getResponse());
			}
			Survey survey = new Survey();
			survey.setQuestions(questions);
			Optional<Survey> surveyOp = surveyPort.createsurvey(survey);
			if (surveyOp.isPresent())
				return Optional.of(survey.getQuestions());
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Question>> findAll() {
		Optional<Survey> sOP = surveyPort.findAll();
		if (sOP.isPresent())
			return Optional.of(sOP.get().getQuestions());
		return Optional.empty();
	}

	private void processResponses(Integer questionId, List<QuestionResponse> response) {
		if (response != null && !response.isEmpty()) {
			for (QuestionResponse qr : response) {
				qr.setQuestionId(questionId);
			}
		}
	}

}
