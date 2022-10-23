package com.rmmcosta.doggraphql.resolver;

import com.rmmcosta.doggraphql.exception.DogException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.graph.Graph;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DogExceptionResolver extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof DogException) {
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.NOT_FOUND)
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        } else {
            return null;
        }
    }
}
