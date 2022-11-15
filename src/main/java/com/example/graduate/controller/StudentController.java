package com.example.graduate.controller;

import com.example.graduate.service.StudentService;
import com.example.openapi.api.StudentApi;
import com.example.openapi.model.StudentCreateRequest;
import com.example.openapi.model.StudentDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {

    private final StudentService service;

    @Override
    public ResponseEntity<StudentDetails> addStudent(StudentCreateRequest request) {
        return ResponseEntity.ok(service.addStudent(request));
    }

    @Override
    public ResponseEntity<StudentDetails> getStudent(UUID studentId) {
        return ResponseEntity.ok(service.getStudent(studentId));
    }
}
