<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/back/admin/role/RoleBackServlet/update";
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
            <c:if test="${role != null}">
                <form action="<%=updateUrl%>" method="post" id="insertForm" class="form-horizontal">
                    <fieldset>
                        <legend>
                            <label>增加部门</label>
                        </legend>
                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="role.title" class="control-label">角色名称</label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="role.title" id="role.title"
                                       placeholder="请输入角色名称！" value="${role.title}">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="gid" class="control-label">权限组信息</label>
                            </div>
                            <div class="col-md-8">
                                <c:forEach items="${allGroups}" var="groups">
                                    <div class="col-md-3">
                                        <input type="checkbox"  name="gid" id="gid"
                                               value="${groups.gid}">&nbsp;&nbsp;&nbsp;&nbsp;${groups.title}
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="role.note" class="control-label">角色描述</label>
                            </div>
                            <div class="col-md-8">
                                <textarea class="form-control" name="role.note" id="role.note" style="resize: none"
                                          placeholder="请输入角色描述信息！">${role.note}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3 col-md-offset-3">
                                <input type="hidden" name="dept.did" value="${dept.did}">
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
<script type="text/javascript" src="validate/role_update.js"></script>
</body>
</html>
