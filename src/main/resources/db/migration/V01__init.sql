CREATE TABLE dictionary
(
    name VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT pk_dictionary PRIMARY KEY (name)
);

CREATE TABLE dictionary_keys
(
    dictionary_name VARCHAR(255) NOT NULL UNIQUE,
    keys            VARCHAR(255) UNIQUE
);

CREATE TABLE student
(
    id             UUID NOT NULL,
    created        date,
    modified       date,
    deleted        BOOLEAN,
    name           VARCHAR(255),
    surname        VARCHAR(255),
    photo_id       VARCHAR(255),
    mail           VARCHAR(255),
    yearbook       VARCHAR(255),
    form_of_study  VARCHAR(255),
    field_of_study VARCHAR(255),
    specialization VARCHAR(255),
    CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE TABLE student_awards
(
    student_id UUID NOT NULL,
    awards     VARCHAR(255)
);

ALTER TABLE dictionary_keys
    ADD CONSTRAINT fk_dictionary_keys_on_dictionary FOREIGN KEY (dictionary_name) REFERENCES dictionary (name);

ALTER TABLE student_awards
    ADD CONSTRAINT fk_student_awards_on_student FOREIGN KEY (student_id) REFERENCES student (id);