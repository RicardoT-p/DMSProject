<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <title>在线文档管理系统登录页面</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
</head>
<body>

<div id="login-page">
    <div class="container">

        <form class="form-login" action="<%=basePath%>AdminServletBack/login" method="post" id="loginForm">
            <h2 class="form-login-heading">后台登录系统</h2>
            <div class="login-wrap">
                <input type="text" class="form-control" name="admin.aid" id="admin.aid" value="admin" placeholder="用户帐号。。。">
                <br>
                <input type="password" class="form-control" name="admin.password" id="admin.password" value="12345678"  placeholder="用户密码。。。">
                <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> 忘 记 密 码 ?</a>
		                </span>
                </label>
                <input class="btn btn-theme btn-block" type="submit" value="登录"/>
                <hr>
                <div class="registration">
                    版权所有@<br/>
                    <a class="" href="http://www.ylcto.cn">
                        优乐云课堂
                    </a>
                </div>

            </div>

            <!-- Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Forgot Password ?</h4>
                        </div>
                        <div class="modal-body">
                            <p>Enter your e-mail address below to reset your password.</p>
                            <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                        </div>
                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                            <button class="btn btn-theme" type="button">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- modal -->
        </form>
    </div>
</div>
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
<jsp:include page="/pages/plugins/plugin_validate_javascript.jsp"/>
<script type="text/javascript" src="validate/login.js"></script>
<script>
    $.backstretch("assets/img/login-bg.jpg", {speed: 500});
</script>
</body>
</html>
