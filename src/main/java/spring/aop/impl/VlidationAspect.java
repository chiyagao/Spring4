package spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
* @Order内数字越小优先级越大
* @Pointcut给别的包内文件，进行重用话，还需在前面加上包名.
* */

@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("LoggingAspect.declareJoinPointExpression()")
    public void validaArgs(JoinPoint joinPoint){
        System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
