package com.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@Test
	void test1() {

		// fixture
		String param = "ZE";
		String expected = "Hello ZE!";

		// test
		String result = demoService.hello(param);

		// check
		Assertions.assertEquals(expected, result);

	}

	

}
