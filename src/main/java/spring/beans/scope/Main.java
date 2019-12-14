package spring.beans.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/beans-scope.xml");

        Car car = (Car)ctx.getBean("car");
        Car car2 = (Car)ctx.getBean("car");

        System.out.println(car==car2);

        Car car3 = (Car)ctx.getBean("car2");
        Car car4 = (Car)ctx.getBean("car2");

        System.out.println(car3==car4);

        Car car5 = (Car)ctx.getBean("car3");
        Car car6 = (Car)ctx.getBean("car3");

        System.out.println(car5==car6);

    }
}
