package com.hari.hibernate.exception;

public class DBException extends Exception {

	private static final long serialVersionUID = -3250526797396148102L;
	private String messgae;

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public DBException(String messgae) {
		super();
		this.messgae = messgae;
	}

	public DBException() {
		super();
	}
	
}
