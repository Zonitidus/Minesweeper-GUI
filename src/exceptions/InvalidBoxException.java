package exceptions;

public class InvalidBoxException extends Exception {

	public InvalidBoxException(String message) {
		super("Error ---> "+message);

	}

}
