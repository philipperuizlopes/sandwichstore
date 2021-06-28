package tech.philippe.sandwichstore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.philippe.sandwichstore.domain.Topping;
import tech.philippe.sandwichstore.repository.ToppingRepository;
import tech.philippe.sandwichstore.service.ToppingService;

@RestController
@RequestMapping("/topping")
public class ToppingResource extends ProductResource<Topping, ToppingRepository, ToppingService>{

	@Autowired
	public ToppingResource(ToppingService sandwichSizeService) {
		this.service = sandwichSizeService;
	}
}
