package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

	/* Constructor Injection
	Filed Injection
	Setter Injection
	 */
	

//	@Value(value = "6")
	private int age;
//	@Autowired
//	@Qualifier("boxy_computer")
	private Computer com;
	
	public Alien() {
		System.out.println("Alien Object Created");
	}


//	@Autowired
//	public Alien(@Value("7") int age,@Qualifier("boxy_computer") Computer com) {
//		System.out.println("Para Constructor Called");
//		this.age = age;
//		this.com = com;
//	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {    // Setter Injection
		//System.out.println("Setter called");
		this.age = age;
	}
	
	public Computer getCom() {
		return com;
	}

	@Autowired
	public void setCom(@Qualifier("boxy_computer") Computer com) {
		this.com = com;
	}
	
	public void code() {
		System.out.println("Coding");
		com.compile();
	}
	
}
