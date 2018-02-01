package cn.edu.nwsuaf.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}

}
