<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String insertUrl = basePath + "pages/back/admin/admin/AdminSuperBackServlet/insert";
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
            <form action="<%=insertUrl%>" method="post" id="insertForm" class="form-horizontal">
                <fieldset>
                    <legend>
                        <label>增加部门经理</label>
                    </legend>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="admin.aid" class="control-label">经理昵称</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="admin.aid" id="admin.aid"
                                   placeholder="请输入部门经理昵称！">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="admin.dept.did" class="control-label">所属部门</label>
                        </div>
                        <div class="col-md-8">
                            <select name="admin.dept.did" id="admin.dept.did" class="form-control">
                                <c:forEach items="${allDept}" var="dept">
                                    <option value="${dept.did}">${dept.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3 col-md-offset-3">
                            <button type="submit" class="btn btn-success btn-xs">增加</button>
                            <button type="reset" class="btn btn-danger btn-xs">重置</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </section>
    </section>
</section>
<jsp:include page="/pages/plugins/plugins_footer.jsp"/>
<jsp:include page="/pages/plugins/plugins_javascript_footer.jsp"/>
<jsp:include page="/pages/plugins/plugin_validate_javascript.jsp"/>
<script type="text/javascript" src="validate/admin_insert.js"></script>
</body>
</html>
