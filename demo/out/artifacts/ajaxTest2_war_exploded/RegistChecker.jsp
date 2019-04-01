<%@ page import="java.sql.*" %>

  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/3/9
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Connection conn=null;
    try
    {
        String uid=request.getParameter("username");
        String pwd=request.getParameter("password");

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/userdb?serverTimezone=GMT";
        conn= DriverManager.getConnection(url,"root","0010");
        PreparedStatement st=conn.prepareStatement("insert into usertable values(?,?)");
        st.setString(1,uid);
        st.setString(2,pwd);

        int count=st.executeUpdate();
        /*out.println("用户注册成功!  5秒钟后给你自动跳转到用户登录界面。。。");*/
        //response.sendRedirect("InfoModify.html");
        response.setHeader("Refresh","3;URL=index.jsp");
    }
    catch(Exception e)
    {
       /* out.println("用户注册时出现如下错误。。。");
        out.println(e.getMessage());*/
        //response.setHeader("Refresh","7;URL=login.html");
    }
    finally
    {
        conn.close();
    }
%>
</body>
</html>
