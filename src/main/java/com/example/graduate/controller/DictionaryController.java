package com.example.graduate.controller;

import com.example.graduate.service.DictionaryService;
import com.example.openapi.api.DictionaryApi;
import com.example.openapi.model.DictionaryName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.springframework.http.ResponseEntity.noContent;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class DictionaryController implements DictionaryApi {

    private final DictionaryService service;

    @Override
    public ResponseEntity<Set<String>> getItems(DictionaryName dictionary) {
        return ResponseEntity.ok(service.getItems(dictionary));
    }

    @Override
    public ResponseEntity<Set<String>> addItem(DictionaryName dictionary, Set<String> values) {
        service.addItem(dictionary, values);
        return noContent().build();
    }

    @Override
    public ResponseEntity<Set<String>> removeItem(DictionaryName dictionary, Set<String> values) {
        service.removeItem(dictionary, values);
        return noContent().build();
    }
}
