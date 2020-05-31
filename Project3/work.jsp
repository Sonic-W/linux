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
			int count = 1;
			int allcount = 0;
		%>
		<form action="">
			<table border="1">
				<tr>
					<td>
						<input type='checkbox' name="book" value="120">
					</td>
					<td>
						Java Web技术
					</td>
					<td>
						120
					</td>
					<td>
						<button>-</button>
						<%= count%>
						<button>+</button>
					</td>
					<td>
						<button>删除</button>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type='checkbox' name="book" value="150">
					</td>
					<td>
						Android技术
					</td>
					<td>
						150
					</td>
					<td>
						<button>-</button>
						<%= count%>
						<button>+</button>
					</td>
					<td>
						<button>删除</button>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type='checkbox'>
					</td>
					<td>
						全选
					</td>
					<td>
						总价:
					</td>
					<td>
						<%= allcount%>
					</td>
					<td>
						<button>结算</button>
					</td>
				</tr>
			</table>
		</form>
		<%
			String[] book = request.getParameterValues("book");
			ArrayList<String> b = (ArrayList<String>)session.getAttribute("b");
			if(b == null){
				b = new ArrayList<String>();
				session.setAttribute("b",b);
				
			}
			if(book != null){
				for(int i = 0;i < book.length; i++){
					b.add(book[i]);
				}
				for(int j = 0;j< b.size();j++){
					out.println(b.get(j));
				}
			}
		%>
	</body>
</html>
