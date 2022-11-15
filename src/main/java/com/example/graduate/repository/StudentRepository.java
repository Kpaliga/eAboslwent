package com.example.graduate.repository;

import com.example.graduate.model.Student;
import com.example.openapi.model.StudentFindRequest;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.example.graduate.model.QStudent.student;


@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>, QuerydslPredicateExecutor<Student> {
    @NotNull
    default List<Student> findAll(@NotNull StudentFindRequest request) {
        return StreamSupport.stream(findAll(genPredicate(request)).spliterator(), false)
                .collect(Collectors.toList());
    }

    default Predicate genPredicate(@NotNull StudentFindRequest request) {

        return student.deleted.eq(Boolean.FALSE)
                .and(student.name.eq(request.getName()))
                .and(student.surname.eq(request.getSurname()))
                .and(student.mail.eq(request.getMail()))
                .and(student.yearbook.eq(request.getYearbook()))
                .and(student.formOfStudy.eq(request.getFormOfStudy()))
                .and(student.fieldOfStudy.eq(request.getFieldOfStudy()))
                .and(student.specialization.eq(request.getSpecialization()));
    }
}
