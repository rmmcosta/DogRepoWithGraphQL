package com.rmmcosta.doggraphql.repository;

import com.rmmcosta.doggraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
