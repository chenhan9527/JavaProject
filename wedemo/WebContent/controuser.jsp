<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="controp?pageNum=1&controtype=Product">商品管理</a>
	<a href="addproduct">商品添加</a>
	<a href="controorder?pageNum=1&controtype=Order">订单管理</a>
<table border="1">
		<c:forEach items="${userpage.list}" var="p">
		<tr>
			<td>${p.name}</td>
			<td>${p.id}</td>
			<td>${p.tel}</td>
			<td><a href="producteditservlet?id=${p.id}">修改</a>
			<a href="ProductDeleteServlet?id=${p.id}">删除</a>
			<a href="controuserorder?id=${p.id }&pageNum=1&controtype=Order">订单管理</a>
		</tr>
		</c:forEach>
		<tr><td colspan="4">共有${userpage.totalCount }条数据，一共${page.totalPageNum }页
			<a href="controuser?pageNum=1&controtype=User">首页</a>
			<a href="controuser?pageNum=${userpage.prePageNum }&controtype=User">上一页</a>
			<a href="controuser?pageNum=${userpage.nePageNum }&controtype=User">下一页</a>
			<a href="controuser?pageNum=${userpage.totalPageNum }&controtype=User">末页</a>
			</td></tr>
</table>
</body>
</html>