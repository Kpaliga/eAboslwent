package com.example.graduate.service;

import com.example.graduate.model.Dictionary;
import com.example.graduate.repository.DictionaryRepository;
import com.example.openapi.model.DictionaryName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Slf4j
@Service
@Validated
@AllArgsConstructor
public class DictionaryService {
    private final DictionaryRepository repository;

    public Set<String> getItems(@NotNull DictionaryName dictionary) {
        log.info("Getting items from dictionary named: {}", dictionary);
        Dictionary entity = repository.getDictionary(dictionary.getValue());
        log.info("Items found in dictionary {}: {}", dictionary, entity.getKeys());

        return entity.getKeys();
    }

    public void addItem(@NotNull DictionaryName dictionary, @NotNull Set<String> values) {
        log.info("Adding items to dictionary named: {}", dictionary);
        Dictionary entity = repository.getDictionary(dictionary.getValue());
        entity.getKeys().addAll(values);

        Dictionary save = repository.save(entity);
        log.info("Items found in dictionary {}: {}", dictionary, save.getKeys());
    }

    public void removeItem(@NotNull DictionaryName dictionary, @NotNull Set<String> values) {
        log.info("Removing items from dictionary named: {}", dictionary);
        Dictionary entity = repository.getDictionary(dictionary.getValue());
        entity.getKeys().removeAll(values);

        Dictionary save = repository.save(entity);
        log.info("Items found in dictionary {}: {}", dictionary, save.getKeys());
    }
}
