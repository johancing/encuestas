package co.com.jacastro.demo.encuestas.kl.adapters.exception;

import java.net.URI;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String ERROR_CATEGORY = "errorCategory";
	private static final String TIMESTAMP = "timestamp";
	
	@ExceptionHandler(SurveyException.class)
	public ProblemDetail handleSurveyNotCreatedException(SurveyException e) {
		ProblemDetail err = ProblemDetail.forStatusAndDetail(HttpStatus.EXPECTATION_FAILED, e.getMessage());
		err.setTitle("Survey not created.");
		err.setType(URI.create("/demo/kl/api/v1/survey/create"));
	    err.setProperty(ERROR_CATEGORY, "Expectation failed");
        err.setProperty(TIMESTAMP, new Date(System.currentTimeMillis()));
		return err;
	}

	@ExceptionHandler(UserException.class)
	public ProblemDetail handleUserNotCreatedException(UserException e) {
		ProblemDetail err = ProblemDetail.forStatusAndDetail(HttpStatus.EXPECTATION_FAILED, e.getMessage());
		err.setTitle("User not created.");
		err.setType(URI.create("/demo/kl/users/createuser"));
	    err.setProperty(ERROR_CATEGORY, "Expectation failed");
        err.setProperty(TIMESTAMP, new Date(System.currentTimeMillis()));
		return err;
	}
	
	@ExceptionHandler(DuplicateResponseException.class)
	public ProblemDetail handleDuplicateResponseException(DuplicateResponseException e) {
		ProblemDetail err = ProblemDetail.forStatusAndDetail(HttpStatus.EXPECTATION_FAILED, e.getMessage());
		err.setTitle("Duplicated response for survey.");
		err.setType(URI.create("/demo/kl/api/v1/survey/responses"));
	    err.setProperty(ERROR_CATEGORY, "bussinnes logic.");
        err.setProperty(TIMESTAMP, new Date(System.currentTimeMillis()));
		return err;
	}

}
