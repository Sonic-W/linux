<%@page import="bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //StudentDao rd=new StudentDao();
  //ArrayList<Student> list= rd.getallstudent();
  ArrayList<Student> list = new StudentDao().getallstudent();
%>

<table border="1">
<tr>
<th>Id</th>
<th>名字</th>
<th>性别</th>
<th>密码</th>
</tr>
<%
for(int i=0;i<list.size();i++)
{
    %>
    <tr>
    <td><%=list.get(i).getId()%></td>
    <td><%=list.get(i).getUserName()%></td>
    <td><%=list.get(i).getXb()%></td>
    <td><%=list.get(i).getMima()%></td>
    </tr>
<% 
  }
%>

</table>
</body>
</html>