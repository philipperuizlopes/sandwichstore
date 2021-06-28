package tech.philippe.sandwichstore.service.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8614306952816161994L;

	public ProductNotFoundException() {
		super("Product not found!");
	}
	
	public ProductNotFoundException(String product) {
		super("Product: " + product + " not found!");
	}
}
