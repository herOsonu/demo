import com.Conn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "infoModify",urlPatterns ="/infoModify")
public class infoModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         Connection conn=null;
    try{
        conn= new Conn().getCon();
        String sql=" UPDATE usertable SET PASSWORD=? WHERE USERNAME=? ";
        String newPassword=request.getParameter("newPassword");
        Cookie cookie=null;
        Cookie[] cookies=new Cookie[1];
        cookies=request.getCookies();
        String currentName=cookies[0].getValue();
        PreparedStatement sts=conn.prepareStatement(sql);
        //Object id=session.getAttribute("id");
        sts.setString(1,newPassword);
        sts.setString(2,currentName);
        sts.execute();
        //response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        //response.setHeader("Location","FrontPage.html");
        response.sendRedirect("signin.jsp");
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
