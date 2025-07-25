package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.example.Desktop;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	public Alien alien(@Autowired @Qualifier("desktop") Computer com) {
		Alien obj= new Alien();
		obj.setAge(25);
		obj.setCom(com);
		return obj;

	}

	@Bean
	@Primary
	public Laptop laptop() {
		return new Laptop();
	}

	@Bean(name = {"Beast","desktop","com1"})
	@Scope("prototype")
//	@Scope("singleton")
//	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
}
