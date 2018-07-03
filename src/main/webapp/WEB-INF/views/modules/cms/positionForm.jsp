<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招聘信息管理</title>
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
		<li><a href="${ctx}/cms/position/">招聘信息列表</a></li>
		<li class="active"><a href="${ctx}/cms/position/form?id=${position.id}">招聘信息<shiro:hasPermission name="cms:position:edit">${not empty position.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:position:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="position" action="${ctx}/cms/position/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">职位名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职位描述：</label>
			<div class="controls">
				<form:textarea id="description" htmlEscape="true" path="description" rows="4" maxlength="100" class="input-large"/>
				<sys:ckeditor replace="description" uploadPath="/cms/position/description" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职位要求：</label>
			<div class="controls">
				<form:textarea id="requirements" htmlEscape="true" path="requirements" rows="4" maxlength="100" class="input-large"/>
				<sys:ckeditor replace="requirements" uploadPath="/cms/position/requirements" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系方式：</label>
			<div class="controls">
				<form:input path="contact" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">在线状态：</label>
			<div class="controls">
				<form:radiobuttons path="status" items="${fns:getDictList('cms_status')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:position:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>