package com.ly.common.exception;
/**
 * 业务逻辑异常
 * @author ly
 *
 */
public class BusException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusException() {
		super();
	}

	public BusException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusException(String message) {
		super(message);
	}

	public BusException(Throwable cause) {
		super(cause);
	}

	public static void main(String[] args) {
		try{
			String test = null;
			test.charAt(1);
		}catch(NullPointerException e){
			System.out.println("eee");
		}
	}
}
