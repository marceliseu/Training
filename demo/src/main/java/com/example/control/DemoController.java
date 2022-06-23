package com.example.control;

import com.example.model.RespostaMoto;
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
    public RespostaMoto hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
        RespostaMoto result = demoService.hello2(name);
        return result;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @GetMapping("/hello3/{name}")
    public RespostaMoto hello3(@PathVariable("name") String name) throws Exception {
        RespostaMoto result = demoService.hello3(name);
        return result;
    }
}
