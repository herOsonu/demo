<%--
  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/5/16
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div id="login_frame">
    <form method="post" action="/taskTest_war_exploded/userServlet">
        <p><label class="label_input">密码修改</label><input type="text" id="newPassword" name="newPassword" onkeyup="value=value.replace(/[^\w\/]/ig,'')" maxlength="16" autofocus name="newPassword" autocomplete="off" required="required" class="text_field"/></p>
        <input type="hidden" value="InfoModify" name="method">
        <div id="login_control">
            <input type="submit" id="btn_login" value="确认"/>
            <a id="btn_register" href="/taskTest_war_exploded/signin.jsp">退出登录</a>
        </div>
    </form>
</div>
</body>
</html>
