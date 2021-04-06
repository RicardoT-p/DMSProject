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
            <h2>部门列表</h2>
            <c:if test="${allDept != null}">
                <table class="table table-bordered">
                    <tr>
                        <th>部门名称</th>
                        <th>部门描述</th>
                        <th colspan="2">操作</th>
                    </tr>
                    <c:forEach items="${allDept}" var="dept">
                        <tr>
                            <td>${dept.title}</td>
                            <td>${dept.note}</td>
                            <td><a class="btn btn-success btn-xs" href="<%=updatePreUrl%>?dept.did=${dept.did}">更新</a></td>
                            <td><a class="btn btn-success btn-xs" href="<%=deleteUrl%>?dept.did=${dept.did}">删除</a></td>
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
