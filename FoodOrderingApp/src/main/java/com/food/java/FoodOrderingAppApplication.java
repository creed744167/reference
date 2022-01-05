package com.food.java;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodOrderingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingAppApplication.class, args);
	}

	@Bean
    public Queue queue() {
        return new ActiveMQQueue("INGDemoMQ.queue");
    }
}
