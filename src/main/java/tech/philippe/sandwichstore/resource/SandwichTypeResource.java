package tech.philippe.sandwichstore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.philippe.sandwichstore.domain.SandwichType;
import tech.philippe.sandwichstore.repository.SandwichTypeRepository;
import tech.philippe.sandwichstore.service.SandwichTypeService;

@RestController
@RequestMapping("/sandwich-type")
public class SandwichTypeResource  extends ProductResource<SandwichType, SandwichTypeRepository, SandwichTypeService>{

	@Autowired
	public SandwichTypeResource(SandwichTypeService sandwichSizeService) {
		this.service = sandwichSizeService;
	}
}
