package tech.philippe.sandwichstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.philippe.sandwichstore.domain.SandwichType;
import tech.philippe.sandwichstore.repository.SandwichTypeRepository;

@Service
public class SandwichTypeService extends ProductService<SandwichTypeRepository, SandwichType> {
	
	@Autowired
	public SandwichTypeService(SandwichTypeRepository sandwichTypeRepository) {
		this.repository = sandwichTypeRepository;
	}
}
