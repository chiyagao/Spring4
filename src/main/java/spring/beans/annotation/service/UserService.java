package spring.beans.annotation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.beans.annotation.repository.UserRepository;

@Service
public class UserService {


    //装配的是 UserRepository 接口，非实现类
    private UserRepository userRepository;

    @Autowired
    //指定装配哪一个 Bean 的名字
    @Qualifier("userRepositoryImpl")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

/*
    public void setUserRepository(@Qualifier("userRepositoryImpl")UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/

    public void add(String name){

        System.out.println("UserService add...");
        userRepository.save();
        userRepository.save(name);
    }
}
