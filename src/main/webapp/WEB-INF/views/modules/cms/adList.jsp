<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>广告设置管理</title>
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
		<li class="active"><a href="${ctx}/cms/ad/">轮播广告列表</a></li>
		<shiro:hasPermission name="cms:ad:edit"><li><a href="${ctx}/cms/ad/form">轮播广告添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ad" action="${ctx}/cms/ad/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>链接</th>
				<th>图片</th>
				<th>更新时间</th>
				<th>状态</th>
				<shiro:hasPermission name="cms:ad:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ad">
			<tr>
				<td><a href="${ctx}/cms/ad/form?id=${ad.id}">
					${ad.title}
				</a></td>
				<td>
					${ad.url}
				</td>
				<td>
					<img src="${ad.image}" width="200" height="200">
				</td>
				<td>
					<fmt:formatDate value="${ad.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<c:choose>
						<c:when test="${ad.status eq '1'}">
							在线
						</c:when>
						<c:otherwise>
							<span style="color: red;">下线</span>
						</c:otherwise>
					</c:choose>
				</td>
				<shiro:hasPermission name="cms:ad:edit"><td>
    				<a href="${ctx}/cms/ad/form?id=${ad.id}">修改</a>
					<a href="${ctx}/cms/ad/delete?id=${ad.id}" onclick="return confirmx('确认要删除该轮播广告吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>