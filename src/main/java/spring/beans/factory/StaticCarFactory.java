package spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/*
* 静态工厂方法：不用 new ，直接调用某一个类的静态方法就可以（获取）返回 Bean 的实例
* */

public class StaticCarFactory {

    private static Map<String,Car> carMap = new HashMap<String,Car>();

    static {
        carMap.put("audi",new Car("audi",300000));
        carMap.put("ford",new Car("ford",400000));
    }

    //静态工厂方法：
    public static Car getCar(String brand){
        return carMap.get(brand);
    }
}
