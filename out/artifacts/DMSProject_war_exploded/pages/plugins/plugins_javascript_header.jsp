<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<link href="<%=basePath%>assets/css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/lineicons/style.css">
<link href="<%=basePath%>assets/css/style.css" rel="stylesheet">
<link href="<%=basePath%>assets/css/style-responsive.css" rel="stylesheet">
<script src="<%=basePath%>assets/js/chart-master/Chart.js"></script>
