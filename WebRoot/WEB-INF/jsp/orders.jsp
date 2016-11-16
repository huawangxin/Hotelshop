<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
<head>
<title>分店所有客房页</title>
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
	<c:forEach items="${sellergoodslist}" var="sellergood" varStatus="status">
		<div class="order-top">
			<li class="data"><h4>${sellergood.types}</h4>
				<p> ${sellergood.goodname}</p>
			</li>
			<li class="data">
				<div class="special-info grid_1 simpleCart_shelfItem">
					<h4>单价</h4>
					<div class="pre-top">
						<div class="pr-left">
							<div class="item_add"><span class="item_price"><h6>活动价 ${sellergood.price}元/天</h6></span></div>
						</div>
						<div class="pr-right">
							<div class="item_add"><span class="item_price"><a href="addCart.form?goodname=${sellergood.goodname}&price=${sellergood.price}&name=${buyer.name}">加入购物车</a></span></div>
						</div>
							<div class="clearfix"></div>
					</div>
					</div>
				</li>
			<div class="clearfix"></div>
		</div>
	</c:forEach>	
		<a href="ordersbefore.form?page=${page }">上一页</a>
		第${page}页  共${pagesum }页
		<a href="ordersnext.form?page=${page }">下一页</a> 
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