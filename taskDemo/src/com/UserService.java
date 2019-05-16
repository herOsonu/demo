/*
package com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
    private static Connection conn=null;
    private static PreparedStatement pstsmt=null;
    public static String currentName;

    public UserService(){
        conn=new Conn().getCon();
    }

    public boolean userCheck(UserTable user) {
        try {
            System.out.println("实例化PreparedStatement对象...");
            String sql = " SELECT username,password FROM USERTABLE WHERE USERNAME=? AND PASSWORD=? ";
            pstsmt = conn.prepareStatement(sql);
            pstsmt.setString(1, user.getUsername());
            pstsmt.setString(2, user.getPassword());
            ResultSet rs = pstsmt.executeQuery();
            if (rs.next()) {
                currentName=user.getUsername();
                //rs.close();
                //pstsmt.close();
                //conn.close();
                return true;
            } else {
                //rs.close();
                //pstsmt.close();
                //conn.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
*/
