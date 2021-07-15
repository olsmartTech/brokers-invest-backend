package com.brokers.invest.exception;

public class DaoException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7740873595465115726L;

	public DaoException(String codError, String msjError, Exception objException) {
		super(codError, msjError, objException);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String codError, String msjError) {
		super(codError, msjError);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String msjError) {
		super(msjError);
		// TODO Auto-generated constructor stub
	}

}
