package spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.beans.annotation.controller.UserController;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/beans-annotation.xml");

/*
        TestObject to = (TestObject) ctx.getBean("testObject");
        System.out.println(to);
*/

        //表现层，界面展示，接收请求，分发请求
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

/*
        //业务层，黏合
        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);

        //持久层，关系数据库的操作
        UserRepositoryImpl userRespository = (UserRepositoryImpl) ctx.getBean("userRespository");
        System.out.println(userRespository);
*/




    }
}
