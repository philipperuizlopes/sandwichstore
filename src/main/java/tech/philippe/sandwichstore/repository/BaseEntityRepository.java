package tech.philippe.sandwichstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.philippe.sandwichstore.domain.BaseEntity;

public interface BaseEntityRepository<E extends BaseEntity> extends JpaRepository<E, Long>  {

}
