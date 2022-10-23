package com.rmmcosta.doggraphql.exception;

public class DogException extends RuntimeException {
    public DogException(Long dogId) {
        super("Dog not found for the Id " + dogId + "!");
    }
}
