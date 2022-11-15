package com.example.graduate.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Dictionary {

    @Id
    @NotNull
    private String name;

    @NotNull
    @ElementCollection
    private Set<String> keys = new HashSet<>();

}
