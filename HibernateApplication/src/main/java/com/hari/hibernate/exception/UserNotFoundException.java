package com.hari.hibernate.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2794439282803104625L;
	private String messgae;

	public String getMessgae() {
		return messgae;
	}  

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public UserNotFoundException(String messgae) {
		super();
		this.messgae = messgae;
	}

	public UserNotFoundException() {
		super();
	}
	
}
