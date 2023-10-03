package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Survey;
import co.com.jacastro.demo.encuestas.kl.application.port.out.ISurveyPort;

@Component
public class SurveyAdapter implements ISurveyPort {

	@Autowired
	private SurveyRepository surveyRepository;
	@Autowired
	private MapperQuestion mapperQuestion;

	@Override
	public Optional<Survey> createsurvey(Survey survey) {
		List<QuestionEntity> questions = surveyRepository
				.saveAll(mapperQuestion.questionDomainToEntity(survey.getQuestions()));
		survey.setQuestions(mapperQuestion.questionEntityToDomain(questions));
		return Optional.of(survey);
	}

	@Override
	public Optional<Survey> findAll() {
		List<QuestionEntity> questionentity = surveyRepository.findAll();
		Survey survey = new Survey();
		survey.setQuestions(mapperQuestion.questionEntityToDomain(questionentity));
		return Optional.of(survey);
	}

}
