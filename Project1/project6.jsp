<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="project01.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		
	</head>
	<body>
		<jsp:include page="box.jsp">
			<jsp:param name="color" value="green"/>
			<jsp:param name="title" value="This is the title"/>
			<jsp:param name="content" value="This is the content"/>
		</jsp:include>
			
		<jsp:include page="project02.jsp"/>
		
		<jsp:forward page="project01.jsp"/>
	</body>
</html>
