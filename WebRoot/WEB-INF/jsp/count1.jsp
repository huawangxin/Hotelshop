<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML>
<html>
	<head><title>支付页面</title></head>
<body>
		<div id="page">
			<div id="content" class="grid-c">
				<form action="count.form" method="post">
					<div>
						<h3 class="dib">
							付款页面
						</h3>
						<a href="countaction1.form?listid=${buyList.listid }&name=${buyList.name}">确认支付</a>
						<a href="list.form?name=${buyList.name }">取消支付</a>
					</div>
				</form>
			</div>
		</div>
</body>
</html>