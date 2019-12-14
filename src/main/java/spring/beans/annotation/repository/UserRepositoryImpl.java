package spring.beans.annotation.repository;


import org.springframework.stereotype.Repository;

// 除了用@Qualifier指定装配该 Bean 外，
// 还可以使本 Bean 的 @Repository("userRepository")的类名与要装配本 Bean 的属性名相同，即默认装配属性名相同的 Bean
@Repository
public class UserRepositoryImpl implements UserRepository {


    @Override
    public void save() {
        System.out.println("UserPespository Save...");
    }

    @Override
    public void save(String name) {
        System.out.println("UserRepository Name:" + name);

    }
}
