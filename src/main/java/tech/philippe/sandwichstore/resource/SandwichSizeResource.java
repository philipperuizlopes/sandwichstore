package tech.philippe.sandwichstore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.philippe.sandwichstore.domain.SandwichSize;
import tech.philippe.sandwichstore.repository.SandwichSizeRepository;
import tech.philippe.sandwichstore.service.SandwichSizeService;

@RestController
@RequestMapping("/sandwich-size")
public class SandwichSizeResource extends BaseEntityResource<SandwichSize, SandwichSizeRepository, SandwichSizeService>{

	@Autowired
	public SandwichSizeResource(SandwichSizeService sandwichSizeService) {
		this.service = sandwichSizeService;
	}
}