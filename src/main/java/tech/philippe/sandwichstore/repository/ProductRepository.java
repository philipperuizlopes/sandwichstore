package tech.philippe.sandwichstore.repository;

import tech.philippe.sandwichstore.domain.Product;

public interface ProductRepository<E extends Product> extends BaseEntityRepository<E> {

}
