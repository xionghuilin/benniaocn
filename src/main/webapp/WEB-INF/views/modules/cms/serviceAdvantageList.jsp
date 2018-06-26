<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>服务优势管理</title>
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
		<li class="active"><a href="${ctx}/cms/serviceAdvantage/">服务优势列表</a></li>
		<shiro:hasPermission name="cms:serviceAdvantage:edit"><li><a href="${ctx}/cms/serviceAdvantage/form">服务优势添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="serviceAdvantage" action="${ctx}/cms/serviceAdvantage/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>备注</th>
				<th>更新时间</th>
				<shiro:hasPermission name="cms:serviceAdvantage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="serviceAdvantage">
			<tr>
				<td><a href="${ctx}/cms/serviceAdvantage/form?id=${serviceAdvantage.id}">
					${serviceAdvantage.title}
				</a></td>
				<td>
					${serviceAdvantage.remarks}
				</td>
				<td>
					<fmt:formatDate value="${serviceAdvantage.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:serviceAdvantage:edit"><td>
    				<a href="${ctx}/cms/serviceAdvantage/form?id=${serviceAdvantage.id}">修改</a>
					<a href="${ctx}/cms/serviceAdvantage/delete?id=${serviceAdvantage.id}" onclick="return confirmx('确认要删除该服务优势吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>