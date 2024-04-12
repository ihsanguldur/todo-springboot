package com.serphenix.todo.infra.exception;

public class DataFetchException extends RuntimeException {
    public DataFetchException(String message) {
        super(message);
    }
}
