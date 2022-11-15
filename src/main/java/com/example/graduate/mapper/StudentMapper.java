package com.example.graduate.mapper;

import com.example.graduate.model.Student;
import com.example.graduate.validation.entity.ToVersionedEntity;
import com.example.openapi.model.StudentCreateRequest;
import com.example.openapi.model.StudentDetails;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StudentMapper {

    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    @ToVersionedEntity
    @Mapping(target = "awards", ignore = true)
    Student studentEntity(StudentCreateRequest request);


    StudentDetails studentDetails(Student student);
}
