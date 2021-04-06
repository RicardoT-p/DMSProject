<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
    String showUrl = basePath +"/pages/back/admin/document/DocumentBackServlet/show";
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
            <h2>部门待审核文档列表</h2>
            <c:if test="${allDocuments != null}">
                <table class="table table-bordered">
                    <tr>
                        <th>文档名称</th>
                        <th>发布人员</th>
                        <th>创建日期</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${allDocuments}" var="document">
                        <tr>
                            <td>${document.title}</td>
                            <td>${document.admin.aid}</td>
                            <td>${document.credate}</td>
                            <td><a class="btn btn-success btn-xs" href="<%=showUrl%>?document.dcid=${document.dcid}">审核</a></td>
                        </tr>
                    </c:forEach>
                </table>
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
