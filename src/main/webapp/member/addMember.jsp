<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width=600 align="center" border=1>
		<tr height=150>
			<td align="center"><jsp:include page="../title.jsp" />
		<tr height=400>
			<td>
				<form action="../addMemberController" method="post">
					<table width="300" align="center">
						<tr>
							<td colspan=2 align="center">會員基本資料
						<tr>
							<td width=50 align="center">帳號
							<td width=250><input type="text" name="username">
						<tr>
							<td align="center" >密碼
							<td><input type="password" name="password">
						<tr>
							<td align="center" >姓名
							<td><input type="text" name="name">
						<tr>
							<td align="center" >地址
							<td><input type="text" name="address">
						<tr>
							<td align="center" >電話
							<td><input type="text" name="phone">
						<tr>
							<td align="center" >行動
							<td><input type="text" name="mobile">																					
						<tr>
							<td colspan=2 align=center>
							<input type="submit" value="確定">							
							
					</table>
				</form>
		<tr height=50>
			<td align="center"><jsp:include page="../end.jsp" />
	
	</table>

</body>
</html>