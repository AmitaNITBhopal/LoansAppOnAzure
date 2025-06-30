package com.omegadummy.webapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"controller"})
@ComponentScan(basePackages={"model"})
public class WebappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WebappApplication.class, args);
		/*
		 * String[] beanNames = context.getBeanDefinitionNames();
		 * Arrays.sort(beanNames); for (String beanName : beanNames) {
		 * System.out.println(beanName); }
		 */
	}

}
