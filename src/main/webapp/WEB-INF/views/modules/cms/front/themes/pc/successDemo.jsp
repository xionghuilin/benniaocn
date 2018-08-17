<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>笨鸟软件-成功案例</title>
<link href="${ctxStatic}/modules/cms/front/themes/pc/common.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/modules/cms/front/themes/pc/successDemo.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$().ready(function() {
	$('#tit span').click(function() {
	    var i = $(this).index();
	    $(this).addClass('select').siblings().removeClass('select');
	    $('#con .box').eq(i).show().siblings().hide();
	});
});
</script>
</head>
<body>
	<div class="headers">
		<div class="h_center">
			<div class="companyLogo"><img alt="" src="${companyInfo.logo}"></div>
			<ul class="nav">
				<li><a href="${ctx}/index.html">首  页</a></li>
				<li><a href="${ctx}/aboutUs.html">关于我们</a></li>
				<li><a href="${ctx}/business.html">经营范围</a></li>
				<li><a href="${ctx}/success.html" class="active">成功案例</a></li>
				<li><a href="${ctx}/recruitment.html">人才招聘</a></li>
				<li><a href="${ctx}/contact.html">联系方式</a></li>
			</ul>
		</div>
	</div>
	<div class="imgAnnounce">
		<img alt="" src="./images/banner.png">
	</div>
	<div class="businessCenter">
		<div class="h_center" id="wrap">
	        <div id="tit">
	            <span class="select">电子商务</span>
	            <span>行业门户</span>
	            <span>移动开发</span>
	            <span>企业应用</span>
	        </div>
	        <div id="con">
	            <div class="box show">
	            	<img alt="" src="./images/sucessdemo1.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo1.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo1.png">
	            	<img alt="" src="./images/sucessdemo1.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo1.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo1.png">
            	</div>
	            <div class="box">
	            	<img alt="" src="./images/sucessdemo2.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo2.png" class="boxShowImg">
            	</div>
	            <div class="box">
	            	<img alt="" src="./images/sucessdemo3.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo3.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo3.png">
	            	<img alt="" src="./images/sucessdemo3.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo3.png" class="boxShowImg">
            	</div>
            	<div class="box">
	            	<img alt="" src="./images/sucessdemo4.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo4.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo4.png">
	            	<img alt="" src="./images/sucessdemo4.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo4.png" class="boxShowImg">
	            	<img alt="" src="./images/sucessdemo4.png">
            	</div>
	        </div>
	    </div>
	</div>
	<div class="footer">
		<P> Copyright © 2015-2018 bennaiocn.com All Rights Reserved. 笨鸟软件版权所有</P>
		<P> 咨询热线：400-041-3773   客服邮箱：service@bennaiocn.com</P>
		<P> 许可证号：京ICP备14009547号</P>
	</div>
</body>
</html>