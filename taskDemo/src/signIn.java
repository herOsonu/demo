import com.Conn;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "signIn",urlPatterns = "/signIn")
public class signIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try{
        Connection conn=new Conn().getCon();
        PreparedStatement pstsmt=null;
        System.out.println("实例化PreparedStatement对象...");
        String sql = " SELECT username,password FROM USERTABLE WHERE USERNAME=? AND PASSWORD=? ";
        pstsmt = conn.prepareStatement(sql);
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if("".equals(username)||username==null||"".equals(password)||password==null){
            response.sendRedirect("signin.html");
        }
        pstsmt.setString(1, request.getParameter("username"));
        pstsmt.setString(2, request.getParameter("password"));
        ResultSet rs = pstsmt.executeQuery();
        if (rs.next()) {
            //request.getRequestDispatcher("/success").include(request, response);
            //返回error参数
            //response.sendRedirect("signin.jsp?error=no");
            Cookie cookie=new Cookie("username",username);
            response.addCookie(cookie);
            //request.setAttribute("username",username);
            RequestDispatcher rd = request.getRequestDispatcher("InfoModify.jsp");
            rd.forward(request,response);
        }else{
            response.sendRedirect("signin.jsp?error=yes");
        }
        } catch (Exception e) {
            e.printStackTrace();

    }

    } }
    //servletConfig用于加载servlet初始化对象,在创建完Config之后，init方法之前,直接从init方法中得到对象
