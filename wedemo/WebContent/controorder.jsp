<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<form action="${ctx }/controorderbyid">
		<input name="id" type="text" value="请输入订单号"/>
		<input type="submit" value="查询"/>
	</form>
		<c:forEach items="${orderpage.list}" var="p">
		<tr>
			<td>${p.name}</td>
			<td>${p.id}</td>
			<td>${p.price}</td>
			<td>${p.useraddress}</td>
			<td>${p.user.id}</td>
			<td><a href="controorderbyid?id=${p.id}">订单详情</a>
			<a href="controorderdelete?id=${p.id}">删除</a></td>
		</tr>
		</c:forEach>
		<tr><td colspan="4">共有${orderpage.totalCount }条数据，一共${orderpage.totalPageNum }页
			<a href="controuserorder?id=${id }&pageNum=1&controtype=Order">首页</a>
			<a href="controuserorder?id=${id }&pageNum=${orderpage.prePageNum }&controtype=Order">上一页</a>
			<a href="controuserorder?id=${id }&pageNum=${orderpage.nePageNum }&controtype=Order">下一页</a>
			<a href="controuserorder?id=${id }&pageNum=${orderpage.totalPageNum }&controtype=Order">末页</a>
			</td></tr>
	</table>
</body>
</html>