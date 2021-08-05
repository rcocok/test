<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/6/15
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>--%>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>

<body>
<form action="/regServlet" method="get">
    账号：  <input type="text" name="name"  value="yyyyy" ><span id="show"></span><br>
    密码： <input type="password" name="pwd" ><br>
    <input type="submit" value="登录">
</form>


<script>
    $(function(){
        console.log($("[name='name']"));
        console.log($("[name='name']").val());

        $("[name='name']").blur(function () {

            $.ajax({
                type:'get',
                url:'regServlet?name='+$("[name='name']").val(),
                dataType:'text',
                success:function (data) {
                    if (data==1) {
                        $("#show").html("用户名已存在，请换一个");
                    }else{
                        $("#show").html("用户名可以用");
                    }
                }
            });
        });
    });
</script>

</body>
</html>
