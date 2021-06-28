package tech.philippe.sandwichstore.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tech.philippe.sandwichstore.domain.BaseEntity;
import tech.philippe.sandwichstore.repository.BaseEntityRepository;
import tech.philippe.sandwichstore.service.BaseEntityService;

public abstract class BaseEntityResource<E extends BaseEntity, R extends BaseEntityRepository<E>,S extends BaseEntityService<R, E>> {

	@Autowired
	protected S service;
	
	@GetMapping("/all")
    public ResponseEntity<List<E>> getAllEntitys () {
        List<E> entities = service.findAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<E> getEntityById (@PathVariable("id") Long id) {
        E entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<E> addEntity(@RequestBody E entity) {
        E newEntity = service.save(entity);
        return new ResponseEntity<>(newEntity, HttpStatus.CREATED);
    }
    
    @PostMapping("/add/all")
    public ResponseEntity<List<E>> addAllEntity(@RequestBody List<E> entities) {
        entities.forEach(e -> e = service.save(e));
        return new ResponseEntity<>(entities, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<E> updateEntity(@RequestBody E entity) {
        E updatedEntity = service.save(entity);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable("id") Long id) {
    	service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
