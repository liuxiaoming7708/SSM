<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户</title>
</head>
<body>
<form action="updateUser" method="post">
    用户ID:<input type="text" name="id" value="${user.id}" readonly="true"/><br>
    用户名:<input type="text" name="userName" id="name" value="${user.userName}"><br>
    密&nbsp;&nbsp;码:<input type="password" name="password" value="${user.password}"><br>
    年&nbsp;&nbsp;龄:<input type="text" name="age" value="${user.age}"><br>
    <input type="submit" value="修改" style="margin-left: 50px;">
    <input type="reset" value="重置" style="margin-left: 0px;">
    <input type="button" value="返回" style="margin-left: 0px;" onClick="location.href='userList'">
</form>
</body>
</html>