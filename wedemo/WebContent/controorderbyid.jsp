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
<table border="1">
		
		<tr>
			<td>${idorder.name}</td>
			<td>${idorder.id}</td>
			<td>${idorder.price}</td>
			<td>${idorder.useraddress}</td>
			<td>${idorder.user.id}</td>
			<td>
			<c:if test="${idorder.orderstate == 0}"><div>未接单</div></c:if>
                <c:if test="${idorder.orderstate == 1}"><div class="net">已接单</div></c:if>
                <c:if test="${idorder.orderstate == 2}"><div class="net">已发货</div></c:if>
                <c:if test="${idorder.orderstate == 3}"><div class="net">买家已确认</div></c:if>
			</td>
		</tr>
		
	</table>
</body>
</html>