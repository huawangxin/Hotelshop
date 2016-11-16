<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
<head>
<title>checkout购物车页面</title>
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
							<a href="checkout.form?name=${buyer.name }">
								<span class="simpleCart_total">￥ 0.00</span> (<span id="simpleCart_quantity" class="simpleCart_quantity">0</span> 个)<img src="${base}images/images/bag.png" alt="">
							</a>	
							<p><a href="javascript:;" class="simpleCart_empty">清空购物车</a></p>
							<div class="clearfix"> </div>
						</div>
					</div>
					<div class="clearfix"> </div>
				</div>
					<div class="clearfix"> </div>
			</div>
	</div>
<!-- header -->
<!-- checkout -->
<div class="cart-items">
	<div class="container">
			 <h1>我的购物车()</h1>
			   <script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
	<c:forEach items="${cartlist}" var="cart" varStatus="status">${sellergood.goodname}
	
	
			<form  method="post" action="paycart.form">
			 <div class="cart-header">
				 <div class="close1"> </div>
				 <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							 <img src="${base}mages/images/6p.jpg" class="img-responsive" alt="">
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"> ${cart.goodname } </a><span>编号:${cart.cartid }</span></h3>
						<ul class="qty">
							
							<li><p>温馨提示：请提前24小时预订哦</p></li>
							<li><p>特价中</p>
							
							</li>
						</ul>
							 <div class="delivery">
							 <p> 价格: ${cart.price}</p>
							 <span>
							 <input name="cartid" value="${cart.cartid }"  type="hidden"/>
							<input name="name" value="${cart.name }"  type="hidden"/>
							<input name="goodname" value="${cart.goodname }"  type="hidden"/>
							<input name="numbers" value="${cart.numbers }"  type="hidden"/>
							<input name="price" value="${cart.price }"  type="hidden"/>
							 	<input type="submit" value="结算"/>
							 	<%--<a href="paycart.form?cartid=${cart.cartid }">结算</a>--%>
							 	<a href="delCart.form?cartid=${cart.cartid }&name=${cart.name }">删除</a>
							 </span>
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
				</div>
			 </div>
			</form>
	</c:forEach>	 		
		 </div>
		 </div>
<!-- checkout -->	
<!-- footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-left">
				<p>Copyrights © 2015 驴友之家中国总部 | 设计师 <a href="#">Mr Wang</a></p>
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