<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${user.id}</td><td>${user.uname}</td><td>${user.password}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>