package com;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    static final String JDBC_URL="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/userdb?serverTimezone=GMT";
    static final String USER="root";
    static final String PASSWORD="0010";
    public Connection getCon(){
        Connection conn;
        try{
            Class.forName(JDBC_URL);
            System.out.println("正在连接数据库");
            conn= DriverManager.getConnection(DB_URL,USER,PASSWORD);
            if(!conn.isClosed()){
                System.out.println("连接成功");
            }else{
                System.out.println("连接失败");
            }
            return conn;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
