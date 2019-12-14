package spring.beans.generic_di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    //子类继承此类后，将会把特定类型 User 注入到 T 中。
    //且两层的联系是通过 Base 的 Bean 进行关联。
    @Autowired
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }


}
