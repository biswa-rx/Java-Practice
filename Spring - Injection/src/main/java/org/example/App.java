package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Alien alien1 = (Alien) applicationContext.getBean("alien1");
        System.out.println(alien1.getAge());
        alien1.code();



//        Alien alien2 = (Alien) applicationContext.getBean("alien2");
//        alien2.code();
    }
}
