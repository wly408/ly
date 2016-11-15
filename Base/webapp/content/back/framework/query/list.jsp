<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/content/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@ include file="/content/back/common/base.jsp"%>


</head>
<body style="overflow: hidden;">
	<!--  
	<div data-options="region:'north',split:false" style="height: 100px" >
		<p>这是头部</p>
	</div>-->


		<input type="hidden" value="${queryId}" id="queryId" />
		<div style="height: 100%;overflow: hidden;width: 100%;padding: 0px">
			<table width="100%" height="100%" border="0px">
				<tr>
					<td valign="top">
							
							<table width="100%" border="0" cellspacing="0" cellpadding="0"
								class="xbox">
								<tr>
									<td class="label" nowrap>姓名:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userName" /></td>
									<td class="label" nowrap>账号:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userCode" /></td>
								</tr>
								<tr>
									<td class="label" nowrap>姓名:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userName" /></td>
									<td class="label" nowrap>账号:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userCode" /></td>
								</tr>
								<tr>
									<td class="label" nowrap>姓名:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userName" /></td>
									<td class="label" nowrap>账号:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userCode" /></td>
								</tr>
								<tr>
									<td class="label" nowrap>姓名:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userName" /></td>
									<td class="label" nowrap>账号:</td>
									<td class="content"><input type="text"
										name="queryUserBean.userCode" /></td>
								</tr>
							</table>
					
					</td>
				</tr>
				<tr  valign="top" >
					<td valign="top"  id="listTd" height="100%">
						<table id="grid"   width="100%" height="100%" style="overflow: hidden;">

						</table>
					</td>
				</tr>
			</table>

		</div>


</body>

</html>
<script type="text/javascript"
	src="${ctx}/content/back/framework/query/js/list.js?date=<%= new java.util.Date() %>"></script>


<!-- 外部JS的引入 -->
<c:if test="${jsList!=null && !empty jsList}">
	<c:forEach items="${jsList}" var="jsVar">
		<script type="text/javascript"
			src="${ctx}/${jsVar.jsPath}?date=<%= new java.util.Date() %>"></script>
	</c:forEach>


</c:if>