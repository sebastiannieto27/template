package co.com.core.services;

/**
 * Base class for exceptions at the service layer
 * @author hencabal
 *
 */
public class ServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3585313074000609705L;

	public ServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
