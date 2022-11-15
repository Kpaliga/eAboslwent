package com.example.graduate.model;

import com.example.graduate.validation.DictionaryKey;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

import static com.example.graduate.validation.Dictionaries.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class Student extends VersionedEntity {

    //Snapshot
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String photoId;

    //Details
    @Email
    @NotNull
    private String mail;

    @NotNull
    private String yearbook;

    @NotNull
    @DictionaryKey(FORM_OF_STUDY)
    private String formOfStudy;

    @NotNull
    @DictionaryKey(FIELD_OF_STUDY)
    private String fieldOfStudy;

    @NotNull
    @DictionaryKey(SPECIALIZATION)
    private String specialization;

    @ElementCollection
    private List<@DictionaryKey(AWARDS) String> awards = new ArrayList<>();
}
