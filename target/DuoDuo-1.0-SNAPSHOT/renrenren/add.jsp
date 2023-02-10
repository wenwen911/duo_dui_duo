<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/10
  Time: 上午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){

            $("#TJ").click(function (){
                $.ajax({
                    url:"<%=request.getContextPath()%>/dao?m=add",
                    data:$("#ff").serialize(),
                    dataType: "json",
                    type:"post",
                    success:function (resp){
                        if(resp){
                            location = "../dao?m=queryren"
                        }
                    }
                });
            });
            $.ajax({
                url:"<%=request.getContextPath()%>/dao?m=querywuqi",
                dataType:"json",
                success:function (resp){
                    for(let wuqi of resp){
                        $("#gj").append("<input type='checkbox' name='cd' class='cd' value="+wuqi.wid+">"+wuqi.name);
                    }
                }
            });
        })
    </script>
</head>
<body>
<form id="ff">
    <table>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <input type="text" name="age" id="age">
            </td>
        </tr>
        <tr>
            <td>工具</td>
            <td id="gj">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="提交" id="TJ">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
