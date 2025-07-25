package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.example.config.AppConfig;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//		Desktop dt1 = context.getBean("desktop",Desktop.class);
//		dt1.compile();
//
//		Desktop dt2 = context.getBean("desktop",Desktop.class);
//		dt2.compile();

		

	}
}
