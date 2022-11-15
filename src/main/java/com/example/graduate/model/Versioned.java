package com.example.graduate.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode(of = "id")
@FieldNameConstants(asEnum = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Versioned {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @NotNull
    private LocalDate created = LocalDate.now();

    @NotNull
    private LocalDate modified = LocalDate.now();

    @NotNull
    private Boolean deleted = false;
}