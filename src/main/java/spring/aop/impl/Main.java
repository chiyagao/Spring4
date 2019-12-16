package spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        int result;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/applicationContext-impl.xml");
        ArithmeticCalculator arithmeticCalculator= (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        result = arithmeticCalculator.add(3,6);
        System.out.println("-->" + result);

        result = arithmeticCalculator.div(12,6);
        System.out.println("-->" + result);

    }
}






