<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>笨鸟软件-人才招聘</title>
<link href="${ctxStatic}/modules/cms/front/themes/pc/common.css" type="text/css" rel="stylesheet" />
<link href="${ctxStatic}/modules/cms/front/themes/pc/recruit.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
  function show(c_Str,imgg){
	if(document.all(c_Str).style.display=='none'){
		document.all(c_Str).style.display='block';
		document.all(imgg).src='${ctxStatic}/images/pc/reduction.png'
	}else{
		document.all(c_Str).style.display='none';
		document.all(imgg).src='${ctxStatic}/images/pc/add.png'
	}
 }
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
				<li><a href="${ctx}/success.html">成功案例</a></li>
				<li><a href="${ctx}/recruitment.html" class="active">人才招聘</a></li>
				<li><a href="${ctx}/contact.html">联系方式</a></li>
			</ul>
		</div>
	</div>
	<div class="imgAnnounce">
		<img alt="" src="${ad.image}">
	</div>
	<div class="recruitbox">
		<div class="h_center">
			<div class="recruitLeft">
				<c:forEach items="${positionList}" var="position">
					<div class="recruitmentTit" onclick='show("tip432","img432")'>
						<img id=img432 hspace=1 src="${ctxStatic}/images/pc/add.png" align=absMiddle border=0>
						java中级工程师
					</div>
					<div id=tip432 class="recruitmentCon">
						<div class="recruitTxt">
							<p>职位描述：</p>
							<p>1.根据上级安排完成公司项目研发工作；</p>
							<p>2.理解应用系统架构，对所负责的软件模块进行详细设计（UI，数据库与类图）、编码、单元测试及维护工作；</p>
							<p>3.根据项目经理要求编写符合技术规范的技术文档（数据库设计、UI设计、模块设计、用户指南和安装手册等）；</p>
							<p>4.按照项目进度完成分派的开发工作；</p>
							<p>5.根据项目经理要求开展所参与项目的实施、维护工作；</p>
							<p>6.对项目出现的问题进行分析和调查；可以完成组内的交叉测试；</p>
							<p>7.根据上级安排完成公司项目研发工作；</p>
							<p>8.根据上级安排完成公司项目研发工作；</p>
						</div>
					</div>
				</c:forEach>
				<div class="recruitmentTit" onclick='show("tip432","img432")'>
					<img id=img432 hspace=1 src="${ctxStatic}/images/pc/add.png" align=absMiddle border=0>
					java中级工程师
				</div>
				<div id=tip432 class="recruitmentCon">
					<div class="recruitTxt">
						<p>职位描述：</p>
						<p>1.根据上级安排完成公司项目研发工作；</p>
						<p>2.理解应用系统架构，对所负责的软件模块进行详细设计（UI，数据库与类图）、编码、单元测试及维护工作；</p>
						<p>3.根据项目经理要求编写符合技术规范的技术文档（数据库设计、UI设计、模块设计、用户指南和安装手册等）；</p>
						<p>4.按照项目进度完成分派的开发工作；</p>
						<p>5.根据项目经理要求开展所参与项目的实施、维护工作；</p>
						<p>6.对项目出现的问题进行分析和调查；可以完成组内的交叉测试；</p>
						<p>7.根据上级安排完成公司项目研发工作；</p>
						<p>8.根据上级安排完成公司项目研发工作；</p>
					</div>
				</div>
				<div class="recruitmentTit" onclick='show("tip331","img331")'>
					<img id=img331 hspace=1 src="./images/add.png" align=absMiddle border=0>
					java初级工程师
				</div>
				<div id=tip331 class="recruitmentCon">
					<div class="recruitTxt">
						有2种常用的安装方法：硬盘安装和光驱安装。我推荐硬盘安装方式，这样一来安装速度快，二来以后安装驱动的时候比
					</div>
				</div>
				<div class="recruitmentTit" onclick='show("tip247","img247")'>
					<img id=img247 hspace=1 src="./images/add.png" align=absMiddle border=0>
					oracle数据库工程师（DBA）(1人)
				</div>
				<div id=tip247 class="recruitmentCon">
					<div class="recruitTxt">
						硬盘厂商计算容量的方法与操作系统的算法不同，厂家的K、M、G按乘1000的方式进位，而系统则是
					</div>
				</div>
				<div class="recruitmentTit" onclick='show("tip241","img241")'>
					<img id=img241 hspace=1 src="./images/add.png" align=absMiddle border=0>
					高级php软件工程师（3人）
				</div>
				<div id=tip241 class="recruitmentCon">
					<div class="recruitTxt">
						硬盘厂商计算容量的方法与操作系统的算法不同，厂家的K、M、G按乘1000的方式进位，而系统则是
					</div>
				</div>
			</div>
			<div class="recruitRihgt">
				<img src="${ctxStatic}/images/pc/recruit.png">
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