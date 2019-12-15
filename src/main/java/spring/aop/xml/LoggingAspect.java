package spring.aop.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;


public class LoggingAspect {



    public void beforeMethod(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("1.Before：The method '" + methodName + "' begins " + " begins with " + args);
    }


    public void afterMethod(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();

        System.out.println("2.After：The method '" + methodName + "' ends");
    }

    public void afterThrowing(JoinPoint joinPoint,Exception e ){

        String methodName = joinPoint.getSignature().getName();

        System.out.println("3.AfterThrowing：The method '" + methodName + "' occurs with '" + e +"'");
    }

    public void afterReturning(JoinPoint joinPoint,Object result ){

        String methodName = joinPoint.getSignature().getName();

        System.out.println("4.AfterReturning：The method '" + methodName + "' ends with '" + result +"'");
    }


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



















