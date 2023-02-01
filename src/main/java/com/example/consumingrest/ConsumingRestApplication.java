package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//Returns time/date JSON object from endpoint http://time.jsontest.com/
// and weather data JSON object from endpoint http://api.openweathermap.org/data/2.5/weather?q=Belfast&units=metric&appid=API-KEY
//Based on https://spring.io/guides/gs/consuming-rest/
@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			TimeDate timeDate = restTemplate.getForObject(
					"http://time.jsontest.com/", TimeDate.class);
			log.info(timeDate.toString());
			System.out.println(timeDate.toString());
		};
	}

	@Bean
	public CommandLineRunner runWeather(RestTemplate restTemplate) throws Exception {
		return args -> {
			Weather weather = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/weather?q=Belfast&units=metric&appid=API-KEY", Weather.class);
			log.info(weather.toString());
			System.out.println(weather.toString());
		};
	}
}
