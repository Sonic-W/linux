<%@ page language="java" pageEncoding="utf-8" import="java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<%
ArrayList<String> arrayList = (ArrayList<String>)session.getAttribute("arrayList");
	String[] book = request.getParameterValues("book");
	if(book != null){
		for(String b:book){	
			arrayList.add(b);
		}
		for(int i = 0;i<arrayList.size();i++){	
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>");
			out.println(arrayList.get(i));
			out.println("</td>");
			out.println("<td>");
%>
<button onclick="del(<%= i%>)">delet</button>
<%
			out.println("</td>");
			out.println("</tr>");
		}
	}
%>


<script>
	function del(a){
		window.location.href = "pro2.jsp?del="+a;
	}
</script>




