package br.com.caelum.jdbc.exception;

public class DAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String msg;
		
	public DAOException(String msg){
		super(msg);
		this.msg = msg;		
	}
	
	public String getMessage(){
		return msg;
	}
	
}
