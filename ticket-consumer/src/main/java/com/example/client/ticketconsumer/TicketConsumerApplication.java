package com.example.client.ticketconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class TicketConsumerApplication {

	private static final Logger log = LoggerFactory.getLogger(TicketConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketConsumerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Greeting greeting = restTemplate.getForObject(
					"http://localhost:8080//greeting/Pawel", Greeting.class);
			log.info(greeting.toString());

			List<Greeting> greetingList = restTemplate.getForObject("http://localhost:8080//greeting/", List.class);
			log.info(greetingList.toString());
		};
	}
}
