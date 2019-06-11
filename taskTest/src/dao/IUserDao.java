package dao;

import entity.User;

public interface IUserDao {
    User signIn(User user);
    void register(User user);
    void infoModify(User user);
}
