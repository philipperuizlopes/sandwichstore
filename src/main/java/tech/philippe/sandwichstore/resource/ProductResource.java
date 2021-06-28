package tech.philippe.sandwichstore.resource;

import tech.philippe.sandwichstore.domain.Product;
import tech.philippe.sandwichstore.repository.ProductRepository;
import tech.philippe.sandwichstore.service.ProductService;

public abstract class ProductResource<E extends Product, R extends ProductRepository<E>,S extends ProductService<R, E>> extends BaseEntityResource<E, R, S>{

}
