package spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        int result;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/applicationContext-xml.xml");
        ArithmeticCalculator arithmeticCalculator= (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        result = arithmeticCalculator.add(4,6);
        System.out.println("-->" + result);

        System.out.println("");

        result = arithmeticCalculator.div(12,6);
        System.out.println("-->" + result);

    }
}






