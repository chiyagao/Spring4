package spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");

        Person person4 = (Person) ctx.getBean("person4");
        System.out.println(person4);

        NewPerson newPerson = (NewPerson) ctx.getBean("person5");
        System.out.println(newPerson);

        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getProperties());

        Person person6 = (Person) ctx.getBean("person6");
        System.out.println(person6);

        Person person7 = (Person) ctx.getBean("person7");
        System.out.println(person7);
    }
}
