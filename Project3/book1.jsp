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
		<form action="">
			<table border="1">
			<tr><td><input type="checkbox" name="book" value="Java Web程序设计" />Java Web程序设计</td></tr>
			<tr><td><input type="checkbox" name="book" value="Android Studio实战" />Android Studio实战</td></tr>
			<tr><td><input type="checkbox" name="book" value="J2EE 开发技术" />J2EE 开发技术</td></tr>
			<tr><td><input type="submit" value="加入购物车" /></td></tr>
			</table>
		</form>
		<%
			request.setCharacterEncoding("utf-8");
			String[] book = request.getParameterValues("book");
			ArrayList<String> books = (ArrayList<String>)session.getAttribute("books");
			if(books == null){
				books = new ArrayList<String>();
				session.setAttribute("books",books);
				
			}
			if(book != null){
				for(int i = 0;i < book.length; i++){
					books.add(book[i]);
				}
				out.println("<script type = 'text/javascript'>alert('加入购物车成功');</script>");
			}
		%>
		<br>
		<input type="button" value="查看我的购物车" onclick="location.href='cart.jsp'" /><br>
	</body>
</html>
