package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class RespostaMoto {

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
}


