<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<div>
			<p>
				<%
					int i = 0;
					int j = 0;
					for (i = 1; i <= 9; i++){
						for(j = 1; j <= i; j++){
							
				%>
				
							<%=j%>*<%=i%>=<%=i*j%>
				<%
						}
						out.println("<br>");
					}
				%>
			</p>
		</div>
	</body>
</html>
