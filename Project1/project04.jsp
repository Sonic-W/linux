<%@ page pageEncoding="UTF-8"%>
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
				<%
					for(int i = 0; i < 10; i++){ //行
				  %>     	
						<tr>
				<%
						for(int j = 0; j < 10; j++){ //列
				%>
							<td>
								<%=(i+j)%2%>
							</td>
				<%			
							
						}
				%>
						</tr>
				<%
					}
				%>
				
			</table>
		</center>
	</body>
</html>
