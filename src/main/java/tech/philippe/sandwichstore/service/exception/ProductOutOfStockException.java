package tech.philippe.sandwichstore.service.exception;

public class ProductOutOfStockException extends RuntimeException {
	private static final long serialVersionUID = 8614306952816161994L;

	public ProductOutOfStockException(String product) {
		super("Product: '" + product + "' is out of stock!");
	}
}
