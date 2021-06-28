package tech.philippe.sandwichstore.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class SandwichSize extends BaseEntity {
	private static final long serialVersionUID = -2723139820602047728L;
	
	private String name;
	private BigDecimal multiplier;
	
	public SandwichSize() {}

	public SandwichSize(String name, BigDecimal multiplier) {
		this.name = name;
		this.multiplier = multiplier;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMultiplier() {
		return multiplier;
	}
	
	public void setMultiplier(BigDecimal price) {
		this.multiplier = price;
	}
}
