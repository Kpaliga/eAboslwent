package com.example.graduate.exception;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class ApplicationProblemException extends RuntimeException {
    private final String errorCode;
    private final HttpStatus httpStatus;
}
