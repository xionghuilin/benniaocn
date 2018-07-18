<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>主打产品管理</title>
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
		<li class="active"><a href="${ctx}/cms/mainProduct/">主打产品列表</a></li>
		<shiro:hasPermission name="cms:mainProduct:edit"><li><a href="${ctx}/cms/mainProduct/form">主打产品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="mainProduct" action="${ctx}/cms/mainProduct/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>中文标题：</label>
				<form:input path="titleZh" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>英文标题：</label>
				<form:input path="titleUs" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>中文标题</th>
				<th>英文标题</th>
				<th>简介信息</th>
				<th>图片</th>
				<th>更新时间</th>
				<shiro:hasPermission name="cms:mainProduct:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="mainProduct">
			<tr>
				<td><a href="${ctx}/cms/mainProduct/form?id=${mainProduct.id}">
					${mainProduct.titleZh}
				</a></td>
				<td>
					${mainProduct.titleUs}
				</td>
				<td>
					${mainProduct.intro}
				</td>
				<td>
					<img src="${mainProduct.image}" width="200" height="200"/>
				</td>
				<td>
					<fmt:formatDate value="${mainProduct.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:mainProduct:edit"><td>
    				<a href="${ctx}/cms/mainProduct/form?id=${mainProduct.id}">修改</a>
					<a href="${ctx}/cms/mainProduct/delete?id=${mainProduct.id}" onclick="return confirmx('确认要删除该主打产品吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>