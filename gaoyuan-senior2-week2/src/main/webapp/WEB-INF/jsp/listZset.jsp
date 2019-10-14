<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/index_work.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>售出百分比</td>
		</tr>
		
		<c:forEach items="${goodsList}" var="g">
			<tr>
			<td>${g.gid }</td>
			<td>${g.gname }</td>
			<td>${g.price }</td>
			<td>${g.saleBfb }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5">
			<a href="listZset?cpage=1">首页</a>
			<a href="listZset?cpage=${cpage-1 }">上一页</a>
			<a href="listZset?cpage=${cpage+1 }">下一页</a>
			<a href="listZset?cpage=${cpages }">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>