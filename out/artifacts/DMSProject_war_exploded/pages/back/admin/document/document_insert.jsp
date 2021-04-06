<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
    String insertUrl = basePath +"pages/back/admin/document/DocumentBackServlet/insert";
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
                        <label>增加部门文档</label>
                    </legend>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="document.title" class="control-label">文档名称</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="document.title" id="document.title"
                                   placeholder="请输入文档名称！">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1">
                            <label for="photo" class="control-label">上传文档</label>
                        </div>
                        <div class="col-md-8">
                            <input type="file" class="form-control" name="photo" id="photo"
                                   placeholder="请上传文档,格式为pdf！">
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
<script type="text/javascript" src="validate/dept_insert.js"></script>
</body>
</html>
