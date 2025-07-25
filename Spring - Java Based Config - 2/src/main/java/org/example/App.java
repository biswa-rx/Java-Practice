package org.example;

import org.example.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

//		Desktop dt1 = context.getBean(Desktop.class);
//		dt1.compile();
//
//		Desktop dt2 = context.getBean(Desktop.class);
//		dt2.compile();

		Alien obj1 = context.getBean(Alien.class);
		System.out.println(obj1.getAge());
		obj1.code();

		

	}
}
