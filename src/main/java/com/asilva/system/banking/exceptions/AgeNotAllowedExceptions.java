package com.asilva.system.banking.exceptions;

public class AgeNotAllowedExceptions extends Exception {
	
	private static final long serialVersionUID = 1L;
	public static String MSG_INVALID_AGE = "A idade do cliente precisa estar entre 18 e 65 anos.";
	
	public AgeNotAllowedExceptions(String msg) {
		super(msg);
	}

}
