<#assign base=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base id="base" href="${base}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${base}/js/jquery-1.6.js"></script>
    <script type="text/javascript" src="${base}/js/user.js"></script>
<script>
    function pageLast(currentPage){
        if(currentPage>=1){
            window.location.href="${request.contextPath}/user/getAllUser?currentPage="+currentPage;
        }
    }
    function pageNext(currentPage){
        if(currentPage<=${pages}){
            window.location.href="${request.contextPath}/user/getAllUser?currentPage="+currentPage;
        }
    }
</script>
</head>
<body>
<table>
    <tr>
        <td>user_name</td>
        <td>password</td>
        <td>age</td>
        <td><a href="${request.contextPath}/user/toAddUser">新增</a></td>
    </tr>
<#list userList?sort_by("age")?reverse as user>
<tr>
    <td>${user.userName}</td>
    <td>${user.password}</td>
    <td>${user.age}</td>
    <td><a href="${request.contextPath}/user/getUser?id=${user.id}">修改</a>
        ||<!--<a href="${request.contextPath}/user/delUser?id=${user.id}">删除</a>-->
         <a href="javascript:delUser(${user.id});">删除</a>
    </td>
</tr>
</#list>
    <tr>
        <td colspan="4">
            总页数${pages}   总条数 ${total} 当前页数 ${currentPage}
        </td>
    </tr>
    <tr>
        <td>
        <a href="#" onclick="pageNext(1);" class="first paginate_button paginate_button_disabled" id="_first">首页</a>
        </td>
        <td>
        <a tabindex="0" onclick="pageLast(${currentPage-1});" class="previous paginate_button paginate_button_disabled" id="DataTables_Table_0_previous">上一页</a>
        </td>
        <td>
        <span><a tabindex="0" class="paginate_active">${currentPage}</a></span>
        </td>
        <td>
        <a tabindex="0" onclick="pageNext(${currentPage+1});" class="next paginate_button paginate_button_disabled" id="DataTables_Table_0_next">下一页</a>
        </td>
        <td>
        <a tabindex="0" onclick="pageNext(${pages});" class="last paginate_button paginate_button_disabled" id="DataTables_Table_0_last">尾页</a>
        </td>
    </tr>
</table>

</body>
</html>