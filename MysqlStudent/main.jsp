<%@ page pageEncoding="utf-8" %>

<h2 align="center">欢迎使用学生管理系统<br/>
<%
	String user=(String)session.getAttribute("user");
	if(user==null) user="";
	out.println("welcome:"+user);

%>
</br>
<a href="select">查看学生信息</a>
<br>
<a href="addform.jsp">添加学生信息</a>
<br>

</h2>
