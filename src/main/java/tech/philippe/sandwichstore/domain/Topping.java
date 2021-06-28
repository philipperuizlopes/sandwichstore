package tech.philippe.sandwichstore.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Topping extends Product {
	private static final long serialVersionUID = 1L;
	
	public Topping() {}
	
	public Topping(String description, BigDecimal unitPrice, BigDecimal stockQuantity, BigDecimal servingPerNormalSize) {
		this.setDescription(description);
		this.setUnitPrice(unitPrice);
		this.setStockQuantity(stockQuantity);
		this.setServingPerNormalSize(servingPerNormalSize);
	}
}
