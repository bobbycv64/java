package cv64.jsp.exception;

import java.lang.Exception;

/**
 *  <code>ExceptionHandler</code> displays the method that had the exception,
 *  the exception and stacktrace.
 *
 *  @author cv64, Inc.
 */

public class ExceptionHandler extends Exception {

	public ExceptionHandler(Exception exception, String message) {

		super();
		if (exception != null) {
			System.err.println(message);
			exception.getMessage();
			exception.printStackTrace();
			exception.toString();
		}
	}

	public ExceptionHandler(String exception, String message) {

		super();
		if (exception != null) {
			System.err.println(message);
		}
	}
}

