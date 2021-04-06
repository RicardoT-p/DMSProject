<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String insertUrl = basePath + "AdminServletBack/updateByPasswordAndPhoto";
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
            <form action="<%=insertUrl%>" method="post" id="insertForm" class="form-horizontal" enctype="multipart/form-data">
                <fieldset>
                    <legend>
                        <label>修改用户信息</label>
                    </legend>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="admin.password" class="control-label">修改密码</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="admin.password" id="admin.password"
                                   placeholder="请输入密码！">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="admin.photo" class="control-label">头像</label>
                        </div>
                        <div class="col-md-8">
                            <input type="file" class="form-control" name="admin.photo" id="admin.photo">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-3 col-md-offset-3">
                            <button type="submit" class="btn btn-success btn-xs">更新</button>
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
