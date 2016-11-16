<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%
	String nowtime = new SimpleDateFormat("yyyy年MM月dd日")
			.format(Calendar.getInstance().getTime());
%>
<c:url var="base" value="/"></c:url>
<!DOCTYPE HTML>
<html>
	<head>
		<title>确认订单页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="format-detection" content="telephone=no" />

		<link rel="stylesheet" href="${base}css/1/tasp.css" />
		<link href="${base}css/1/orderconfirm.css" rel="stylesheet" />

		<style>
#page {
	width: auto;
}

#comm-header-inner,#content {
	width: 950px;
	margin: auto;
}

#logo {
	padding-top: 26px;
	padding-bottom: 12px;
}

#header .wrap-box {
	margin-top: -67px;
}

#logo .logo {
	position: relative;
	overflow: hidden;
	display: inline-block;
	width: 140px;
	height: 35px;
	font-size: 35px;
	line-height: 35px;
	color: #f40;
}

#logo .logo .i {
	position: absolute;
	width: 140px;
	height: 35px;
	top: 0;
	left: 0;
}
</style>
	</head>
	<body data-spm="1">
		<div id="page">
			<div id="content" class="grid-c">
				<form id="J_Form" name="J_Form" action="count.form" method="post">
					<div>
						<h3 class="dib">
							确认订单信息
						</h3>
						<table cellspacing="0" cellpadding="0" class="order-table"
							id="J_OrderTable" summary="统一下单订单信息区域">
							<thead>
								<tr>
									<th class="s-title">
										房间号
										<hr />
									</th>
									<th class="s-price">
										单价(元/天)
										<hr />
									</th>
									<th class="s-amount">
										天数
										<hr />
									</th>
									<th class="s-agio">
										房型
										<hr />
									</th>
									<th class="s-total">
										小计(元)
										<hr/>
									</th>
								</tr>
							</thead>

							<tbody data-spm="3" class="J_Shop" data-tbcbid="0"
								data-outorderid="47285539868" data-isb2c="false"
								data-postMode="2" data-sellerid="1704508670">
								<tr class="first">
									<td colspan="5"></td>
								</tr>
								<tr class="shop blue-line">
									<td colspan="3">
										店铺：
										<a class="J_ShopName J_MakePoint" data-point-url="#" href="#"
											title="驴友之家中国总部">驴友之家中国总部</a>
										<span class="seller">卖家：<a href="#" class="J_MakePoint"
											data-point-url="#">舟山分部定海分店</a>
										</span>
									</td>
									<td colspan="2" class="promo">
										<div>
											<ul class="scrolling-promo-hint J_ScrollingPromoHint">
											</ul>
										</div>
									</td>
								</tr>
								<tr class="item"
									data-lineid="19614514619:31175333266:35612993875"
									data-pointRate="0">
									<td class="s-title">
										<a href="#" title="${cart.goodname }" class="J_MakePoint"
											data-point-url="#"> <span
											class="title J_MakePoint" data-point-url="#">
												${cart.goodname } </span>
												<input type="hidden" name="goodname" value="${cart.goodname }" />
										</a>
										<div class="props">
											<span>商品编号：${cart.cartid } </span>
											<input type="hidden" name="cartid" value="${cart.cartid }" />
										</div>
										<a title="消费者保障服务，卖家承诺商品如实描述" href="#"></a>
										<div>
											<span style="color: gray;">卖家承诺支持随时退款，过期退款</span>
										</div>
									</td>
									<td class="s-price">

										<span class='price '> <em
											class="style-normal-small-black J_ItemPrice">${cart.price}</em> </span>
									</td>
									<td class="s-amount" data-point-url="">
										<input name="numbers" value="${cart.numbers }" type="text"/>
										<input type="hidden" name="prices" value="${cart.numbers*cart.price }" />
									</td>
									<td class="s-agio">
										<div class="J_Promotion promotion" data-point-url="">
											${sellergoods.types }
										</div>
									</td>
									<td class="s-total">

										<span class='price '> <em
											class="style-normal-bold-red J_ItemTotal ">${cart.price*cart.numbers}</em> </span>
									</td>
								</tr>



								<tr class="item-service">
									<td colspan="5" class="servicearea" style="display: none"></td>
								</tr>

								<tr class="blue-line" style="height: 2px;">
									<td colspan="5"></td>
								</tr>
								<tr class="other other-line">
									<td colspan="5">
										<ul class="dib-wrap">
											<li class="dib user-info">
												<ul class="wrap">
													<li>
														<div class="field gbook">
															<label class="label">
																给卖家留言：
															</label>
															<textarea style="width: 350px; height: 80px;"
																title="选填：对本次交易的补充说明（建议填写已经和卖家达成一致的说明）" name=""></textarea>
														</div>
													</li>
												</ul>
											</li>
											<li class="dib extra-info">

												<div class="shoparea">
													<ul class="dib-wrap">
														<li class="dib title">
															店铺优惠：
														</li>
														<li class="dib sel">
															<div class="J_ShopPromo J_Promotion promotion clearfix"
																data-point-url="#"></div>
														</li>
														<li class="dib fee">
															<span class='price '> -<em
																class="style-normal-bold-black J_ShopPromo_Result">0.00</em>
															</span>
														</li>
													</ul>
												</div>

												<div class="shoppointarea"></div>

												<div class="farearea">
													<ul class="dib-wrap J_farearea">
														<li class="dib title">
															运送方式：
														</li>
														<li class="dib sel"
															data-point-url="http://log.mmstat.com/jsclick?cache=*&tyxd=wlysfs">
															<select name="1704508670:2|post" class="J_Fare">
																<option data-fare="1500" value=" 2 "
																	data-codServiceType="2" data-level=""
																	selected="selected">
																	快递 0.00元
																</option>
																<option data-fare="2500" value=" 7 "
																	data-codServiceType="7" data-level="">
																	EMS 0.00元
																</option>
																<option data-fare="1500" value=" 1 "
																	data-codServiceType="1" data-level="">
																	平邮 0.00元
																</option>
															</select>
															<em tabindex="0" class="J_FareFree" style="display: none">免邮费</em>
														</li>
														<li class="dib fee">
															<span class='price '> <em
																class="style-normal-bold-red J_FareSum">0.00</em> </span>
														</li>
													</ul>
												</div>
												<div class="extra-area">
													<ul class="dib-wrap">
														<li class="dib title">
															适用时间：
														</li>
														<li class="dib content">
															卖家承诺订单在买家付款后即可
														</li>
													</ul>
												</div>

												<div class="servicearea" style="display: none"></div>
											</li>
										</ul>
									</td>
								</tr>

								<tr class="shop-total blue-line">
									<td colspan="5">
										店铺合计(含运费)：
										<span class='price g_price '> <span>&yen;</span><em
											class="style-middle-bold-red J_ShopTotal">${cart.price*cart.numbers}</em> </span>
										
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="5">
										<div class="order-go" data-spm="4">
											<div class="J_AddressConfirm address-confirm">
												<div class="kd-popup pop-back" style="margin-bottom: 40px;">
													<div class="box">
														<div class="bd">
															<div class="point-in">
																<em class="t">实付款：</em>
																<span class='price g_price '> <span>&yen;</span><em
																	class="style-large-bold-red" id="J_ActualFee">${cart.price*cart.numbers}</em> </span>
															</div>
															<table>
																<tr>
																	<td>
																		用户名
																	</td>
																	<td>
																		<input name="name" value="${cart.name }" type="text" />
																	</td>
																</tr>
																<tr>
																	<td>
																		手机
																	</td>
																	<td>
																		<input name="phone" value="" type="text" />
																	</td>
																</tr>
																<tr>
																	<td>
																		入住日期
																	</td>
																	<td>
																		<input name="date1" value="<%=nowtime%>" type="text" />
																	</td>
																</tr>
																<tr>
																	<td>
																		退房日期
																	</td>
																	<td>
																		<input name="date2" value="按入住日期格式书写" type="text" />
																	</td>
																</tr>
															</table>
														</div>
													</div>
													<a href="checkout.form?name=张三" class="back J_MakePoint">返回购物车</a>
													<a id="J_Go" class=" btn-go" tabindex="0" onclick="document.getElementById('J_Form').submit() ">提交订单
<%--													<input type="submit"  value="提交订单" id="J_Go" class=" btn-go" tabindex="0"/>--%>
													<b class="dpl-button"></b>
													</a>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>