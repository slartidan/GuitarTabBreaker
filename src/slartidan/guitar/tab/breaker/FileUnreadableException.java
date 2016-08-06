package slartidan.guitar.tab.breaker;

import java.io.IOException;

/**
 * If the input cannot be read.
 */
public class FileUnreadableException extends RuntimeException {

	/**
	 * Default constructor
	 * @param cause
	 */
	public FileUnreadableException(IOException cause) {
		super(cause);
	}

}
