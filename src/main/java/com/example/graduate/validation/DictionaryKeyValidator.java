package com.example.graduate.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


public class DictionaryKeyValidator implements ConstraintValidator<DictionaryKey, String> {
    private Service service;
    private String dictionary;


    @Override
    public void initialize(DictionaryKey annotation) {
        this.dictionary = annotation.dictionary();
    }

    @Override
    public boolean isValid(String key, ConstraintValidatorContext context) {
        return Objects.isNull(key) || service.translationExist(dictionary, key);
    }


    public interface Service {
        boolean translationExist(@NotBlank String var1, @NotBlank String var2);
    }
}
