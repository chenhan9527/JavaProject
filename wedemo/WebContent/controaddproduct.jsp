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
	<form action="${ctx }/addproduct" method="post">
		<select name="typeid">
			<option value="1">水果</option>
			<option value="2">蔬菜</option>
		</select><br>
		<input type="text" name="name" /><br>
		<input type="text" name="description" /><br>
		<input type="text" name="price" /><br>
		<input type="submit" value="保存" />
	</form>
</body>
</html>