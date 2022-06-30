package com.example.service;

import com.example.model.Moto;
import com.example.model.Motos;
import com.example.model.Saudacao;

public interface DemoService {

    Saudacao hello(String param);

    Motos hello2(String param);

    Motos hello3(String name) throws Exception;
    
    Moto atualizaMoto(Moto moto) throws Exception;
    
    Moto atualizaMoto2(Moto moto) throws Exception;
}
