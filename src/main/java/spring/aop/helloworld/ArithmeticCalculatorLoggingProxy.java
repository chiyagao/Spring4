package spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理
public class ArithmeticCalculatorLoggingProxy {

    //1.要给哪个对象 target 进行代理
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    //2.获取代理对象 Proxy
    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = null;

        //2.1代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();

        //2.2代理对象使用什么接口，即其中有哪些方法
        Class [] interfaces = new Class[]{ArithmeticCalculator.class};

        //2.3当调用代理对象其中方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /*
            * proxy:正在返回的那个代理对象，一般情况下，在 invoke 方法中都不使用该对象。
            * method：正在被调用的方法
            * args：调用方法时，传入的参数
            * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
                //执行方法 method.invoke（被代理的对象，args）
                Object result = null;

                try {
                    //3.1前置通知
                    System.out.println("1.The method " + methodName + " begins " + " begins with " + args);
                    result = method.invoke(target,args);
                    //3.2返回通知
                    System.out.println("2.The method " + methodName + " ends with " + result);
                } catch (Exception e) {
                    //3.3异常通知
                    System.out.println("3.[error] The method " + methodName + " occurs with " + e);
                    return 0;
                }
                //3.4后置通知，方法可能出异常，所以访问不到方法的返回值
                System.out.println("4.The method " + methodName + " ends");

                //日志
                System.out.println("The method " + methodName + " ends with " + result);
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);

        return proxy;
    }
}





