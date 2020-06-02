<%@page contentType="text/html; charset=utf-8" language="java" import="java.sql.*"%>
<%
	
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		String driverName="com.mysql.jdbc.Driver";//驱动程序名
		String userName="root";//数据库用户名2
		String userPasswd="root";//密码

		String dbName="student2";//数据库名
		String tableName="user";//表名

		String url="jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false";//连接字符串
		Connection conn=null;
  		Statement stmt=null;
  		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(url,userName,userPasswd);
			stmt = conn.createStatement();

			String sql="select * from user where username='"+username+"' and password='"+password+"'";

			rs=stmt.executeQuery(sql);
			String p="";
			if(rs.next()){
				session.setAttribute("user",username);
				p="begin.jsp";
			}
			else{
				p="login.html";
			}
%>
		<jsp:forward page="<%=p%>" />
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}

%>

