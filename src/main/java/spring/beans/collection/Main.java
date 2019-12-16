package spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/beans-collection.xml");

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person2 person2 = (Person2) ctx.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person) ctx.getBean("person3");
        System.out.println(person3);

        Person person4 = (Person) ctx.getBean("person4");
        System.out.println(person4);

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getProperties());
    }
}
