<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/" ;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>企业在线文档管理系统</title>
</head>
<body>
<h1>对不起，程序出现了错误，请与管理员联系！</h1>
</html>
