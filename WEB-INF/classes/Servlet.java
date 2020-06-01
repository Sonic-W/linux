package com.ysu.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("sx")){
		RequestDispatcher rd = request.getRequestDispatcher("begin.jsp");
		rd.forward(request,response);
		}
	    else if(action.equals("fh")){
	    RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request,response);
	    }
	    else{
	    PrintWriter out=response.getWriter();
		out.println("Eorro:no action");
	    }
	}

}
