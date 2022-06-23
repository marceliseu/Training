package com.example.service;

import com.example.model.Moto;
import com.example.model.RespostaMoto;
import com.example.model.Saudacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DemoServiceImpl implements DemoService {

    @Autowired
    ObjectMapper objectMapper;

    private JsonNode nodeMoto;

    @PostConstruct
    void init() throws JsonProcessingException {
        String jsonStr = "{\n" +
                "    \"name\": \"ZE2\",\n" +
                "    \"lastname\": \"Eliseu\",\n" +
                "    \"age\": 51,\n" +
                "    \"motos\": [\n" +
                "        {\n" +
                "            \"modelo\": \"yamaha\",\n" +
                "            \"motor\": 900\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        nodeMoto = objectMapper.readTree(jsonStr);

    }

    @Override
    public Saudacao hello(String param) {
        String name = "World";
        if (Objects.nonNull(param)) name = param;
        Saudacao saudacao = new Saudacao();
        saudacao.setName(name);
        return saudacao;
    }

    public RespostaMoto hello2(String param) {
        String name = "World";
        if (Objects.nonNull(param)) name = param;
        RespostaMoto respostaMoto = new RespostaMoto();
        respostaMoto.setName(name);
        respostaMoto.setAge(51);
        respostaMoto.setLastname("Eliseu");
        Moto moto = new Moto();
        moto.setModelo("yamaha");
        moto.setMotor(900);
        List<Moto> motoList = new ArrayList<>();
        motoList.add(moto);
        respostaMoto.setMotos(motoList);

//        List<Moto> motoList2 =motoList.stream().filter(s->s.getMotor().equals(900)).toList();
        return respostaMoto;
    }

    public RespostaMoto hello3(String name) throws Exception {

//        String name = nodeMoto.get("name").asText();
//        boolean hasName = nodeMoto.has("name");
//        if (hasName) System.out.println("TEM name");

        RespostaMoto respostaMoto = objectMapper.treeToValue(nodeMoto, RespostaMoto.class);
        respostaMoto.setName(name);
        return respostaMoto;
    }

}
