<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/23
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="static com.UserService.currentName" %><%--
  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/2/23
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InfoModify</title>
</head>
<body>
<%
    Connection conn=null;
    try{
        String url="jdbc:mysql://localhost:3306/userdb?serverTimezone=GMT";
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection(url,"root","0010");
        String sql=" UPDATE usertable SET PASSWORD=? WHERE USERNAME=? ";
        String newPassword=request.getParameter("newPassword");
        //String password=request.getParameter("password");
        PreparedStatement sts=conn.prepareStatement(sql);
        //Object id=session.getAttribute("id");
        sts.setString(1,newPassword);
        sts.setString(2,currentName);
        sts.execute();
        //response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        //response.setHeader("Location","FrontPage.html");
        response.sendRedirect("index.jsp");
    }catch (Exception e){
        e.printStackTrace();
    }finally {;
        conn.close();
    }
%>
</form>
</body>
</html>