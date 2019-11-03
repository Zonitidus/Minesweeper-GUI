package exceptions;

public class InvalidDifficultyException extends Exception {

	public InvalidDifficultyException(String message) {
		super("Nivel de dificultad inválido "+message);
		
	}

}
