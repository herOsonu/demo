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

    <script language="javascript">
        function checkvalid2()
        {
            var strmg=register.username.value;
            var pass1=register.pwd1.value;
            var pass2=register.pwd2.value;

            if(strmg=="" ||  pass1=="" || pass2=="")
            {
                alert("用户名或密码为空！请输入用户名和密码...");
//login.pwd.value=" ";
//return false;
                return false;
            }
            else if(pass1!=pass2)
            {
                alert("两次输入密码不同！请重新输入...");
//login.pwd.value=" ";
                return false;
            }
            else
                return true;
        }

    </script>
</head>

<body>

<div id="login_frame">
    <p style="background-position: center;font-weight: bold">USER SYSTEM</p>
    <form method="post" action="RegistChecker.jsp" name="Register" id="Register">
        <p><label class="label_input">用户名</label><input type="text" name="username" value="" class="text_field" onchange="checkvalid2()" required/></p>
        <p><label class="label_input">密码</label><input type="password" name="password" value="" class="text_field" onchange="checkvalid2()" required/></p>
        <div id="login_control">
            <input type="submit" id="btn_login" onclick="return checkvalid2()" value="注册"/>

        </div>
    </form>
</div>

</body>
</html>
