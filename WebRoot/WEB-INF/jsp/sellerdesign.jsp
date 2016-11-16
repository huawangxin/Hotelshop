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
    <link rel="stylesheet" type="text/css" href="${base}seller/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${base}seller/css/main.css"/>
    <script type="text/javascript" src="${base}seller/js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="sellerindex.form">首页</a></li>
                <li><a href="#" target="_blank">用户中心</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员 ${seller.name }</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="login.form">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="sellergoods.form?name=${seller.name }"><i class="icon-font">&#xe003;</i>商品管理</a>
                    <ul class="sub-menu">
                        <li><a href="sellergoods.form"><i class="icon-font">&#xe008;</i>增加商品</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe005;</i>删除商品</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe006;</i>修改商品</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe004;</i>查询商品</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe012;</i>仓库备份</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>订单管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>修改订单</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>删除订单</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>查询订单</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.form">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="search.form" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">标准间</option>
                                    <option value="20">单人间</option>
                                    <option value="20">双人间</option>
                                    <option value="20">三人间</option>
                                    <option value="20">商务间</option>
                                    <option value="20">豪华间</option>
                                    <option value="20">总统间</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.html"><i class="icon-font"></i>新增商品</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
<%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>标题</th>
                            <th>单价</th>
                            <th>房型</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                 <c:forEach items="${sellergoodslist}" var="order" varStatus="status">
			     		<tr>
                            <td class="tc"><input name="id[]" value="59" type="checkbox"></td>
                            <td>${order.goodid }</td>
<%--                            <input name="ids[]" value="59" type="hidden">--%>
                            <td title="发哥经典"><a target="_blank" href="#" title="发哥经典">${order.goodname }</a>
                            </td>
                            <td>${order.price }</td>
                            <td>${order.types }</td>
                            <td>${order.states }</td>
                            <td>
                                <a class="link-update" href="#">修改</a>
                                <a class="link-del" href="#">删除</a>
                            </td>
                        </tr>
			     </c:forEach>
                        
                        
                    </table>
                    <%--<div class="list-page"> 2 条 1/1 页</div>--%>
                    <a href="ordersbefore.form?page=${page }">上一页</a>
					第${page}页  共${pagesum }页
					<a href="ordersnext.form?page=${page }">下一页</a> 
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>