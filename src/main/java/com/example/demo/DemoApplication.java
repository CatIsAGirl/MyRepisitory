package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.test.CarFactory;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		CarFactory car = (CarFactory) SpringUtil.getBean("car");
		System.out.println(car.getId()+"---"+car.getName());
	}
	@Bean(name="car")
	private static CarFactory getCarFactory() {
		CarFactory car = new CarFactory();
		car.setId(1);
		car.setName("宝马");
		return car;
	}
}
