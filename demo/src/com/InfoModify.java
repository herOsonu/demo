package com;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InfoModify {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name=UserService.currentName;
            response.setContentType("text/json;charset=UTF-8");
            Connection conn=new Conn().getCon();
            String url = "jdbc:mysql://localhost:3306/userdb?serverTimezone=GMT";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "0010");
            String sql = " UPDATE DEMO SET PASSWORD=? WHERE username=? ";
            String newPassword = request.getParameter("newPassword");
            //String password=request.getParameter("password");
            PreparedStatement sts = conn.prepareStatement(sql);
            sts.setString(1, newPassword);
            sts.setString(2, name);
            //Object id=session.getAttribute("id");
            sts.execute();
            //response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            //response.setHeader("Location","FrontPage.html");
            response.sendRedirect("login.html");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

}
