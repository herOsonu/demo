<%--
  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/6/5
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" charset="UTF-8"/>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
    <script type="text/javascript">
        /*EL表达式*/
        <!--var is_error='${error}';-->
        var is_error='<%=request.getParameter("error")%>';
        if(is_error=="yes"){
            alert("账号名或密码错误！")
        }else if(is_error=="no"){
            alert("修改成功！")
        }
    </script>
</head>
<body>
<div id="login_frame">
    <p style="background-position: center;font-weight: bold">USER SYSTEM</p>
    <form method="post" action="/taskTest_war_exploded/userServlet">
        <p><label class="label_input">用户名</label><input type="text" name="username" value="" class="text_field"/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" value="" class="text_field"/></p>
        <input type="hidden" value="signIn" name="method">
        <div id="login_control">
            <input type="submit" id="btn_login" value="登录"/>
            <a id="btn_register" href="register.jsp">注册</a>
            <a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>
        </div>
    </form>
</div>
</body>
</html>