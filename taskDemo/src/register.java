import com.Conn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn=null;
        try
        {
            String uid=request.getParameter("username");
            String pwd=request.getParameter("password");
            conn= new Conn().getCon();
            PreparedStatement st=conn.prepareStatement("insert into usertable values(?,?)");
            st.setString(1,uid);
            st.setString(2,pwd);

            int count=st.executeUpdate();
            /*out.println("用户注册成功!  5秒钟后给你自动跳转到用户登录界面。。。");*/
            //response.sendRedirect("InfoModify.html");
            response.setHeader("Refresh","3;URL=signin.jsp");
        }
        catch(Exception e)
        {
       /* out.println("用户注册时出现如下错误。。。");
        out.println(e.getMessage());*/
            //response.setHeader("Refresh","7;URL=login.html");
        }
    }
}
