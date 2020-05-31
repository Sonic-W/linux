<%@ page language="java" pageEncoding="utf-8" import="java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	String delbook = request.getParameter("book");
	ArrayList<String>books = (ArrayList<String>)session.getAttribute("books");
	if(delbook != null){
		for(int j= 0;j < books.size(); j++){
			String book = books.get(j);
			if(book == null){
				books.remove(j);
			}
			if(book != null && book.indexOf(delbook) != -1){
				books.remove(j);
				%>
				<script type="text/javascript">
					alert("删除成功");
				</script>
				<%
				break;
			}
		}
		response.sendRedirect("cart.jsp");
	}
%>
