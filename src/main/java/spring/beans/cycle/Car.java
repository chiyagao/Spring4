package spring.beans.cycle;

public class Car {

    private String brand;

    public Car(){
        System.out.println("Car's Constructor...");
    }

    public void init233(){
        System.out.println("init...");
    }

    public void destroy(){
        System.out.println("destory...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
