package com.example.util;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MongoDBContainer;

import java.util.List;

/**
 * Application context initializer used to create Singleton MongoDB container
 *
 * Singleton containers are automatically stopped by TestContainers Ryuk container
 *
 * @see <a href="https://www.testcontainers.org/test_framework_integration/manual_lifecycle_control/#singleton-containers"/>
 */
public class MongoInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:5.0.3");

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        if (!mongoDBContainer.isRunning()) {
            mongoDBContainer.start();
        }
        // Inject Spring Data connection
        String mongoURI = String.format("spring.data.mongodb.uri=%s", mongoDBContainer.getReplicaSetUrl());
        TestPropertyValues.of(List.of(mongoURI))
                .applyTo(context.getEnvironment());
    }
}