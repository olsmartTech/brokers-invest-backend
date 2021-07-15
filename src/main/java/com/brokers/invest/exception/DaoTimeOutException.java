package com.brokers.invest.exception;

public class DaoTimeOutException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1202404677230787551L;

	public DaoTimeOutException(String codError, String msjError, Exception objException) {
		super(codError, msjError, objException);
		// TODO Auto-generated constructor stub
	}

	public DaoTimeOutException(String codError, String msjError) {
		super(codError, msjError);
		// TODO Auto-generated constructor stub
	}

	public DaoTimeOutException(String msjError) {
		super(msjError);
		// TODO Auto-generated constructor stub
	}

}
