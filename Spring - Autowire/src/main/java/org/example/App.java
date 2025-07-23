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
        Alien alien1 = (Alien) applicationContext.getBean("alien2");
        System.out.println(alien1.getAge());
        alien1.code();


//        Alien alien2 = (Alien) applicationContext.getBean("alien2");
//        alien2.code();


        //Classic way
        Desktop desktop2 = (Desktop) applicationContext.getBean("com1");

        // This will search by type
        Computer com = applicationContext.getBean(Computer.class);

        //This will auto caste internally
        Desktop desktop = applicationContext.getBean("com1",Desktop.class);
        Desktop desktop1 = applicationContext.getBean(Desktop.class);
    }
}
