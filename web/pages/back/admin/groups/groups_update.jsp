<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    ///                            pages/back/admin/groups/GroupsBackServlet/insert
    String updateUrl = basePath + "pages/back/admin/groups/GroupsBackServlet/update";
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
            <c:if test="${groups != null}">
                <form action="<%=updateUrl%>" method="post" id="insertForm" class="form-horizontal">
                    <fieldset>
                        <legend>
                            <label>更新权限组</label>
                        </legend>
                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="groups.title" class="control-label">权限组名称</label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="groups.title" id="groups.title"
                                       placeholder="请输入权限组名称！" value="${groups.title}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="groups.icon" class="control-label">图标</label>
                            </div>
                            <div class="col-md-8">
                                <input class="form-control" name="groups.icon" id="groups.icon" value="${groups.icon}" placeholder="请输入图标名称！"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="groups.note" class="control-label">权限组描述</label>
                            </div>
                            <div class="col-md-8">
                                <textarea class="form-control" name="groups.note" id="groups.note" style="resize: none"
                                          placeholder="请输入权限组描述信息！">${groups.note}</textarea>
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
            </c:if>
        </section>
    </section>
</section>
<jsp:include page="/pages/plugins/plugins_footer.jsp"/>
<jsp:include page="/pages/plugins/plugins_javascript_footer.jsp"/>
<jsp:include page="/pages/plugins/plugin_validate_javascript.jsp"/>
<script type="text/javascript" src="validate/groups_insert.js"></script>
</body>
</html>
