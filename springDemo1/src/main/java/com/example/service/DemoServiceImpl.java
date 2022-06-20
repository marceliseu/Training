package com.example.service;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public String hello(String param) {
        String name = "World";
        if (Objects.nonNull(param)) name = param;
        return String.format("Hello %s!", name);
    }

}
