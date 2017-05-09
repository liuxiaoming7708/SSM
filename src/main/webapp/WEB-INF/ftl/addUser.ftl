<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
    <meta charset="utf-8">
    <title>添加用户</title>
</head>
<body>
<form action="addUser" method="post">
    用户名:<input type="text" name="userName" id="name"><span id="content"></span><br>
    密&nbsp;&nbsp;码:<input type="password" name="password"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="增加" style="margin-left: 50px;">
    <input type="reset" value="重置" style="margin-left: 0px;">
    <input type="button" value="返回" style="margin-left: 0px;" onclick="window.history.back()">
</form>
</body>
</html>