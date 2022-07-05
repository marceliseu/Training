package com.example.service;

import com.example.model.Moto;
import com.example.model.Motocicilista;
import com.example.model.Saudacao;
import com.example.repository.MotoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class DemoServiceImpl implements DemoService {

    @Autowired
    ObjectMapper objectMapper;
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Autowired
    MotoRepository motoRepository;

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

    public Motocicilista hello2(String param) {
        String name = "World";
        if (Objects.nonNull(param)) name = param;
        Motocicilista motocicilista = Motocicilista.builder()
                .name(name)
                .age(51)
                .lastname("Eliseu")
                .build();

        String motoId = UUID.randomUUID().toString();
        List<String> motoList = new ArrayList<>();
        motoList.add(motoId);
        motocicilista.setMotos(motoList);

//        List<Moto> motoList2 =motoList.stream().filter(s->s.getMotor().equals(900)).toList();
        return motocicilista;
    }

    public Motocicilista hello3(String name) throws Exception {

//        String name = nodeMoto.get("name").asText();
//        boolean hasName = nodeMoto.has("name");
//        if (hasName) System.out.println("TEM name");

        Motocicilista respostaMoto = objectMapper.treeToValue(nodeMoto, Motocicilista.class);
        respostaMoto.setName(name);
        return respostaMoto;
    }

    @Override
    public Moto atualizaMoto(Moto motoRequest) throws Exception {

        Query query = new Query();
        query.addCriteria(Criteria.where("modelo").is(motoRequest.getModelo()));
        boolean exists = mongoTemplate.exists(query, Moto.class);
        if (!exists) {
            mongoTemplate.insert(motoRequest);
        }
        return motoRequest;
    }
    
    @Override
    public Moto atualizaMoto2(Moto motoRequest) throws Exception {
        
        boolean exists = motoRepository.existsById(motoRequest.getModelo());
        
        if (!exists) {
            motoRepository.insert(motoRequest);
        }
        return motoRequest;
    }

}
