<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%
	String color = request.getParameter("color");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
%>
<table border="1" width="50%">
	<tr bgcolor="<%=color %>">
		<td><%=title %></td>
	</tr>
	<tr>
		<td><%=content %></td>
	</tr>
	<tr>
		<td>这是box</td>
	</tr>
</table>
