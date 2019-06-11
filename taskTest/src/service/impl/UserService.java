package service.impl;

import Factory.BeanFactory;
import dao.IUserDao;
import entity.User;
import service.IUserService;

public class UserService implements IUserService {
    private IUserDao userDao= BeanFactory.getInstance("userDao",IUserDao.class);
    @Override
    public User signIn(User user){
        return userDao.signIn(user);
    }
    @Override
    public void register(User user){
        userDao.register(user);
    }
    @Override
    public void infoModify(User user){
        userDao.infoModify(user);
    }

}
