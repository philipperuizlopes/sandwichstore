package tech.philippe.sandwichstore.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class SandwichType extends Product {
	private static final long serialVersionUID = 1671670630979203382L;
	
	public SandwichType() {}
	
	public SandwichType(String description, BigDecimal unitPrice, BigDecimal stockQuantity, BigDecimal servingPerNormalSize) {
		this.setDescription(description);
		this.setUnitPrice(unitPrice);
		this.setStockQuantity(stockQuantity);
		this.setServingPerNormalSize(servingPerNormalSize);
	}
	
}