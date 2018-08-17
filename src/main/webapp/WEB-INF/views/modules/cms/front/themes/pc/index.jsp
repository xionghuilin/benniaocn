<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>笨鸟软件-首页</title>
<link href="${ctxStatic}/modules/cms/front/themes/pc/common.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/modules/cms/front/themes/pc/index.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var length = $(".f1ul li").length;
	var liWidth = $(".f1ul li").outerWidth(true);
	var boxWidth = $(".f2Slider").outerWidth(true);
	var showLength = Math.ceil(boxWidth / liWidth); //显示图片个数
	var speed = 1000;   //滚动速度
	var time = 3000;    //滚动间隔
	var scrollIndex = 1;    //每次滚动的图片数量
	$(".f1ul").css("width",length * liWidth);     //设置滚动盒子宽度
	function scroll(){
		$(".f1ul").stop().animate({"margin-left":"-"+scrollIndex*liWidth+"px"},speed,function(){
		   $(".f1ul").css("margin-left",0);
			for(var i =0;i < scrollIndex;i++){
				//将第一张图片放到最后一张图片后面
			   $(".f1ul").find("li").last().after($(".f1ul").find("li").first());
			 }
		 });
	}
	setInterval(scroll,time);
/*$(document).ready(function() {
	$(".f2Slider").slide({
	      mainCell:".f1ul",
	      titCell: ".num2 ul",
	      autoPlay: "true",
	      autoPage:"true",
	      delayTime:"300"
	 });
	 $(".rollingA,.rollBox").hover(function () {
  		$(".f2Slider .arrow").show();
  	 }, function () {
   		$(".f2Slider .arrow").hide();
  	 });
});*/
</script>
</head>
<body>
	<div class="headers">
		<div class="h_center">
			<div class="companyLogo"><img alt="" src="${companyInfo.logo}"></div>
			<ul class="nav">
				<li><a href="${ctx}/index.html" class="active">首  页</a></li>
				<li><a href="${ctx}/aboutUs.html">关于我们</a></li>
				<li><a href="${ctx}/business.html">经营范围</a></li>
				<li><a href="${ctx}/success.html">成功案例</a></li>
				<li><a href="${ctx}/recruitment.html">人才招聘</a></li>
				<li><a href="${ctx}/contact.html">联系方式</a></li>
			</ul>
		</div>
	</div>

	<div class="f2Slider">
	    <ul class="f1ul">
			<c:forEach items="${adList}" var="ad">
				<li><img src="${ad.image}" alt=""/></li>
			</c:forEach>
		   <!--<a target="_blank" href="#" alt="11111" class="rollingA">
			<li>
				<img alt="" src="./images/screen.png">
			</li>
		   </a>
			<a target="_blank" href="#" alt="22222" class="rollingA">
			<li>
				<img alt="" src="./images/caoyuanEdit.png">
			</li>
		   </a>
		   <a target="_blank" href="#" alt="33333" class="rollingA">
			<li>
				<img alt="" src="./images/screen.png">
			</li>
		   </a>
		   <a target="_blank" href="#" alt="4444" class="rollingA">
			<li>
				<img alt="" src="./images/caoyuanEdit.png">
			</li>
		   </a>-->
	    </ul>
		<!--<div class="rollBox">
			<a class="prev arrow" href="javascript:void(0);"><i class="iconarrow"></i></a>
			<a class="next arrow" href="javascript:void(0);"><i class="iconarrow"></i></a>
		</div>
	    <div class="num2">
	        <ul></ul>
	    </div>-->
	</div>
	<div class="announce">
		 618软件整套打包带走，钜惠火爆进行中，年中大促，优惠力度很大，一对一服务噢
	</div>
	<div class="index_types">
		<ul class="h_center">
			<li class="index_typesLi">
				<img alt="" src="./images/pc.png">
				<p class="typeTitCenter ch">网站建设</p>
				<p class="typeTitCenter en">Website</p>
				<p class="typecon">企业网站制作、高端网站建设、门户网站建设、大型门户平台开发、笨鸟软件让你的软件脱颖而出。。。</p>
			</li>
			<li class="index_typesLi">
				<img alt="" src="./images/mobile.png">
				<p class="typeTitCenter ch">移动开发</p>
				<p class="typeTitCenter en">Mobile Development</p>
				<p class="typecon">手机web网站建设开发、app应用创意与设计开发、触屏版网站设计开发</p>
			</li>
			<li class="index_typesLi">
				<img alt="" src="./images/company.png">
				<p class="typeTitCenter ch">企业应用定制</p>
				<p class="typeTitCenter en">Application Development</p>
				<p class="typecon">为企业提供安全便捷的程序系统开发，为中小企业提供更好的信息化解决方案</p>
			</li>
			<li>
				<img alt="" src="./images/system.png">
				<p class="typeTitCenter ch">系统运维服务</p>
				<p class="typeTitCenter en">Application service</p>
				<p class="typecon">为企业提供在线业务应用服务和管理服务；为中小企业提供管理信息化解决方案</p>
			</li>
		</ul>
	</div>
	<div class="announce">
		<img alt="" src="${ctxStatic}/images/pc/selectTit.png">
		<ul class="selectbox">
			<c:forEach items="${partnerList}" var="partner">
				<li class="imgDiv"><img src="${partner.logo}" alt=""/></li>
			</c:forEach>
		</ul>
	</div>
	<div class="footer">
		<P> Copyright © 2015-2018 bennaiocn.com All Rights Reserved. 笨鸟软件版权所有</P>
		<P> 咨询热线：400-041-3773   客服邮箱：service@bennaiocn.com</P>
		<P> 许可证号：京ICP备14009547号</P>
	</div>
</body>
</html>