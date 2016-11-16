<%@ page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
<head>
<title>个人信息中心</title>
<link href="${base}css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${base}css/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Spicemystery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="${base}js/jquery.min.js"></script>
<link rel="stylesheet" href="${base}css/css/flexslider.css" type="text/css" media="screen" />
<script src="${base}js/simpleCart.min.js"> </script>		
</head>
<body>
<!-- header -->
<div class="head-top"></div>
	<div class="header">
		
		<div class="container">
			<div class="logo">
				<a href="index.form"><img src="${base}images/images/logo.png" class="img-responsive" alt=""></a>
			</div>
			<div class="header-left">
				<div class="head-nav">
					<span class="menu"> </span>
						<ul>
							<li><a href="index.form">主  页</a></li>
							<li><a href="resturants.form">分  店</a></li>
							<li><a href="list.form?name=${buyer.name }">订单</a></li>
							<li class="active"><a href="person.form?name=${buyer.name }">个人中心</a></li>
						</ul>
								<!-- script-for-nav -->
							<script>
								$( "span.menu" ).click(function() {
								  $( ".head-nav ul" ).slideToggle(300, function() {
									// Animation complete.
								  });
								});
							</script>
						<!-- script-for-nav --> 
					</div>
					<div class="header-right1">
					<c:forEach items="${cartlist}" var="cart" varStatus="status">
					</c:forEach>	
						<div class="cart box_1">
							<a href="checkout.form?name=${buyer.name }">
								<h3><span class="simpleCart_total"> ￥ ${cart.price}</span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> ￥ ${cart.numbers} </span> 个)<img src="${base}images/images/bag.png" alt=""></h3>
							</a>	
							<p><a href="list.form?name=${buyer.name }" class="simpleCart_empty">${buyer.name }</a>
							<a href="login.form">退出</a>
							</p>
							<div class="clearfix"> </div>
						</div>
						
						
					</div>
					<div class="clearfix"> </div>
				</div>
					<div class="clearfix"> </div>
			</div>
	</div>
<!-- header -->
	<form action="updateBuyer.form" method="post">
		<table align="center">
			<tr>
				<td>用户编号：</td>
				<td><input type="hidden" name="id" value="${buyer.id }"/>
				${buyer.id }
				</td>
			</tr>
			<tr><td>用户名：</td>
				<td>${buyer.name }<input type="hidden" name="name" value="${buyer.name }"/>
				</td>
			</tr>
			<tr><td>用户密码：</td>
				<td>
				<input name="pwd" value="${buyer.pwd }"/>
				</td>
			</tr>
			<tr><td>操作：</td>
			<td><input type="submit" value="确认修改"/></td></tr>
		</table>
	</form>

<!-- magnust -->	
	<div class="magnust">
		<div class="container">
			<h3>每周特价房</h3>
		<div class="col-md-4 magnust-top">
			
			<div class="magnust-left">
				<img src="${base}images/images/9b.jpg" class="img-responsive" alt="">	
			</div>
			<div class="magnust-right">
				<h4><a href="#">驴友之家上海分店</a></h4>
				<p> 新用户注册入住，即可享受首单88元/天(仅限活动期间)</p>
				<a class="see" href="#">更多</a>
			</div>
				<div class="clearfix"> </div>
		</div>
		<div class="col-md-4 magnust-top">
			<div class="magnust-left">
				<img src="${base}images/images/8b.jpg" class="img-responsive" alt="">	
			</div>
			<div class="magnust-right">
				<h4><a href="#">驴友之家舟山分部定海分店</a></h4>
				<p> 新店特价88元/天(仅限活动期间) </p>
				<a class="see" href="#">更多</a>
			</div>
				<div class="clearfix"> </div>
		</div>
		<div class="col-md-4 magnust-top">
			<div class="magnust-left">
				<img src="${base}images/images/10b.jpg" class="img-responsive" alt="">	
			</div>
			<div class="magnust-right">
				<h4><a href="#">驴友之家江苏分部南京分店</a></h4>
				<p> 十周年店庆仅88元/天(仅限活动期间) </p>
				<a class="see" href="#">更多</a>
			</div>
				<div class="clearfix"> </div>
		</div>
			<div class="clearfix"> </div>
	</div>
	</div>
<!-- magnust -->	
<!-- footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<p>Copyrights © 2015 驴友之家中国总部 | 设计师   <a href="#">Mr Wang</a></p>
			</div>
			<div class="footer-right">
				<ul>
					<li><a href="#"><i class="fbk"></i></a></li>
					<li><a href="#"><i class="googpl"></i></a></li>
					<li><a href="#"><i class="link"></i></a></li>
					<li><a href="#"><i class="rss"></i></a></li>
					<li><a href="#"><i class="twt"></i></a></li>
				</ul>
			</div>	
				<div class="clearfix"></div>
		</div>
	</div>
<!-- footer-->	
</body>
</html>