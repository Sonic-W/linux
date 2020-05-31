<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<%
			for(int i=1; i < 10; i++){
				for(int j = 1; j <= i; j++){
					int w = i * j;
					out.println(j + "*" + i + "=" + w);
				}
				out.println("<br>");
			}
		%>
	</body>
</html>
