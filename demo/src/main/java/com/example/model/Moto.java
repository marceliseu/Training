package com.example.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Motos")
public class Moto {

    @Id
    private  String modelo;
    private  Integer motor;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getMotor() {
        return motor;
    }

    public void setMotor(Integer motor) {
        this.motor = motor;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Moto) {
            return Objects.equals(modelo, ((Moto) obj).modelo);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(modelo);
    }
}
