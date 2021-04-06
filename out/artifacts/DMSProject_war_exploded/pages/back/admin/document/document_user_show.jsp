<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
    String insertUrl = basePath +"pages/back/admin/document/DocumentBackServlet/insert";
    String updateByStatusUrl =  basePath +"pages/back/admin/document/DocumentBackServlet/updateByStatus";
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
            <h2>文档查看</h2>
            <c:if test="${Document != null}">
                <div class="col-md-12">
                    <h5>文件名称: <nobr style="color: green">${Document.title}</nobr></h5>
                </div>
                <div class="col-md-12">
                    <embed src="<%=basePath%>upload/document/${Document.filename}" style="height: 400px;width: 1000px;"/>
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
