package org.example;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
    private Computer com;

    public Alien() {
        System.out.println("Alien Object Created");
    }

    public Alien(int age) {
        System.out.println("Parameter constructor called");
        this.age = age;
    }

    @ConstructorProperties({"age","lap"})
    public Alien(int age, Computer com) {
        this.age = age;
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {    // Setter Injection
        System.out.println("Setter age called in alien");
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        System.out.println("Setter computer called in alien");
        this.com = com;
    }

    public void code() {
        System.out.println("Coding");
        com.compile();
    }

}