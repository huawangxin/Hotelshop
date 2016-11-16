<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
<head>
<title>所有宝贝</title>
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
<div class="head-top">
			
		</div>
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
							<li class="active"><a href="resturants.form">分  店</a></li>
							<li><a href="list.form?name=${buyer.name }">订单</a></li>
							<li><a href="person.form?name=${buyer.name }">个人中心</a></li>
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
						<div class="cart box_1">
							<a href="checkout.html">
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
<!-- about -->
<div class="orders">
	<div class="container">
		<div class="order-top">
			<li class="im-g"><a href="#"><img src="${base}images/images/1p.jpg" class="img-responsive" alt=""></a></li>
			<li class="data"><h4>驴友之家北京分店</h4>
				<p>最低仅需88元</p>
				<P> 钟点房、一天房、常住房</P>
			</li>
			<li class="bt-nn">
				<a class="morebtn hvr-rectangle-in" href="orders.form">进入</a>
			</li>
			<div class="clearfix"></div>
		</div>
		<div class="order-top">
			<li class="im-g"><a href="#"><img src="${base}images/images/2p.jpg" class="img-responsive" alt=""></a></li>
			<li class="data"><h4>驴友之家北京分店</h4>
				<p>最低仅需88元</p>
				<P> 钟点房、一天房、常住房</P>
			</li>
			<li class="bt-nn">
				<a class="morebtn hvr-rectangle-in" href="orders.form">进入</a>
			</li>
			<div class="clearfix"></div>
		</div>
		
	</div>
</div>
<!-- about -->	
<!-- footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<p>Copyrights ©  2015 驴友之家中国总部 | 设计师 <a href="#">Mr Wang</a></p>
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