<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
    String showByDid = basePath +"/pages/back/admin/document/DocumentBackServlet/showByDid";
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
            <h2>部门文档列表</h2>
            <c:if test="${allDocuments != null}">
                <c:forEach items="${allDocuments}" var="document">
                   <div class="col-md-3">
                       <a class="btn-primary" href="<%=showByDid%>?document.dcid=${document.dcid}">${document.title}</a>
                   </div>
                </c:forEach>
                <br>
                <br>
                <br>
                    <div style="float: right">
                        <jsp:include page="/pages/plugins/split_page_plugin_bar.jsp"></jsp:include>
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
