<%@ page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
<head>
<title>index.jsp主页面</title>
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
							<li class="active"><a href="index.form">主  页</a></li>
							<li><a href="resturants.form">分  店</a></li>
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
	<div class="latis">
		<div class="container">
		<div class="col-md-4 latis-left">
			<h3>驴友之家北京分店</h3>
			<img src="${base}images/images/4.jpg" class="img-responsive" alt="">
			<div class="special-info grid_1 simpleCart_shelfItem">
				<p>位于北京市中心地段</p>
				<div class="cur">
					<div class="cur-left">
						<div class="item_add"><span class="item_price"><a class="morebtn hvr-rectangle-in" href="#">加入购物车</a></span></div>
					</div>
					<div class="cur-right">
						<div class="item_add"><span class="item_price"><h6>活动价 ￥188.00</h6></span></div>
					</div>
						<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<div class="col-md-4 latis-left">
			<h3>驴友之家上海分店</h3>
			<img src="${base}images/images/1.jpg" class="img-responsive" alt="">
			<div class="special-info grid_1 simpleCart_shelfItem">
				<p>位于上海浦东新区陆家嘴地区</p>
				<div class="cur">
					<div class="cur-left">
						<div class="item_add"><span class="item_price"><a class="morebtn hvr-rectangle-in" href="#">加入购物车</a></span></div>
					</div>
					<div class="cur-right">
						<div class="item_add"><span class="item_price"><h6>活动价 ￥168.00</h6></span></div>
					</div>
						<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<div class="col-md-4 latis-left">
			<h3>驴友之家杭州分店</h3>
			<img src="${base}images/images/3.jpg" class="img-responsive" alt="">
			<div class="special-info grid_1 simpleCart_shelfItem">
				<p>位于杭州市西湖区</p>
				<div class="cur">
					<div class="cur-left">
						<div class="item_add"><span class="item_price"><a class="morebtn hvr-rectangle-in" href="#">加入购物车</a></span></div>
					</div>
					<div class="cur-right">
						<div class="item_add"><span class="item_price"><h6>活动价 ￥158.00</h6></span></div>
					</div>
						<div class="clearfix"> </div>
				</div>
			</div>
		</div>
			<div class="clearfix"> </div>
	</div>
	</div>
<!-- latis -->	
<!-- feature -->
<div class="feature">
		<div class="container">
			<div class="fle-xsel">
				<ul id="flexiselDemo3">
					<li>
							
									<img src="${base}images/images/1p.jpg" class="img-responsive" alt="">		
								
					</li>
					<li>
							
									<img src="${base}images/images/2p.jpg" class="img-responsive" alt="">		
								
					</li>			
					<li>
							
									<img src="${base}images/images/3p.png" class="img-responsive" alt="">		
								
					</li>		
					<li>
							
									<img src="${base}images/images/4p.jpg" class="img-responsive" alt="">		
								
									
					</li>
					<li>
							
									<img src="${base}images/images/5p.jpg" class="img-responsive" alt="">		
								
					</li>
					<li>
							
									<img src="${base}images/images/6p.jpg" class="img-responsive" alt="">		
								
					</li>
					<li>
							
									<img src="${base}images/images/7p.jpg" class="img-responsive" alt="">		
								
					</li>
					<li>
							
									<img src="${base}images/images/8p.jpg" class="img-responsive" alt="">		
								
					</li>
									
				</ul>
							
							 <script type="text/javascript">
								$(window).load(function() {
									
									$("#flexiselDemo3").flexisel({
										visibleItems: 8,
										animationSpeed: 1000,
										autoPlay: true,
										autoPlaySpeed: 3000,    		
										pauseOnHover: true,
										enableResponsiveBreakpoints: true,
										responsiveBreakpoints: { 
											portrait: { 
												changePoint:480,
												visibleItems: 2
											}, 
											landscape: { 
												changePoint:640,
												visibleItems: 3
											},
											tablet: { 
												changePoint:768,
												visibleItems: 3
											}
										}
									});
									
								});
								</script>
								<script type="text/javascript" src="${base}js/jquery.flexisel.js"></script>
					<div class="clearfix"> </div>
				
			</div>
		</div>
	</div>
<!-- feature -->
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