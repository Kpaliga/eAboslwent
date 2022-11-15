package com.example.graduate.validation;

public class DictionaryKeyValidatorAdapter implements DictionaryKeyValidator.Service{

    @Override
    public boolean translationExist(String var1, String var2) {
        return true;
    }
}
