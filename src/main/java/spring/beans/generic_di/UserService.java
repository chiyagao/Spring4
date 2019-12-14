package spring.beans.generic_di;

import org.springframework.stereotype.Service;

//自动装配 继承父类关系的子类，将自动注入泛型 User
@Service
public class UserService extends BaseService<User>{

}
