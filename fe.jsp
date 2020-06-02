<%@page import="bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.StudentDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
//获取信息
   Student stu=(Student)session.getAttribute("user");
   String act=(String)session.getAttribute("act");

%>
<body>
<center>
<form action="Servlett" method="post">
ID：<input type="text" name="id" value="<%=stu.getId()%>"><br/>
用户名：<input type="text" name="userName" value="<%=stu.getUserName()%>"><br/>
性别：<input type="text" name="xb" value="<%=stu.getXb()%>"><br/>
密码：<input type="text" name="mima" value="<%=stu.getMima()%>"><br/>
 action:<p><select size="1" name="action" >
 <% if(act.equals("fin")){%>
           <option selectes value="fh">返回</option>
 <%   }
if(act.equals("ins")){
  %>
           <option selectes value="sc">上传</option>
  <%   }
if(act.equals("cha")){
   
  %>
 
     <option selectes value= "xg" >修改</option>
      <input type="text" name="idd" value="<%=stu.getId()%>" size="1"><br/>
  <% } %>
     </select></p>

<button type="submit">确定</button>

</form>
</center>
</body>
</html>
<%
//修改页面
%>