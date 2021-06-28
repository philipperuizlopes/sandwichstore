package tech.philippe.sandwichstore.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.philippe.sandwichstore.domain.Sandwich;
import tech.philippe.sandwichstore.domain.SandwichSize;
import tech.philippe.sandwichstore.domain.SandwichType;
import tech.philippe.sandwichstore.service.exception.ProductOutOfStockException;

@Service
public class SandwichService {
	
	@Autowired
	private SandwichSizeService sandwichSizeService;
	
	@Autowired
	private SandwichTypeService sandwichTypeService;
	
	@Autowired
	private ToppingService toppingService;
	
	public BigDecimal calculateSandwichPrice(Sandwich sandwich) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		if (sandwich.getType() != null) {
			SandwichType type = sandwichTypeService.findById(sandwich.getType().getId());
			totalPrice = totalPrice.add(type.getUnitPrice());
		}
		
		if (sandwich.getToppings() != null) {
			BigDecimal toppingsTotal = sandwich.getToppings().stream().map(topping -> {
				return topping.getServingPerNormalSize().multiply(topping.getUnitPrice());
			}).reduce(BigDecimal.ZERO, BigDecimal::add);
			
			totalPrice = totalPrice.add(toppingsTotal);
		}
		
		if (sandwich.getSize() != null) {			
			SandwichSize size = sandwichSizeService.findById(sandwich.getSize().getId());
			totalPrice = totalPrice.multiply(size.getMultiplier());
		}
		
		return totalPrice;
	}
	
	public Sandwich orderSandwich(Sandwich sandwich) throws ProductOutOfStockException{
		sandwich.setTotalPrice(calculateSandwichPrice(sandwich));
		final SandwichSize sandwichSize = sandwich.getSize();

		BigDecimal quantitySandwichType = sandwich.getType().getServingPerNormalSize().multiply(sandwichSize.getMultiplier()).setScale(0, RoundingMode.HALF_EVEN);
		sandwichTypeService.deduceStock(sandwich.getType(), quantitySandwichType);
		
		if (sandwich.getToppings() != null) {
			sandwich.getToppings().forEach(topping -> {
				BigDecimal quantityTopping = topping.getServingPerNormalSize().multiply(sandwichSize.getMultiplier()).setScale(0, RoundingMode.HALF_EVEN);
				toppingService.deduceStock(topping, quantityTopping);
			});
			
		}
		return sandwich;	
	}
}
