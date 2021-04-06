<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updatePreUrl = basePath + "pages/back/admin/action/ActionBackServlet/updatePre";
    String deleteUrl = basePath + "pages/back/admin/action/ActionBackServlet/delete?p=p";
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
            <c:if test="${allActions != null}">
                <table class="table table-bordered">
                    <tr>
                        <th><input type="checkbox"  id="checkAll"></th>
                        <th>权限组名称</th>
                        <th>权限组名称</th>
                        <th>权限组图标</th>
                        <th>权限组描述</th>
                        <th >操作</th>
                    </tr>
                    <c:forEach items="${allActions}" var="action">
                        <tr>
                            <td><input type="checkbox" name="actid" id="actid" value="${action.actid}"></td>
                            <td>${action.title}</td>
                            <td>
                                <select class="form-control" disabled>
                                    <c:forEach items="${allGroups}" var="groups">
                                        <option value="${groups.gid}" ${groups.gid==action.groups.gid?"selected":""}>${groups.title}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><i class="${action.icon}"></i></td>
                            <td>${action.url}</td>
                            <td><a class="btn btn-success btn-xs" href="<%=updatePreUrl%>?action.actid=${action.actid}">修改</a></td>
                        </tr>
                    </c:forEach>
                </table>

                <div style="float: right">
                    <input type="button" class="btn btn-success" value="批量删除" onclick="deleteAll('<%=deleteUrl%>','ids','actid')">
                </div>
            </c:if>
            <br>
            <br>
            <br>
            <br>
            <br>
        </section>
    </section>
</section>
<jsp:include page="/pages/plugins/plugins_footer.jsp"/>
<jsp:include page="/pages/plugins/plugins_javascript_footer.jsp"/>
<jsp:include page="/pages/plugins/plugin_validate_javascript.jsp"/>
<script type="text/javascript" src="validate/dept_insert.js"></script>
</body>
</html>
