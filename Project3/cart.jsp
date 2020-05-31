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
		<p>>>>我的购物车</p><br>
		<%
			ArrayList<String> books =(ArrayList<String>)session.getAttribute("books");
			for(int i = 0; i < books.size(); i++){
				if(books.get(i) != null){
					String ss = books.get(i);
					%>
					<form action="del.jsp">
						<input type="text" name="book" value="<%= ss%>" size="40" maxlength="200" readonly />
						<input type="submit" value="删除" />
					</form>
					<%
				}
			}
		%>
	</body>
</html>
