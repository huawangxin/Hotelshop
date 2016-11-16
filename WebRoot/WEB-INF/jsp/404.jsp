<%@ page pageEncoding="utf-8" errorPage="true"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="../css/main.css" type="text/css" media="screen, projection" /> <!-- main stylesheet -->
<link rel="stylesheet" type="text/css" media="all" href="../css/tipsy.css" /> <!-- Tipsy implementation -->

<!--[if lt IE 9]>
	<link rel="stylesheet" type="text/css" href="css/ie8.css" />
<![endif]-->

<script type="text/javascript" src="../scripts/jquery-1.7.2.min.js"></script> <!-- uiToTop implementation -->
<script type="text/javascript" src="../scripts/custom-scripts.js"></script>
<script type="text/javascript" src="../scripts/jquery.tipsy.js"></script> <!-- Tipsy -->

<script type="text/javascript">

$(document).ready(function(){
			
	universalPreloader();
						   
});

$(window).load(function(){

	//remove Universal Preloader
	universalPreloaderRemove();
	
	rotate();
    dogRun();
	dogTalk();
	
	//Tipsy implementation
	$('.with-tooltip').tipsy({gravity: $.fn.tipsy.autoNS});
						   
});

</script>


<title>404 - Not found</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>

<!-- Universal preloader -->
<div id="universal-preloader">
    <div class="preloader">
        <img src="../images/universal-preloader.gif" alt="universal-preloader" class="universal-preloader-preloader" />
    </div>
</div>
<!-- Universal preloader -->

<div id="wrapper">
<!-- 404 graphic -->
	<div class="graphic"></div>
<!-- 404 graphic -->
<!-- Not found text -->
	<div class="not-found-text">
    	<h1 class="not-found-text">文件未找到!</h1>
    </div>
<!-- Not found text -->

<!-- search form -->
<div class="search">
	<form name="search" method="get" action="#" />
        <input type="text" name="search" value="Search ..." />
        <input class="with-tooltip" title="Search!" type="submit" name="submit" value="" />
</div>
<!-- search form -->

<!-- top menu -->
<div class="top-menu">
	<a href="#" class="with-tooltip" title="Return to the home page">首页</a> | <a href="#" class="with-tooltip" title="Navigate through our sitemap">站点地图</a> | <a href="#" class="with-tooltip" title="Contact us!">联系</a> | <a href="#" class="with-tooltip" title="Request additional help">帮助</a>
</div>
<!-- top menu -->

<div class="dog-wrapper">
<!-- dog running -->
	<div class="dog"></div>
<!-- dog running -->
	
<!-- dog bubble talking -->
	<div class="dog-bubble">
    	
    </div>
    
    <!-- The dog bubble rotates these -->
    <div class="bubble-options">
    	<p class="dog-bubble">
        	你输了，芽？别担心，我是一个很好的指导！
        </p>
    	<p class="dog-bubble">
	        <br />
        	 汪! 汪!
        </p>
        <p class="dog-bubble">
        	<br />
        	不用担心！我就可以了！
        </p>
        <p class="dog-bubble">
        	我希望我有一个饼干<br /><img style="margin-top:8px" src="../images/cookie.png" alt="cookie" />
        </p>
        <p class="dog-bubble">
        	<br />
        	吉兹！这是很烦人！
        </p>
        <p class="dog-bubble">
        	<br />
        	我在越来越接近？
        </p>
        <p class="dog-bubble">
        	还是我只是要在圈子？罗...
        </p>
        <p class="dog-bubble">
        	<br />
            OK，我现在正式失去了...
        </p>
        <p class="dog-bubble">
        	I think I saw a <br /><img style="margin-top:8px" src="../images/cat.png" alt="cat" />
        </p>
        <p class="dog-bubble">
        	那么，我们应该在寻找，到底？ @_@
        </p>
    </div>
    <!-- The dog bubble rotates these -->
<!-- dog bubble talking -->
</div>

<!-- planet at the bottom -->
	<div class="planet"></div>
<!-- planet at the bottom -->
</div>
</body>
</html>