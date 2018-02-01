package cn.edu.nwsuaf.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(String msg, Throwable e) {
		super(msg, e);
	}

}
