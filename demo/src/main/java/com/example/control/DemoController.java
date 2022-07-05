package com.example.control;

import com.example.model.Moto;
import com.example.model.Motocicilista;
import com.example.model.Saudacao;
import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/hello")
    public Saudacao hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        Saudacao result = demoService.hello(name);
        return result;
    }

    @GetMapping("/hello2")
    public Motocicilista hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
        Motocicilista result = demoService.hello2(name);
        return result;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @GetMapping("/hello3/{name}")
    public Motocicilista hello3(@PathVariable("name") String name) throws Exception {
        Motocicilista result = demoService.hello3(name);
        return result;
    }
    
    
    @PostMapping("/moto")
    public Moto atualizaMoto(@RequestBody Moto motoRequest) throws Exception {
        
        Moto result = demoService.atualizaMoto(motoRequest);
        return result;
    }
    
    @PostMapping("/moto2")
    public Moto atualizaMoto2(@RequestBody Moto motoRequest) throws Exception {
        
        Moto result = demoService.atualizaMoto2(motoRequest);
        return result;
    }
}
