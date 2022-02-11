package com.github.mauricioaraujomonteiro.infra.exception;

public class RetryException extends RuntimeException {
    public RetryException(String message) {
        super(message);
    }
}
