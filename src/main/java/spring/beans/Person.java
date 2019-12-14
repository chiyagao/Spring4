package spring.beans;

public class Person {

    private String name;
    private int age;
    /*引用数据类型 Car*/
    private Car car;


    public Person() {
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /*为级联属性赋值 必须有这个 先获取 引用类型Car*/
    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }



}
