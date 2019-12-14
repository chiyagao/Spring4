package spring.aop.helloworld;

public class Main {

    public static void main(String[] args) {

        int result;
        ArithmeticCalculator target = new ArithmeticCalculatorLoggingImpl();
/*
        result = target.add(1,2);
        System.out.println("-->" + result);
*/

        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        result = proxy.add(1,2);
        System.out.println("-->" + result);

        result = proxy.div(4,0);
        System.out.println("-->" + result);


    }
}
