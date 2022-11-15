package com.example.graduate.repository;

import com.example.graduate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

}
