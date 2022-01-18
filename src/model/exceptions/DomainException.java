package model.exceptions;

public class DomainException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) { //Permitir que eu possa instaciar a exceção personalizada passando uma mensagem pra ela
		super(msg);
	}

}
