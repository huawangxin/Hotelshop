<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link href="${base}seller/css/admin_login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="sellerlogin_action1.form" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="name" value="" id="name" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="pwd" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="登录" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
<%--    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> &copy; 2015 设计师 <a href="#" target="_blank">驴友之家</a></p>--%>
</div>
</body>
</html>