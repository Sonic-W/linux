<%@page import="bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here22</title>
</head>
<body>
<% //StudentDao rd=new StudentDao();
  //ArrayList<Student> list= rd.getallstudent();
  ArrayList<Student> list = new StudentDao().getallstudent();
%>

<center><table border="1">
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

<form action="Servlet" method="post">
<%//action:<p><select size="1" name="action" >%>
action:<select size="1" name="action">
<option selectes value="nul"></option>
<option selectes value="sx">刷新</option>
<option selectes value="fh">返回</option>
<option selectes value="ins">增加</option>
<option selectes value="del">删除</option>
<option selectes value="cha">修改</option>
<option selectes value="fin">查找</option>
</select></p>
输入action id:
<input type="text" name="str" size="12"><br>
<input type="submit" name="submit" value="提交">
<input type="reset" name="reset" value="重置"><br>
</form>


</center>

</body>
</html>
