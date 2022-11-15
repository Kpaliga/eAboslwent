package com.example.graduate.validation.entity;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(ignore = true, target = "id")
@Mapping(ignore = true, target = "created")
@Mapping(ignore = true, target = "modified")
@Mapping(ignore = true, target = "deleted")
public @interface ToVersionedEntity {
}
