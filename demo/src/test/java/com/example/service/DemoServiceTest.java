package com.example.service;

import com.example.model.Moto;
import com.example.model.Saudacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@MockBean
	MongoTemplate mongoTemplateMock;

	@Test
	void test1() {

		// fixture
		String param = "ZE";
		String expected = "Hello ZE!";

		// test
		Saudacao result = demoService.hello(param);

		// check
		Assertions.assertEquals(expected, result.getName());

	}

	@Test
	void testAtualizaMoto() throws Exception {

		// fixture
		String motoId = UUID.randomUUID().toString();
		Moto moto = Moto.builder()
				.motoId(motoId)
				.modelo("modelo1")
				.motor(900)
				.build();

		Moto expected = Moto.builder()
				.motoId(motoId)
				.modelo("modelo1")
				.motor(900)
				.build();

		Mockito.when(mongoTemplateMock.exists(any(), Moto.class)).thenReturn(true);
//		Mockito.when(mongoTemplateMock.insert(any())).thenReturn(moto);

		// test
		Moto result = demoService.atualizaMoto(moto);

		// check
		Assertions.assertEquals(expected.getMotoId(), result.getMotoId());

	}

	

}
