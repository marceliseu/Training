package com.example.service;

import com.example.model.Moto;
import com.example.model.Motocicilista;
import com.example.model.Saudacao;

public interface DemoService {

    Saudacao hello(String param);

    Motocicilista hello2(String param);

    Motocicilista hello3(String name) throws Exception;
    
    Moto atualizaMoto(Moto moto) throws Exception;
    
    Moto atualizaMoto2(Moto moto) throws Exception;
}
