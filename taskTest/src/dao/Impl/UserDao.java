package dao.Impl;

import dao.IUserDao;
import entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JdbcUtils;

import java.sql.SQLException;

public class UserDao implements IUserDao {
    @Override
    public User signIn(User user){
        String sql = " SELECT * FROM USERTABLE WHERE usertable.NAME=? AND usertable.PASSWORD=? ";
        try {
            User query=JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<>(User.class),user.getName(),user.getPassword());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    public void register(User user){
        //用户名重复会报错
        String sql="insert into usertable values(?,?)";
        try {
            JdbcUtils.getQuerrRunner().query(sql,new BeanHandler<>(User.class),user.getName(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void infoModify(User user){
        String sql=" UPDATE usertable SET PASSWORD=? WHERE NAME=? ";
        try {
            JdbcUtils.getQuerrRunner().update(sql,user.getPassword(),user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
