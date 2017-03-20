<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<br />
		<center>
			<form name="loginform" action="j_spring_security_check" method="POST" >
				<table align="center" width="600" height="468"
					style="background-image: url();">
					<tr>
						<td height="100">
						</td>
						<td height="100">
						</td>
					</tr>
					<tr>
						<td width="220"></td>
						<td>
							<font size="2"> <span style="color: black"> 用户名</span> <input id="username"
									type='text' name="j_username" value="" style="width: 100px"> <span
								style="color: black">密码</span> <input id="pwd" type='password'
									name='j_password' value="" style="width: 100px"> <input
									name="submit" type="submit" value="登录" class="btn"> </font>
						</td>
					</tr>
				</table>

			</form>
		</center>
</body>
</html>