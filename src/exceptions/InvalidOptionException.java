package exceptions;

public class InvalidOptionException extends Exception {

	public InvalidOptionException(String message) {
	
		super("\nLa opci�n seleccionada no es v�lida.\n"+message);
	}

}
