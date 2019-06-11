package servlet;

import Factory.BeanFactory;
import entity.User;
import service.IUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    User user=new User();
    private IUserService userService= BeanFactory.getInstance("userService",IUserService.class);
    private Object uri;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        switch (method) {
            //可能接收不到隐藏的method
            case "signIn":
                signIn(request,response);
                break;
            case "register":
                register(request,response);
                break;
            case "InfoModify":
                infoModify(request,response);
                break;

        }
    }
    public void signIn(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        User currentUser=userService.signIn(user);
        if(currentUser==null){
            uri= request.getRequestDispatcher("/signin.jsp?error=yes");
            //response.sendRedirect(request.getContextPath()+"/signin.jsp?error=yes");
        }else{
            Cookie cookie=new Cookie("username",user.getName());
            response.addCookie(cookie);
            uri=request.getRequestDispatcher("/InfoModify.jsp");
        }
        goTo(request,response,uri);
    }
    public void register(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        user.setName(request.getParameter("username"));
        user.setName(request.getParameter("password"));
        userService.register(user);
        uri=request.getRequestDispatcher("/signin.jsp");
        goTo(request,response,uri);
    }
    public void infoModify(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        Cookie[] cookies=request.getCookies();
        String username=cookies[0].getValue();
        user.setName(username);
        user.setPassword(request.getParameter("newPassword"));
        userService.infoModify(user);
        uri=request.getRequestDispatcher("/signin.jsp?error=no");
        goTo(request,response,uri);
    }
    public void goTo(HttpServletRequest request,HttpServletResponse response,Object uri)throws ServletException,IOException{
        /*if(uri instanceof RequestDispatcher){
            ((RequestDispatcher) uri).forward(request,response);
        }else if(uri instanceof String){
            ((RequestDispatcher) uri).forward(request,response);
        }*/
        ((RequestDispatcher) uri).forward(request,response);
    }
}
