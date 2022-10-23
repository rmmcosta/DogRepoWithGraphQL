package com.rmmcosta.doggraphql.mutator;

import com.rmmcosta.doggraphql.entity.Dog;
import com.rmmcosta.doggraphql.exception.DogException;
import com.rmmcosta.doggraphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class DogMutator {
    @Autowired
    private DogRepository dogRepository;

    @MutationMapping
    public Dog newDog(@Argument String name, @Argument String breed,
                      @Argument String origin) {

        Dog dog = new Dog(name, breed, origin);
        dog = dogRepository.save(dog);
        return dog;
    }

    @MutationMapping
    public Dog updateDogName(@Argument String newName, @Argument Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dog = dogRepository.save(dog);
            return dog;
        } else {
            throw new DogException(id);
        }
    }

    @MutationMapping
    public boolean deleteDog(@Argument Long id) {
        try {
            dogRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
