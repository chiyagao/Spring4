package spring.beans.collection;

import spring.beans.Car;

import java.util.Map;

public class NewPerson {

    private String name;
    private int age;
    /*引用数据类型 Car*/
    private Map<String, Car> cars;


    public NewPerson() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
