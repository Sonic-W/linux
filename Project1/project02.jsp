<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			td{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<center>
			<table border="1" width="35%">
				<tr>
					<th>i</th>
					<th>i的平方</th>
				</tr>
				<%
					for(int i = 0; i <=5; i++){ //行
				  %>
						<tr>
				
							<td>
								<%=i%>
							</td>
							<td>
								<%=i%>*<%=i%>=<%=i*i%>
							</td>
				
						</tr>
				<%
					}
				%>
				
			</table>
		</center>
	</body>
</html>
