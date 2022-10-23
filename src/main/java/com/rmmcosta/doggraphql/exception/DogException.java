package com.rmmcosta.doggraphql.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogException extends RuntimeException implements GraphQLError {
    private Map<String, Long> extensions = new HashMap<>();

    public DogException(Long dogId) {
        super("Dog not found for the given Id!");
        extensions.put("InvalidDogId", dogId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return GraphQLError.super.getExtensions();
    }
}
