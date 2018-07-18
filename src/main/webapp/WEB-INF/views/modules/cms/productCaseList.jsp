<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>产品案例管理</title>
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
		<li class="active"><a href="${ctx}/cms/productCase/">产品案例列表</a></li>
		<shiro:hasPermission name="cms:productCase:edit"><li><a href="${ctx}/cms/productCase/form">产品案例添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="productCase" action="${ctx}/cms/productCase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>所属板块：</label>
				<form:select path="type" class="input-xlarge">
					<form:options items="${fns:getDictList('cms_case_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
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
				<th>连接</th>
				<th>所属板块</th>
				<th>图片</th>
				<th>更新时间</th>
				<shiro:hasPermission name="cms:productCase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="productCase">
			<tr>
				<td><a href="${ctx}/cms/productCase/form?id=${productCase.id}">
					${productCase.title}
				</a></td>
				<td><a href="${productCase.url}" target="_blank">
					${productCase.url}
				</a></td>
				<td>
					${fns:getDictLabel(productCase.type,'cms_case_type','电子商务')}
				</td>
				<td>
					<img src="${productCase.image}" width="200" height="200"/>
				</td>
				<td>
					<fmt:formatDate value="${productCase.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="cms:productCase:edit"><td>
    				<a href="${ctx}/cms/productCase/form?id=${productCase.id}">修改</a>
					<a href="${ctx}/cms/productCase/delete?id=${productCase.id}" onclick="return confirmx('确认要删除该产品案例吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>