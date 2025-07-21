import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.TransactionSettings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
//        persistEntry();
//        updateEntry();
//        deleteEntry();

        workingWithNewTable();
    }

    private static void updateEntry() throws Exception {
        Student s1 = new Student();
        s1.setRollNo(105);
        s1.setsName("Kiran");
        s1.setsAge(31);

        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(s1);
        transaction.commit();

        session.close();
        sf.close();

    }

    public static void deleteEntry() throws Exception{
        Student s1 = new Student();
        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        s1 = session.get(Student.class, 105);
        Transaction transaction = session.beginTransaction();
        session.remove(s1);
        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);
    }

    public static void persistEntry() throws Exception {
        Student s1 = new Student();
        s1.setRollNo(102);
        s1.setsName("Kiran");
        s1.setsAge(25);

//        s1.setRollNo(104);
//        s1.setsName("Sushil");
//        s1.setsAge(19);

//        s1.setRollNo(105);
//        s1.setsName("Gaurav");
//        s1.setsAge(22);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(s1);

        transaction.commit();
        System.out.println(s1);
    }

    public static void workingWithNewTable() throws Exception {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);


        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook air");
        l3.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Navin");
        a1.setTech("Java");


        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");


        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("Kiran");
        a3.setTech("AI");


        a1.setLaptops(Arrays.asList(l1, l2));
        a2.setLaptops(Arrays.asList(l2, l3));
        a3.setLaptops(Arrays.asList(l1));


        l1.setAliens(Arrays.asList(a1, a3));
        l2.setAliens(Arrays.asList(a1, a2));
        l3.setAliens(Arrays.asList(a2));

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        transaction.commit();

        Alien temp = session.get(Alien.class, 101);
        System.out.println(temp);

        session.close();
        sf.close();
    }

}
