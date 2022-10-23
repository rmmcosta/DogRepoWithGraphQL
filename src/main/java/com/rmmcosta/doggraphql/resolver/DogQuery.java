package com.rmmcosta.doggraphql.resolver;

import com.rmmcosta.doggraphql.entity.Dog;
import com.rmmcosta.doggraphql.exception.DogException;
import com.rmmcosta.doggraphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class DogQuery {
    @Autowired
    private DogRepository dogRepository;

    @QueryMapping
    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    @QueryMapping
    public Dog findDogById(@Argument Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogException(id);
        }
    }
}
