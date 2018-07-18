<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>横幅广告设置</title>
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
		<li class="active"><a href="javascript:void(0);">横幅广告</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ad" action="${ctx}/cms/ad/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="type" value="1"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<input type="hidden" id="image" name="image" value="${ad.image}"/>
				<sys:ckfinder input="image" type="images" uploadPath="/cms/ad" selectMultiple="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="64" class="input-xlarge required" value="${ad.title}"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">链接：</label>
			<div class="controls">
				<form:input path="url" htmlEscape="false" maxlength="255" class="input-xlarge " value="${ad.url}"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:ad:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
		</div>
	</form:form>
</body>
</html>