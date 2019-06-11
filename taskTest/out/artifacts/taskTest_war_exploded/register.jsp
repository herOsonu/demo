<%--
  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/5/16
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>用户注册页面</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" charset="UTF-8"/>
</head>

<body>
<div id="login_frame">
    <p style="background-position: center;font-weight: bold">USER SYSTEM</p>
    <form method="post" action="/taskTest_war_exploded/userServlet" name="Register" id="Register">
        <p><label class="label_input">用户名</label><input type="text" name="username" value="" class="text_field" onchange="checkvalid2()" required/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" value="" class="text_field" onchange="checkvalid2()" required/></p>
        <input type="hidden" value="register" name="method">
        <div id="login_control">
            <input type="submit" id="btn_login" value="注册"/>
        </div>
    </form>
</div>
</body>
</html>
