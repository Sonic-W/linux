<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSP练习使用JSP脚本元素输出九九乘法表</title>
  </head>
  
  <body>
      <h1>九九乘法表</h1>
      <table border="0">
      		<%
      			for(int i = 1; i <=9; i++){ //行
            %>     	
      				<tr>
      		<%
      				for(int j = 1; j <=i; j++){ //列
      		%>
      					<td style="border:2px solid black;padding:2px">
      						<%=j%>✕<%=i%>=<%=i*j%>
      					</td>
      		<%			
      					
      				}
      		%>
      				</tr>
      		<%
      			}
      		%>
      </table>
  </body>
</html>