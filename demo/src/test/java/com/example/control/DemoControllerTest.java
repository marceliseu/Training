package com.example.control;

import com.example.model.Motocicilista;
import com.example.model.Saudacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class DemoControllerTest {

	@Autowired
	private DemoController demoController;

	@Test
	void test1() {

		// fixture
		String param = "ZE";
		String expected = "Hello ZE!";

		// test
		Saudacao result = demoController.hello(param);

		// check
		Assertions.assertEquals(expected, result.getName());

	}
	
	
	@Test
	void test2() {
	    
//        Motocicilista motos1 = new Motocicilista();
//        motos1.setName("yamaha");
//
//        Motocicilista motos2 = new Motocicilista();
//        motos2.setName("yamaha");
//
//        Assertions.assertEquals(motos1, motos2);
	}



}
