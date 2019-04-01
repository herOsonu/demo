<%--
  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/3/9
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="user" class="com.UserTable"></jsp:useBean>
<jsp:useBean id="userService" class="com.UserService"></jsp:useBean>
<jsp:setProperty name="user" property="*"></jsp:setProperty>
<%
    if(userService.userCheck(user)){
        //response.sendRedirect("index.jsp?error=no");
        response.sendRedirect("InfoModify.html");
    }else{
        response.sendRedirect("index.jsp?error=yes");
    }
%>

</body>
</html>
