package co.com.jacastro.demo.encuestas.kl.application.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey.MapperQuestion;
import co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey.QuestionEntity;
import co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey.QuestionResponseEntity;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Question;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.QuestionResponse;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Survey;

@SpringBootTest
class SurveyServiceTest {
	
	@Autowired
	SurveyService surveyService;
	@Autowired
	MapperQuestion mapperQuestion;
	
	@Test
	void createSurveyTest() {
		Survey survey = new Survey();
		survey.getQuestions().add(new Question(null, "Pregunta 1."));
		survey.getQuestions().add(new Question(null, "Pregunta 2."));
		survey.getQuestions().get(0).getResponse().add(new QuestionResponse(null, null, "Response 1."));
		survey.getQuestions().get(0).getResponse().add(new QuestionResponse(null, null, "Response 2."));
		survey.getQuestions().get(1).getResponse().add(new QuestionResponse(null, null, "Response a."));
		survey.getQuestions().get(1).getResponse().add(new QuestionResponse(null, null, "Response b."));
		survey.getQuestions().get(1).getResponse().add(new QuestionResponse(null, null, "Response c."));
		survey.getQuestions().get(1).getResponse().add(new QuestionResponse(null, null, "Response d."));
		Optional<List<Question>> list = surveyService.createSurvey(survey.getQuestions());
		assertEquals(1, list.get().get(0).getId());
		assertEquals(2, list.get().get(1).getId());
	}
	
	@Test
	void questionEntityToDomain() {
		List<QuestionEntity> list = new LinkedList<>();
		list.add(new QuestionEntity(1, "01", null));
		list.add(new QuestionEntity(2, "02", null));
		list.add(new QuestionEntity(3, "03", null));
		list.add(new QuestionEntity(4, "04", null));
		list.get(0).getResponse().add(new QuestionResponseEntity(1, list.get(0), "T1", false));
		list.get(0).getResponse().add(new QuestionResponseEntity(2, list.get(0), "T2", false));
		list.get(0).getResponse().add(new QuestionResponseEntity(3, list.get(0), "T3", false));
		list.get(1).getResponse().add(new QuestionResponseEntity(1, list.get(1), "Z1", false));
		list.get(1).getResponse().add(new QuestionResponseEntity(2, list.get(1), "Z2", false));
		List<Question> questions = mapperQuestion.questionEntityToDomain(list);
		assertEquals(1, list.get(0).getId());
		assertEquals("01", questions.get(0).getTitle());
		assertEquals("T1", questions.get(0).getResponse().get(0).getTitle());
	}

}
