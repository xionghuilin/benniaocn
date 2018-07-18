<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经营产品管理</title>
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
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/cms/businessProductHead/">经营产品列表</a></li>
		<li class="active"><a href="${ctx}/cms/businessProductHead/form?id=${businessProductHead.id}">经营产品<shiro:hasPermission name="cms:businessProductHead:edit">${not empty businessProductHead.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="cms:businessProductHead:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="businessProductHead" action="${ctx}/cms/businessProductHead/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">产品标题：</label>
			<div class="controls">
				<form:input path="content" htmlEscape="false" class="input-xxlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序：</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">经营产品：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>标题</th>
								<th>内容</th>
								<th>状态</th>
								<shiro:hasPermission name="cms:businessProductHead:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="businessProductDetailList">
						</tbody>
						<shiro:hasPermission name="cms:businessProductHead:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#businessProductDetailList', businessProductDetailRowIdx, businessProductDetailTpl);businessProductDetailRowIdx = businessProductDetailRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="businessProductDetailTpl">//<!--
						<tr id="businessProductDetailList{{idx}}">
							<td class="hide">
								<input id="businessProductDetailList{{idx}}_id" name="businessProductDetailList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="businessProductDetailList{{idx}}_delFlag" name="businessProductDetailList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="businessProductDetailList{{idx}}_title" name="businessProductDetailList[{{idx}}].title" type="text" value="{{row.title}}" maxlength="255" class="input-xlarge "/>
							</td>
							<td>
								<textarea id="businessProductDetailList{{idx}}_content" name="businessProductDetailList[{{idx}}].content" rows="4" class="input-xlarge ">{{row.content}}</textarea>
							</td>
							<td>
								<span><input id="businessProductDetailList{{idx}}_status1" name="businessProductDetailList[{{idx}}].status" class="required" type="radio" value="1"><label for="businessProductDetailList{{idx}}_status1">上线</label></span>
								<span><input id="businessProductDetailList{{idx}}_status2" name="businessProductDetailList[{{idx}}].status" class="required" type="radio" value="0"><label for="businessProductDetailList{{idx}}_status2">下线</label></span>
								<span class="help-inline"><font color="red">*</font> </span>
							</td>
							<shiro:hasPermission name="cms:businessProductHead:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#businessProductDetailList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var businessProductDetailRowIdx = 0, businessProductDetailTpl = $("#businessProductDetailTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(businessProductHead.businessProductDetailList)};
							for (var i=0; i<data.length; i++){
								addRow('#businessProductDetailList', businessProductDetailRowIdx, businessProductDetailTpl, data[i]);
								businessProductDetailRowIdx = businessProductDetailRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="cms:businessProductHead:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>