package com.example.control;

import com.example.model.Saudacao;
import com.example.service.DemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class DemoController2Test {

	@Autowired
	private DemoController demoController;

	@MockBean
	private DemoService demoServiceMock;

	@Test
	void test1() {

		// fixture
		String param = "ZE";
		String expected = "Hello ZE!";
		Saudacao saudacao = new Saudacao();
		saudacao.setName(expected);

		// Mock
		when(demoServiceMock.hello(anyString())).thenReturn(saudacao);

		// test
		Saudacao result = demoController.hello(param);

		// check
		Assertions.assertEquals(expected, result.getName());

		// verify
		verify(demoServiceMock, times(1)).hello(anyString());

	}



}
