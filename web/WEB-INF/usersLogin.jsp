<%--
  Created by IntelliJ IDEA.
  User: NewLife
  Date: 2019/12/20
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<body>
用户名<input type="text" id="userName" placeholder="请输入用户名">
<p id="userNameError"></p>
密码<input type="password" id="passWord" placeholder="请输入密码">
<p id="passWordError"></p>
<input type="checkbox" id="sign">记住密码<br>
<input type="button" value="注册" onclick="register()">
<input type="button" value="登录" onclick="login()">
</body>
<script type="text/javascript">
    /* 登陆时发送ajax请求 判断用户账号密码 */
    function login() {
        userName = $("#userName").val()
        passWord = $("#passWord").val()
        if (userName == "" || userName == null) {
            $("#userNameError").html("用户名不能为空！")
            return false
        }
        if (passWord == "" || passWord == null) {
            $("#passWordError").html("密码不能为空！")
            return false
        }
        $.ajax({
            "url": "login.do",
            "type": "post",
            "data": {
                "userName": userName,
                "passWord": passWord
            },
            "success": function (data) {
                if (data == "success") {
                    window.location = "toIndex.do"
                } else if (data == "1") {
                    alert("用户名不存在")
                } else if (data == "2") {
                    alert("密码错误")
                }
            }
        });
    }

    /* 跳转用户注册页面 */
    function register() {
        window.location = "toRegister"
    }
</script>
</html>
