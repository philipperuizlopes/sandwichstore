package tech.philippe.sandwichstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tech.philippe.sandwichstore.domain.BaseEntity;
import tech.philippe.sandwichstore.repository.BaseEntityRepository;
import tech.philippe.sandwichstore.service.exception.ProductNotFoundException;

public class BaseEntityService<R extends BaseEntityRepository<E>, E extends BaseEntity> {
	
	@Autowired
	protected R repository;
	
	public E save(E entity) {
		return repository.save(entity);
	}
	
	public List<E> findAll() {
		return repository.findAll();
	}
	
	public E findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException());
	}
	
	public void deleteById(Long id) {
		repository.delete(findById(id));
	}
}
