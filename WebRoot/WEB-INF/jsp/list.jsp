<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib  prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
<head>
<title>个人中心</title>
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
							<li><a href="resturants.form">分  店</a></li>
							<li class="active"><a href="list.form?name=${buyer.name }">订单</a></li>
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
<!-- checkout -->
<div class="cart-items">
	<div class="container">
			 
			   <script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
	
			<form  method="post" action="paycart.form">
			
			 	<table align="center">
			 		<tr>
			 			<td align="center"  width="100">
			 				<h5>订单编号</h5>
			 			</td>
			 			<td align="center" width="100">
			 				<h5>房间名    </h5>
			 			</td>
			 			<td align="center" width="100">
			 				<h5>天       数</h5>
			 			</td>
			 			<td align="center" width="100">
			 				<h5>总价格      </h5>
			 			</td>
			 			<td align="center" width="100">
			 				<h5>联系电话</h5>
			 			</td>
			 			<td align="center" width="150">
			 				<h5>预订日期</h5>
			 			</td>
			 			<td align="center" width="150">
			 				<h5>退房日期</h5>
			 			</td>
			 			<td align="center" width="100">
			 				<h5>订单状态</h5>
			 			</td>
			 			<td align="center" width="100">
			 				<h5>操        作</h5>
			 			</td>
			 		</tr>
			 <c:forEach items="${orderlist}" var="order" varStatus="status">
					
			 		
			 		<tr>
			 			<td align="center" width="100">${order.listid }
			 				<input name="listid"  value="${order.listid }"  type="hidden"/>
			 			</td>
			 			<td align="center" width="100">${order.goodname }
			 				<input name="goodname"  value="${order.goodname }" type="hidden"/>
			 			</td>
			 			<td align="center" width="100">${order.numbers }
			 				<input name="numbers"  value="${order.numbers }" type="hidden"/>
			 			</td>
			 			<td align="center" width="100">${order.prices }
			 				<input name="prices"  value="${order.prices }" type="hidden"/>
			 			</td>
			 			<td align="center" width="100">${order.phone }
			 				<input name="phone"  value="${order.phone }" type="hidden"/>
			 			</td>
			 			<td align="center" width="150">${order.date1 }
			 				<input name="date1"  value="${order.date1 }" type="hidden"/>
			 			</td>
			 			<td align="center" width="150">${order.date2 }
			 				<input name="date2"  value="${order.date2 }" type="hidden"/>
			 			</td>
			 			<td align="center" width="100">${order.states }
			 				<input name="states"  value="${order.states }" type="hidden"/>
			 				<input name="name"  value="${order.name }" type="hidden"/>
			 			</td>
			 			<td align="center" width="100">
			 				<a href="count1.form?listid=${order.listid }">付款</a>
<%--			 				<a href="countaction.form?name=${order.name }&goodname=${goodname}&date1=${date1}">付款</a>--%>
			 				<a href="delList.form?name=${order.name }&listid=${order.listid }">删除</a>
			 			</td>
			 		</tr>
			 		
			 		</c:forEach>
			 	</table>
			</form>
	
		
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