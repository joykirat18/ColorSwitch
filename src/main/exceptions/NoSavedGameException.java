package main.exceptions;

public class NoSavedGameException extends Exception {
	public NoSavedGameException(String message) {
		super(message);
	}

}