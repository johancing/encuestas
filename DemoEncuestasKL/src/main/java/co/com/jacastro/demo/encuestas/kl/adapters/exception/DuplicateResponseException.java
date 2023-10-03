package co.com.jacastro.demo.encuestas.kl.adapters.exception;

public class DuplicateResponseException extends RuntimeException {

	private static final long serialVersionUID = -755483727036724795L;
	
	public DuplicateResponseException(String message) {
		super(message);
	}

}
