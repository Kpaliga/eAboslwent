package com.example.graduate.repository;

import com.example.graduate.exception.DictionaryNotFoundException;
import com.example.graduate.model.Dictionary;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, String> {

    default Dictionary getDictionary(@NotNull String name) {
        return Optional.of(getReferenceById(name)).orElseThrow(() ->
                new DictionaryNotFoundException(name)
        );
    }

    default Boolean contains(@NotNull String name, @NotNull String key) {
        return getDictionary(name).getKeys().contains(key);
    }
}
