<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>主打产品管理</title>
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
		<li><a href="${ctx}/cms/mainProduct/">主打产品列表</a></li>
		<li class="active"><a href="${ctx}/cms/mainProduct/form?id=${mainProduct.id}">主打产品<shiro:hasPermission name="cms:mainProduct:edit">${not empty mainProduct.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:mainProduct:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="mainProduct" action="${ctx}/cms/mainProduct/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<input type="hidden" id="image" name="image" value="${mainProduct.image}"/>
				<sys:ckfinder input="image" type="images" uploadPath="/cms/mainProduct" selectMultiple="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">中文标题：</label>
			<div class="controls">
				<form:input path="titleZh" htmlEscape="false" maxlength="64" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">英文标题：</label>
			<div class="controls">
				<form:input path="titleUs" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介信息：</label>
			<div class="controls">
				<form:textarea path="intro" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:mainProduct:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>