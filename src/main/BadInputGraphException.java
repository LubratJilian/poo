package main;

public class BadInputGraphException extends IllegalArgumentException {

	public BadInputGraphException(String input) {
		super(input);
	}
}
