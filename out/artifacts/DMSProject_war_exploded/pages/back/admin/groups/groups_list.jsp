<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updatePreUrl = basePath + "pages/back/admin/groups/GroupsBackServlet/updatePre";
    String deleteUrl = basePath + "pages/back/admin/groups/GroupsBackServlet/delete?p=p";
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
            <h2>权限组列表</h2>
            <c:if test="${allGroups != null}">
                <table class="table table-bordered">
                    <tr>
                        <th><input type="checkbox"  id="checkAll"></th>
                        <th>权限组名称</th>
                        <th>权限组图标</th>
                        <th>权限组描述</th>
                        <th >操作</th>
                    </tr>
                    <c:forEach items="${allGroups}" var="groups">
                        <tr>
                            <td><input type="checkbox" name="gid" id="gid" value="${groups.gid}"></td>
                            <td>${groups.title}</td>
                            <td><i class="${groups.icon}"></i></td>
                            <td>${groups.note}</td>
                            <td><a class="btn btn-success btn-xs" href="<%=updatePreUrl%>?groups.gid=${groups.gid}">修改</a></td>
                        </tr>
                    </c:forEach>
                </table>

                <div style="float: right">
                    <input type="button" class="btn btn-success" value="批量删除" onclick="deleteAll('<%=deleteUrl%>','ids','gid')">
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
