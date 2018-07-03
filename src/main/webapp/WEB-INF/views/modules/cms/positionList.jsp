<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>招聘信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/position/">招聘信息列表</a></li>
		<shiro:hasPermission name="cms:position:edit"><li><a href="${ctx}/cms/position/form">招聘信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="position" action="${ctx}/cms/position/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>职位名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>联系方式：</label>
				<form:input path="contact" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>在线状态：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>职位名称</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="cms:position:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="position">
			<tr>
				<td><a href="${ctx}/cms/position/form?id=${position.id}">
					${position.name}
				</a></td>
				<td>
					<fmt:formatDate value="${position.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${position.remarks}
				</td>
				<shiro:hasPermission name="cms:position:edit"><td>
    				<a href="${ctx}/cms/position/form?id=${position.id}">修改</a>
					<a href="${ctx}/cms/position/delete?id=${position.id}" onclick="return confirmx('确认要删除该招聘信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>