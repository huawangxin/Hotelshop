<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆界面</title>
<link rel="stylesheet" type="text/css" href="${base}css/style.css" />
<link rel="stylesheet" type="text/css" href="${base}css/body.css"/> 
</head>
<body>
<div class="container">
	<section id="content">
		<!-- 将 Web应用程序的路径保持到属性base -->
		<form action="${base}login/loginaction.form" method="post">
			<h1>会员登录</h1>
			<div>
				<input type="text" placeholder="用户名" required="" id="name" name="name"/>
			</div>
			<div>
				<input type="password" placeholder="密 码" required="" id="pwd" name="pwd"/>
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span></div> 
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
				<a href="#">忘记密码?</a>
				<!-- <a href="#">Register</a> -->
			</div>
		</form><!-- form -->
		 <div class="button">
			<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
			<a href="register.form">注册新用户</a>	
		</div> <!-- button -->
	</section><!-- content -->
</div>
</body>
</html>