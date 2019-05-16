<%--
  Created by IntelliJ IDEA.
  User: Administor
  Date: 2019/3/5
  Time: 14:59
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
    var is_error='<%=request.getParameter("error")%>';
    if(is_error=="yes"){
      alert("账号名或密码错误！")
    }else if(is_error=="no"){
        alert("登录成功！")
    }


  </script>
</head>
<body>
<div id="login_frame">
  <p style="background-position: center;font-weight: bold">USER SYSTEM</p>
  <form method="post" action="/taskDemo_war_exploded/signIn">
      <p><label class="label_input">用户名</label><input type="text" name="username" value="" class="text_field"/></p>
      <p><label class="label_input">密码</label><input type="password" name="password" value="" class="text_field"/></p>
      <div id="login_control">
          <input type="submit" id="btn_login" value="登录"/>
          <a id="btn_register" href="Register.html">注册</a>
          <a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>
      </div>
  </form>
</div>


</body>
</html>