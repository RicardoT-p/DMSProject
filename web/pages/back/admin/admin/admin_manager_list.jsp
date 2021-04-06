<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateByStatus = basePath + "pages/back/admin/admin/AdminFrontServlet/updateByStatus";
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
            <h2>部门经理列表</h2>
            <c:if test="${allAdminByType != null}">
                <table class="table table-bordered">
                    <tr>
                        <th>用户名</th>
                        <th>部门状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${allAdminByType}" var="admin">
                        <tr>
                            <td>${admin.aid}</td>
                            <td>
                                <c:if test="${admin.status==1}">
                                    正常
                                </c:if>
                                <c:if test="${admin.status==2}">
                                    锁定
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${admin.status==1}">
                                    <a class="btn btn-success btn-xs"
                                       href="<%=updateByStatus%>?admin.status=2&admin.aid=${admin.aid}">锁定</a>
                                </c:if>
                                <c:if test="${admin.status==2}">
                                    <a class="btn btn-success btn-xs"
                                       href="<%=updateByStatus%>?admin.status=1&admin.aid=${admin.aid}">激活</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
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
