<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/9
  Time: 下午 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $(".XG").click(function (){
                location="<%=request.getContextPath()%>/renrenren/update.jsp?nid="+$(this).next().val()
                });
            $(".SC").click(function (){
                // let nid = $(this).prev().val();
                $.ajax({
                    url:"<%=request.getContextPath()%>/dao?m=delete&nid="+$(this).prev().val(),
                    dataType:"json",
                    success:function (respon){
                        if(respon){
                            location.reload();
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
<table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>工具</td>
        <td>
            <a href="<%=request.getContextPath()%>/renrenren/add.jsp">添加</a>
        </td>

    </tr>
    <c:forEach var="u" items="${am}">
        <tr>
            <td>${u.nid}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>
                <c:forEach items="${u.mc}" var="mc">
<%--                    ${mc.id}--%>
<%--                    ${mc.wuqi.wid}--%>
                    ${mc.wuqi.name}
<%--                    ${mc.wuqi.lang}--%>
                </c:forEach>
            </td>
            <td>
                <input type="button" value="修改" class="XG">
                <input type="hidden" value="${u.nid}">
                <input type="button" value="删除" class="SC">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
