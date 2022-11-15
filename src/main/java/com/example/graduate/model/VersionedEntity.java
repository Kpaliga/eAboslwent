package com.example.graduate.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.OffsetDateTime;
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
public class VersionedEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @NotNull
    private OffsetDateTime created;

    @NotNull
    private OffsetDateTime modified;

    @NotNull
    private Boolean deleted = false;
}