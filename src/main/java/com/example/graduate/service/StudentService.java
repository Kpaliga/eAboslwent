package com.example.graduate.service;

import com.example.graduate.model.Student;
import com.example.graduate.repository.StudentRepository;
import com.example.openapi.model.StudentCreateRequest;
import com.example.openapi.model.StudentDetails;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.UUID;

import static com.example.graduate.mapper.StudentMapper.MAPPER;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public StudentDetails addStudent(@NotNull StudentCreateRequest request) {
        Student student = MAPPER.studentEntity(request);
        repository.saveAndFlush(student);

        return MAPPER.studentDetails(student);
    }

    public StudentDetails getStudent(UUID studentId) {
        Student byId = repository.getReferenceById(studentId);

        return MAPPER.studentDetails(byId);
    }
}
