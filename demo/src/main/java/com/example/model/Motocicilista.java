package com.example.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Motociclistas")
public class Motocicilista {

    @Id
    @EqualsAndHashCode.Include
    private String motociclistaId;

    private String name;

    private String lastname;

    private Integer age;

    private List<String> motos;

}


