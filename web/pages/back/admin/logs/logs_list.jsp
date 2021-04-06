<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updatePreUrl = basePath + "pages/back/admin/dept/DeptBackServlet/updatePre";
    String deleteUrl = basePath + "pages/back/admin/dept/DeptBackServlet/delete";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>在线文档管理系统</title>
    <jsp:include page="/pages/plugins/plugins_javascript_header.jsp"/>
</head>
<body>
<section id="container">
    <jsp:include page="/pages/plugins/plugins_header.jsp"/>
    <jsp:include page="/pages/plugins/plugins_left.jsp"/>
    <section id="main-content">
        <section class="wrapper">
            <h4>用户登录日志列表</h4>
            <jsp:include page="/pages/plugins/split_page_plugin_search.jsp"/>
            <c:if test="${allLogs != null}">
                <table class="table table-bordered">
                    <tr>
                        <th>日志编号</th>
                        <th>用户名</th>
                        <th>登录日期</th>
                        <th>登录IP</th>
                    </tr>
                    <c:forEach items="${allLogs}" var="logs">
                        <tr>
                            <td>${logs.logid}</td>
                            <td>${logs.admin.aid}</td>
                            <td>${logs.indate}</td>
                            <td>${logs.ip}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div style="float: right">
                    <jsp:include page="/pages/plugins/split_page_plugin_bar.jsp"/>
                </div>
            </c:if>
        </section>
    </section>
</section>
<jsp:include page="/pages/plugins/plugins_footer.jsp"/>
<jsp:include page="/pages/plugins/plugins_javascript_footer.jsp"/>
<jsp:include page="/pages/plugins/plugin_validate_javascript.jsp"/>
<script type="text/javascript" src="validate/dept_insert.js"></script>
</body>
</html>
