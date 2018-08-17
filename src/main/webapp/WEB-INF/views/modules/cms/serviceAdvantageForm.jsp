<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务优势管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/serviceAdvantage/">服务优势列表</a></li>
		<li class="active"><a href="${ctx}/cms/serviceAdvantage/form?id=${serviceAdvantage.id}">服务优势<shiro:hasPermission name="cms:serviceAdvantage:edit">${not empty serviceAdvantage.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:serviceAdvantage:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="serviceAdvantage" action="${ctx}/cms/serviceAdvantage/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font>建议小于20个汉字或符号</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">前缀logo：</label>
			<div class="controls">
				<input type="hidden" id="preImage" name="preImage" value="${serviceAdvantage.preImage}"/>
				<sys:ckfinder input="preImage" type="images" uploadPath="/cms/serviceAdvantage" selectMultiple="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
				<span class="help-inline">建议小于80个汉字或符号</span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:serviceAdvantage:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>