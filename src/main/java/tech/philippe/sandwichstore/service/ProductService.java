package tech.philippe.sandwichstore.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import tech.philippe.sandwichstore.domain.Product;
import tech.philippe.sandwichstore.repository.ProductRepository;
import tech.philippe.sandwichstore.service.exception.ProductNotFoundException;
import tech.philippe.sandwichstore.service.exception.ProductOutOfStockException;

public class ProductService<R extends ProductRepository<E>, E extends Product> extends BaseEntityService<R, E> {
	
	@Autowired
	protected R repository;
	
	public void addToStock(E entity, BigDecimal quantity) throws ProductNotFoundException {
		entity = findById(entity.getId());
		entity.setStockQuantity(entity.getStockQuantity().add(quantity));
		save(entity);
	}
	
	public void deduceStock(E entity, BigDecimal quantity) throws ProductOutOfStockException, ProductNotFoundException {
		entity = findById(entity.getId());
		entity.setStockQuantity(entity.getStockQuantity().subtract(quantity));
		if (entity.getStockQuantity().compareTo(BigDecimal.ZERO) < 0) {
			throw new ProductOutOfStockException(entity.getDescription());
		}
		save(entity);
	}
}
