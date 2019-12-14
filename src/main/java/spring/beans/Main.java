package spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//	    HelloWorld helloWorld = new HelloWorld();
//	    helloWorld.setName2("My Java name");

/*         1. 创建 Spring 的 IOC 容器对象（创建对象，设置属性）
         ApplicationContext: 代表 IOC 容器。
         ClassPathXmlApplicationContext：是 ApplicationContext 接口的实现类，该实现类从类路径下来加载配置文件。
         FileSystemXmlApplicationContext: 从文件系统加载配置文件*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");

/*         2. 从 IOC 容器中获取 Bean 实例（获取对象）
         a.利用 id 定位到 IOC 容器中的 bean*/
        HelloWorld hw = (HelloWorld) applicationContext.getBean("helloWorld2");

/*       b.利用 .class 类型返回 IOC 容器中的 Bean，但要求 IOC 容器中必须只有一个该类型的Bean
         (即唯一一个class="HelloWorld")*/
//         HelloWorld hw = applicationContext.getBean(HelloWorld.class);

//        System.out.println("hw :" + hw);

/*         3. 调用 hello 方法。*/
        hw.hello();

//         Car car = applicationContext.getBean(Car.class);
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);

//        Person person = applicationContext.getBean(Person.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        Person person2 = (Person) applicationContext.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person) applicationContext.getBean("person3");
        System.out.println(person3);

    }

}
