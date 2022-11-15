package com.example.graduate.exception;

import org.springframework.http.HttpStatus;

public class DictionaryNotFoundException extends ApplicationProblemException {

    public DictionaryNotFoundException(String dictionary) {
        super(String.format("Dictionary: %s does not exist", dictionary), HttpStatus.BAD_REQUEST);
    }
}
