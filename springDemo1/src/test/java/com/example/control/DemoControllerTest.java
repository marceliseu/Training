package com.example.control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
		String result = demoController.hello(param);

		// check
		Assertions.assertEquals(expected, result);

	}



}
