package co.com.jacastro.demo.encuestas.kl.adapters.in.web;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.jacastro.demo.encuestas.kl.adapters.exception.DuplicateResponseException;
import co.com.jacastro.demo.encuestas.kl.adapters.exception.SurveyException;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.Question;
import co.com.jacastro.demo.encuestas.kl.application.domain.model.SurverQuestionResponseStatus;
import co.com.jacastro.demo.encuestas.kl.application.port.in.ISurverQuestionResponseCaseUse;
import co.com.jacastro.demo.encuestas.kl.application.port.in.ISurveyCaseUse;

@RestController
@RequestMapping("/demo/kl/api/v1/survey")
public class SurveyController {

	@Autowired
	private ISurveyCaseUse surveyCaseUse;
	@Autowired
	private ISurverQuestionResponseCaseUse surverQuestionResponseCaseUse;

	@GetMapping("/getsurvey")
	public ResponseEntity<List<Question>> getSurvey() {
		Optional<List<Question>> list = surveyCaseUse.findAll();
		if (!list.isPresent()) {
			throw new SurveyException("Survey not found.");
		}
		return ResponseEntity.ok(list.get());
	}

	@PostMapping("/create")
	public ResponseEntity<BodyBuilder> saveSurvey(@RequestBody List<Question> questions) {
		Optional<List<Question>> qOP = surveyCaseUse.createSurvey(questions);
		if (!qOP.isPresent()) {
			throw new SurveyException("Survey not created.");
		}
		return ResponseEntity.created(URI.create("/demo/kl/api/v1/survey/getsurvey")).build();
	}

	@PostMapping("/responses")
	public ResponseEntity<List<SurverQuestionResponseStatus>> insertResponsesFromSurvey(
			@RequestBody List<SurverQuestionResponseStatus> surverQuestionResponseStatus) {
		try {
			Optional<List<SurverQuestionResponseStatus>> response = surverQuestionResponseCaseUse
					.save(surverQuestionResponseStatus);
			if (!response.isPresent()) {
				throw new SurveyException("Survey questions and responses not created.");
			}
			return ResponseEntity.ok(response.get());
		} catch (Exception e) {
			if (e.getMessage().contains("ERROR: llave duplicada")) {
				throw new DuplicateResponseException("Error, diplicate response for survey.");
			}
		}
		return ResponseEntity.ok(new ArrayList<>());
	}
	
	@GetMapping("/stadistics")
	public ResponseEntity<?> getStadistics() {
		return ResponseEntity.accepted().build();
	}

}
