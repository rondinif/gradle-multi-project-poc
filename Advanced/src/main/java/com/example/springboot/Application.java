package com.example.springboot;

import java.net.URL;
import java.net.URLClassLoader;

import java.util.Arrays;
import foo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			String[] dvds = new String[] {"TESTING-123"};
			Classic.main(dvds);
			System.out.println(dvds[0]);
			// let's inspect the system classloader to 
			System.out.println("\n\n..In order to better understand how it works lets's inspect the\nSystemClassLoader's current paths:");
			System.out.println();
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            URL[] urls = ((URLClassLoader)cl).getURLs();
            for(URL url: urls){
                System.out.println(url.getFile());
            }

/*
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
*/
		};
	}

}
