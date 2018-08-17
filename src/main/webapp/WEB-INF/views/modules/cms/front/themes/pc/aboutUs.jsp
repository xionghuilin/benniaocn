<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>笨鸟软件-关于我们</title>
<link href="${ctxStatic}/modules/cms/front/themes/pc/common.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/modules/cms/front/themes/pc/aboutUs.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="headers">
		<div class="h_center">
			<div class="companyLogo"><img alt="" src="${companyInfo.logo}"></div>
			<ul class="nav">
				<li><a href="${ctx}/index.html">首  页</a></li>
				<li><a href="${ctx}/aboutUs.html" class="active">关于我们</a></li>
				<li><a href="${ctx}/business.html">经营范围</a></li>
				<li><a href="${ctx}/success.html">成功案例</a></li>
				<li><a href="${ctx}/recruitment.html">人才招聘</a></li>
				<li><a href="${ctx}/contact.html">联系方式</a></li>
			</ul>
		</div>
	</div>

	<div class="imgAnnounce">
		<img alt="" src="${ad.image}">
	</div>
	<div class="introduce">
		<div class="h_center">
			<div class='contact_1'>
				<p class="contact1_tit">公司介绍</p>
				${companyInfo.description}
				<div class="company_R"><img alt="" src="./images/companyIntro.png"></div>
			</div>
			<div class='contact_1'>
				<p class="contact1_tit">服务优势</p>
				<div>
					<c:forEach items="${serviceAdvantageList}" var="serviceAdvantage">
						<img class="fl" alt="" src="${serviceAdvantage.preImage}">
						<div class="fl">
							<p class="f1tit">${serviceAdvantage.title}</p>
							<P>${serviceAdvantage.remarks}</P>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class='contact_1'>
				<p class="contact1_tit">服务流程</p>
				<div class="processLine">
					<div class="center1"  align="center">
						<c:forEach items="${processList}" var="process">
							<div class="process">
								<span class="processBlock">${process.content}</span>
								<img alt="" src="${ctxStatic}/images/pc/arrow.png">
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="processLine">
					<div class="center1">
						<div class="process">
							<span class="processBlock">页面制作</span>
							<img alt="" src="./images/arrow.png">
						</div>
						<div class="process">
							<span class="processBlock">程序开发</span>
							<img alt="" src="./images/arrow.png">
						</div>
						<div class="process">
							<span class="processBlock">项目测试</span>
							<img alt="" src="./images/arrow.png">
						</div>
						<div class="process">
							<span class="processBlock">项目验收</span>
							<img alt="" src="./images/arrow.png">
						</div>
						<div class="process">
							<span class="processBlock">售后维护</span>
						</div>
					</div>
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