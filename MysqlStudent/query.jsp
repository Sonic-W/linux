<%@ page contentType="text/html;charset=utf-8" %> 
<%@ page language="java" import="java.util.List,com.ysu.entity.Student" %>
<html>
<head>
<style type="text/css"> 
	#tb{width:666px;border-collapse:collapse;border:1px solid #EEE;font-size:14px;} 
	#tb th{background:#EEE;border-bottom:1px solid #CCC;padding:4px;} 
	#tb td{border:1px solid #EEE;padding:4px;} 
</style> 
<script type="text/javascript"> 
	function initTab(){
		var obj=document.getElementById("tb"); 
		for(var i=0;i<obj.rows.length;i++){
			obj.rows[i].onmouseover=function(){this.style.background="pink";} 
			obj.rows[i].onmouseout=function(){this.style.background="";} 
		} 
	}
</script> 
</head> 
<body onload="initTab();"> 
<table id="tb" align="center"> 
	<tr> 
		<th>ID</th> <th>学号</th><th>姓名</th> <th>性别</th><th>专业</th><th>照片</th> <th>操作</th>
	</tr> 
	
<% 
	List<Student> list=(List<Student>)request.getAttribute("students");
	for(int i=0;i<list.size();i++){
		Student s=list.get(i);
		int id=s.getId();
		String sname=s.getStuname();
		String sno=s.getStuno();
		String ssex=s.getStusex();
		String smajor=s.getStumajor();
		String spic=s.getStupic();
%> 

	<tr> 
		<td><%=id%></td>
		<td><%=sno%></td>
		<td><%=sname%></td>
		<td><%=ssex%></td>
		<td><%=smajor%></td> 
		<td><img width="120" height="90" src="<%=spic%>"></td> 
		<td>
			<a href="query?id=<%=id%>">编辑</a>&nbsp;
			<a href="delete?id=<%=id%>" onclick="javascript:return confirm('确定删除此记录？');">删除</a>
		</td>
	</tr> 

<%
	}
%>

</table> 
</body>
</html>