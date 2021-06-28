package tech.philippe.sandwichstore.domain;

import java.math.BigDecimal;
import java.util.List;

public class Sandwich {
	private SandwichSize size;
	private SandwichType type;
	private BigDecimal totalPrice;
	private List<Topping> toppings;
	
	public SandwichSize getSize() {
		return size;
	}
	
	public void setSize(SandwichSize size) {
		this.size = size;
	}

	public SandwichType getType() {
		return type;
	}

	public void setType(SandwichType type) {
		this.type = type;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}	
}
