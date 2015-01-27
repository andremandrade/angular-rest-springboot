package br.edu.ufcg.embedded.smart.domain.repository.exception;

public class ObjectNotPersistableException extends Exception{

	private static final long serialVersionUID = -8337784877516972379L;
	
	public ObjectNotPersistableException(String message) {
		super(message);
	}

}
