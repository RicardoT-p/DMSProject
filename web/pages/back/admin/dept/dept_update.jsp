<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/back/admin/dept/DeptBackServlet/update";
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
            <c:if test="${dept != null}">
                <form action="<%=updateUrl%>" method="post" id="insertForm" class="form-horizontal">
                    <fieldset>
                        <legend>
                            <label>增加部门</label>
                        </legend>
                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="dept.title" class="control-label">部门名称</label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="dept.title" id="dept.title"
                                       placeholder="请输入部门名称！" value="${dept.title}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1">
                                <label for="dept.note" class="control-label">部门描述</label>
                            </div>
                            <div class="col-md-8">
                                <textarea class="form-control" name="dept.note" id="dept.note" style="resize: none"
                                          placeholder="请输入部门描述信息！">${dept.note}</textarea>
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
<script type="text/javascript" src="validate/dept_insert.js"></script>
</body>
</html>
