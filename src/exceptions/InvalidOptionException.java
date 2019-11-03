package exceptions;

public class InvalidOptionException extends Exception {

	public InvalidOptionException(String message) {
	
		super("\nLa opción seleccionada no es válida.\n"+message);
	}

}
