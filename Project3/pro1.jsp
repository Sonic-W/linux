<%@ page language="java" pageEncoding="utf-8" import="java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<%
			ArrayList<String> arrayList;
			if(session.isNew()){
				arrayList = new ArrayList<String>();
				session.setAttribute("arrayList",arrayList);
			}
		%>
		<form action="new_file.jsp">
			<table border="1">
			<tr><td><input type="checkbox" name="book" value="Java Web程序设计" />Java Web程序设计</td></tr>
			<tr><td><input type="checkbox" name="book" value="Android Studio实战" />Android Studio实战</td></tr>
			<tr><td><input type="checkbox" name="book" value="J2EE 开发技术" />J2EE 开发技术</td></tr>
			<tr><td><input type="submit" value="查看购物车" /></td></tr>
			</table>
		</form>
		
	</body>
</html>
