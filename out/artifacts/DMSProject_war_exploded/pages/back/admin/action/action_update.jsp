<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
    ///                            pages/back/admin/groups/GroupsBackServlet/insert
    String updateUrl = basePath +"pages/back/admin/action/ActionBackServlet/update";
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
            <form action="<%=updateUrl%>" method="post" id="insertForm" class="form-horizontal">
                <fieldset>
                    <legend>
                        <label>增加权限</label>
                    </legend>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="action.title" class="control-label">权限名称</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="action.title" id="action.title"
                                   placeholder="请输入权限组名称！" value="${action.title}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="action.groups.gid" class="control-label">权限组名称</label>
                        </div>
                        <div class="col-md-8">
                            <select class="form-control" name="action.groups.gid" id="action.groups.gid">
                                <c:forEach items="${allGroups}" var="groups">
                                    ${groups.gid}==${action.groups.gid}
                                    <option value="${groups.gid}" ${groups.gid==action.groups.gid?"selected":""}>${groups.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="action.icon" class="control-label">图标</label>
                        </div>
                        <div class="col-md-8">
                            <input class="form-control" name="action.icon" id="action.icon" placeholder="请输入图标名称！" value="${action.icon}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="action.url" class="control-label">权限路径</label>
                        </div>
                        <div class="col-md-8">
                            <input class="form-control" name="action.url" id="action.url" placeholder="请输入权限描述信息！" value="${action.url}"/>
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
<script type="text/javascript" src="validate/action_insert.js"></script>
</body>
</html>
