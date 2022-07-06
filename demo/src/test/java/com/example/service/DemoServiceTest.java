package com.example.service;

import com.example.model.Moto;
import com.example.model.Saudacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ActiveProfiles("unit-test")
@SpringBootTest
@ContextConfiguration(initializers = com.example.util.MongoInitializer.class)
class DemoServiceTest {

	@Autowired
	private DemoService demoService;

	@SpyBean
	private MongoTemplate mongoTemplateMock;
//
//	@MockBean
//	private MongoRepository mongoRepository;



	@Test
	@DisplayName(("Teste Hello"))
	void test1() {

		// fixture
		String param = "ZE";
		String expected = "ZE";

		// test
		Saudacao result = demoService.hello(param);

		// check
		Assertions.assertEquals(expected, result.getName());

	}

	@Test
	@DisplayName(("Moto nao existe"))
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

		Query query = new Query();
		query.addCriteria(Criteria.where("modelo").is(moto.getModelo()));

		when(mongoTemplateMock.exists(query, Moto.class)).thenReturn(false);
//		when(mongoTemplateMock.insert(any())).thenReturn(moto);

		// test
		Moto result = demoService.atualizaMoto(moto);

		// check
		Assertions.assertEquals(expected.getMotoId(), result.getMotoId());

	}

	@Test
	@DisplayName(("Moto existe"))
	void testAtualizaMotoExiste() throws Exception {

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

		Query query = new Query();
		query.addCriteria(Criteria.where("modelo").is(moto.getModelo()));

		when(mongoTemplateMock.exists(query, Moto.class)).thenReturn(true);
//		when(mongoTemplateMock.insert(any())).thenReturn(moto);

		// test
		Moto result = demoService.atualizaMoto(moto);

		// check
		Assertions.assertEquals(expected.getMotoId(), result.getMotoId());

	}

	

}
