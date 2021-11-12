<!DOCTYPE HTML>
<%@page import="com.example.demo.model.SalaryMonth"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.User"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<meta charset="UTF-8" />
<title>Thống kê doanh thu</title>
</head>

<body>

	<h2>Doanh thu 12 tháng gần nhất</h2>
			<table>
				<tr>
					<th>TT</th>
					<th>Tháng</th>
					<th>Tổng tiền</th>
				</tr>
				<c:forEach items="${listRevenueMonth}" var="revenuemonth" varStatus="loop">
				<tr>
					<td>
						${loop.index + 1}
					</td>
					<td>
						${revenuemonth.month}
					</td>
					<td>
						${revenuemonth.total_money}
					</td>
					<td>
						<a href="/chitietluong/${salary.id }">Xem chi tiết</a>
					</td>
				</tr>
				</c:forEach>
			</table>
</body>
</html>