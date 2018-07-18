<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经营模式管理</title>
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
		<li class="active"><a href="${ctx}/cms/businessModel/">经营模式列表</a></li>
		<shiro:hasPermission name="cms:businessModel:edit"><li><a href="${ctx}/cms/businessModel/form">经营模式添加</a></li></shiro:hasPermission>
	</ul>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>内容</th>
				<th>更新时间</th>
				<shiro:hasPermission name="cms:businessModel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="businessModel">
			<tr>
				<td><a href="${ctx}/cms/businessModel/form?id=${businessModel.id}">
					${businessModel.content}
				</a></td>
				<td>
					<fmt:formatDate value="${businessModel.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:businessModel:edit"><td>
    				<a href="${ctx}/cms/businessModel/form?id=${businessModel.id}">修改</a>
					<a href="${ctx}/cms/businessModel/delete?id=${businessModel.id}" onclick="return confirmx('确认要删除该经营模式吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>