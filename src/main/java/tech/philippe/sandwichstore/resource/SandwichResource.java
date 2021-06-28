package tech.philippe.sandwichstore.resource;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.philippe.sandwichstore.domain.Sandwich;
import tech.philippe.sandwichstore.service.SandwichService;
import tech.philippe.sandwichstore.service.exception.ProductOutOfStockException;

@RestController
@RequestMapping("/sandwich")
public class SandwichResource {

	@Autowired
	private SandwichService sandwichService;
	
	@PostMapping("/calculate-price")
    public ResponseEntity<BigDecimal> calculatePrice(@RequestBody Sandwich sandwich) {
        return new ResponseEntity<>(sandwichService.calculateSandwichPrice(sandwich), HttpStatus.OK);
    }
	
	@PostMapping("/order")
    public ResponseEntity<Sandwich> order(@RequestBody Sandwich sandwich) {
		sandwich = sandwichService.orderSandwich(sandwich);
        return new ResponseEntity<>(sandwich, HttpStatus.OK);
    }
	
	@ExceptionHandler({ ProductOutOfStockException.class })
	public ResponseEntity<Object> handleProductOutOfStockException(ProductOutOfStockException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
