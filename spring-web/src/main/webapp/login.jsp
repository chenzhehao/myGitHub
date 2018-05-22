<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="usernameTest"><br/>
    密码：<input type="password" name="passwordTest"><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>