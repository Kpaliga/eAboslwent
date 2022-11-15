package com.example.graduate.validation.dictionary;

import com.example.graduate.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

@Component
public class DictionaryKeyValidator implements ConstraintValidator<DictionaryKey, String> {

    private String dictionary;
    private static DictionaryRepository service;

    @Autowired
    public void setService(DictionaryRepository service) {
        DictionaryKeyValidator.service = service;
    }

    @Override
    public void initialize(DictionaryKey annotation) {
        this.dictionary = annotation.value();
    }

    @Override
    public boolean isValid(String key, ConstraintValidatorContext context) {
        setCustomConstraintViolation(key, context);
        return Objects.isNull(key) || service.contains(dictionary, key);
    }

    private void setCustomConstraintViolation(String key, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                String.format("Unfortunately key {%s} doesn't exist in dictionary {%s}", key, dictionary)
        ).addConstraintViolation();
    }
}


