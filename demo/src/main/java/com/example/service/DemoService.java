package com.example.service;

import com.example.model.RespostaMoto;
import com.example.model.Saudacao;

public interface DemoService {

    Saudacao hello(String param);

    RespostaMoto hello2(String param);

    RespostaMoto hello3(String name) throws Exception;
}
