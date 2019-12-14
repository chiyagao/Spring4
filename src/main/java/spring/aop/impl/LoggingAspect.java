package spring.aop.impl;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//放入到 IOC 容器中、再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
/*

    //1.前置通知
        //在目标方法开始前执行，参数任意  .*(..)
    @Before("execution(public int spring.aop.impl.ArithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        //利用连接点 JoinPoint 获取方法的签名与方法的参数
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        //日志
        System.out.println("1.Before：The method '" + methodName + "' begins " + " begins with " + args);
    }

    //2.后置通知
        //在目标方法执行后执行，（无论是否发生异常）
    @After("execution(public int spring.aop.impl.ArithmeticCalculator.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        System.out.println("2.After：The method '" + methodName + "' ends");
    }

    //3.异常通知
        //在目标方法出现异常时会执行的代码，
        //可以访问到异常对象；且可以指定出现特定异常时在执行通知代码，把 Exception 换成 NullPointException。
    @AfterThrowing(value = "execution(public int spring.aop.impl.ArithmeticCalculator.*(int,int))",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e ){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("3.AfterThrowing：The method '" + methodName + "' occurs with '" + e +"'");

    }

    //4.返回通知
        //在方法正常结束后执行的代码
        //返回通知可以获取方法的返回值！
    @AfterReturning(value = "execution(public int spring.aop.impl.ArithmeticCalculator.*(int,int))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result ){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("4.AfterReturning：The method '" + methodName + "' ends with '" + result +"'");

    }
*/


    //5.环绕通知
        //可实现以上所有通知，且可根据情况改变顺序
    @Around("execution(public int spring.aop.impl.ArithmeticCalculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result  = null;
        String methodName = pjd.getSignature().getName();
        try {
            //1.前置通知
            System.out.println("1.Before：The method '" + methodName + "' begins " + " begins with " + Arrays.asList(pjd.getArgs()) );
            //2.执行目标方法
            result = pjd.proceed();
            //3.返回通知
            System.out.println("2.AfterReturning：The method '" + methodName + "' ends with '" + result +"'");
        } catch (Throwable e) {
            System.out.println("3.AfterThrowing：The method '" + methodName + "' occurs with '" + e +"'");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //4.后置通知
        System.out.println("4.After：The method '" + methodName + "' ends");
        return result;
    }






}



















