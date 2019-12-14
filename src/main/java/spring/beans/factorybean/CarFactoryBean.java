package spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

//自定义的 FactoryBean 需要实现 FactoryBean 接口
public class CarFactoryBean implements FactoryBean {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回 bean 的对象
    @Override
    public Object getObject() throws Exception {
        return new Car(brand,500000);
    }

    /*
    * 返回 bean 的类型
    * */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /*
    * 返回 bean 的类型是不是实例的
    * */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
