package tech.philippe.sandwichstore.service.exception;

public class SandwichSizeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8614306952816161994L;

	public SandwichSizeNotFoundException() {
		super("Sandwich size not found!");
	}
}
