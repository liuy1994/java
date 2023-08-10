package spring.user.model;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoFactory implements FactoryBean<UserDao> {

    @Override
    public UserDao getObject() {
        System.out.println("11111组件对象创建成功!");
        return new UserMockDao();
    }

    @Override
    public Class<?> getObjectType() {
        return UserMockDao.class;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }
}
