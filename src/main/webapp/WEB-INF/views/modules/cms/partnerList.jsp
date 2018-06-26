<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合作伙伴管理</title>
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
		<li class="active"><a href="${ctx}/cms/partner/">合作伙伴列表</a></li>
		<shiro:hasPermission name="cms:partner:edit"><li><a href="${ctx}/cms/partner/form">合作伙伴添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="partner" action="${ctx}/cms/partner/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>合作伙伴名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>合作伙伴网址：</label>
				<form:input path="link" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>合作伙伴名称</th>
				<th>合作伙伴网址</th>
				<th>合作伙伴logo</th>
				<shiro:hasPermission name="cms:partner:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="partner">
			<tr>
				<td><a href="${ctx}/cms/partner/form?id=${partner.id}">
					${partner.name}
				</a></td>
				<td><a href="${partner.link}" target="_blank">
					${partner.link}
				</a></td>
				<td>
					<img src="${partner.logo}"/>
				</td>
				<shiro:hasPermission name="cms:partner:edit"><td>
    				<a href="${ctx}/cms/partner/form?id=${partner.id}">修改</a>
					<a href="${ctx}/cms/partner/delete?id=${partner.id}" onclick="return confirmx('确认要删除该合作伙伴吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>