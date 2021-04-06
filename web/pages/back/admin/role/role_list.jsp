<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updatePreUrl = basePath + "pages/back/admin/role/RoleBackServlet/updatePre";
    String deleteUrl = basePath + "pages/back/admin/role/RoleBackServlet/delete";
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
            <h2>角色列表</h2>
            <c:if test="${allRole != null}">
                <table class="table table-bordered">
                    <tr>
                        <th>角色名称</th>
                        <th>角色描述</th>
                        <th colspan="2">操作</th>
                    </tr>
                    <c:forEach items="${allRole}" var="role">
                        <tr>
                            <td>${role.title}</td>
                            <td>${role.note}</td>
                            <td><a class="btn btn-success btn-xs" href="<%=updatePreUrl%>?role.rid=${role.rid}">更新</a></td>
                            <td><a class="btn btn-success btn-xs" href="<%=deleteUrl%>?role.rid=${role.rid}">删除</a></td>
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
