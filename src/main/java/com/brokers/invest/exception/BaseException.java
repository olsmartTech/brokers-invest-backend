package com.brokers.invest.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private Exception objException;
	private String codError;
	private String msjError;

	public BaseException(String codError, String msjError,
			Exception objException) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
		this.objException = objException;
	}

	public BaseException(String codError, String msjError) {
		super(msjError);
		this.codError = codError;
		this.msjError = msjError;
	}

	public BaseException(String msjError) {
		super(msjError);
		this.msjError = msjError;
	}

	public Exception getObjException() {
		return objException;
	}

	public void setObjException(Exception objException) {
		this.objException = objException;
	}

	public String getCodError() {
		return codError;
	}

	public void setCodError(String codError) {
		this.codError = codError;
	}

	public String getMsjError() {
		return msjError;
	}

	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

}
