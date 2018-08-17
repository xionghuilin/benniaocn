<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>笨鸟软件-联系方式</title>
<link href="${ctxStatic}/modules/cms/front/themes/pc/common.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/modules/cms/front/themes/pc/contact.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="headers">
		<div class="h_center">
			<div class="companyLogo"><img alt="" src="${companyInfo.logo}"></div>
			<ul class="nav">
				<li><a href="${ctx}/index.html">首  页</a></li>
				<li><a href="${ctx}/aboutUs.html">关于我们</a></li>
				<li><a href="${ctx}/business.html">经营范围</a></li>
				<li><a href="${ctx}/success.html">成功案例</a></li>
				<li><a href="${ctx}/recruitment.html">人才招聘</a></li>
				<li><a href="${ctx}/contact.html" class="active">联系方式</a></li>
			</ul>
		</div>
	</div>

	<div class="imgAnnounce">
		<img alt="" src="${ad.image}">
	</div>
	<div class="introduce">
		<div class="h_center">
			<div class='contact_1'>
				<p class="contact1_tit">联系我们</p>
				<p>我们时刻关注您的需求，并做好随时能够与您洽谈业务的准备</p>
				<p>您可以给我们打电话，索取专业资料或者预约见面时间，在非工作日期间，您可以拨打值班电话，我们会随时恭候您。</p>
			</div>
			<div class="contact_2">
				<div class="introCompany">
					<P class="company">${companyInfo.name}</P>
					<p>地址：${companyInfo.address}</p>
					<p>邮编：${companyInfo.post}</p>
					<P>电话：${companyInfo.tel}</P>
					<P>传真：${companyInfo.fax}</P>
					<P>邮箱：${companyInfo.mail}</P>
				</div>
				<div class="aboutMap"></div>
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