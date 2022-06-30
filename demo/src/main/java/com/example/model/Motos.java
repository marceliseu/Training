package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Motos {

    private String name;
    private String lastname;

    @JsonIgnore
    private Integer age;
    private List<Moto> motos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Motos) {
            return Objects.equals(name, ((Motos) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(name);
    }
}


