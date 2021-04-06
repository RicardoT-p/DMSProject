<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <p class="centered"><img src="upload/admin/${admin.photo}" class="img-circle" width="60"></p>
            <h5 class="centered">
                管理员：${admin.aid}<br>
                ${admin.lastdate}
            </h5>
            <li class="mt">
                <a class="active" href="pages/back/index.jsp">
                    <i class="fa fa-dashboard"></i>
                    <span>关于我们</span>
                </a>
            </li>

            <c:if test="${admin != null}">
                <c:forEach items="${admin.role.groups}" var="groups">
                    <li class="sub-menu">
                        <a href="javascript:;">
                            <i class="${groups.icon}"></i>
                            <span>${groups.title}</span>
                        </a>
                        <ul class="sub">
                            <c:forEach items="${groups.actions}" var="action">
                                <li><a href="${action.url}"><i class="${action.icon}"></i>${action.title}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </c:if>

            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="glyphicon glyphicon-edit"></i>
                    <span>修改信息</span>
                </a>
                <ul class="sub">
                        <li><a href="pages/back/admin/admin_updateByPassword.jsp"><i class="glyphicon glyphicon-arrow-right"></i>修改密码</a></li>
                </ul>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>