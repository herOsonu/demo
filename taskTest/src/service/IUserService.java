package service;

import entity.User;

public interface IUserService {
    User signIn(User user);
    void register(User user);
    void infoModify(User user);
}
