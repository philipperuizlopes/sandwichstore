package tech.philippe.sandwichstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.philippe.sandwichstore.domain.SandwichSize;
import tech.philippe.sandwichstore.repository.SandwichSizeRepository;

@Service
public class SandwichSizeService extends BaseEntityService<SandwichSizeRepository, SandwichSize>{
	
	@Autowired
	public SandwichSizeService(SandwichSizeRepository sandwichSizeRepository) {
		this.repository = sandwichSizeRepository;
	}
}
