package tech.philippe.sandwichstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.philippe.sandwichstore.domain.Topping;
import tech.philippe.sandwichstore.repository.ToppingRepository;

@Service
public class ToppingService extends ProductService<ToppingRepository, Topping> {
	
	@Autowired
	public ToppingService(ToppingRepository toppingRepository) {
		this.repository = toppingRepository;
	}
}
