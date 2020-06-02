package com.ysu.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import bean.Student;
import java.util.ArrayList;
import dao.StudentDao;


@WebServlet("/Servlett")
public class Servlett extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		//HttpSession session=request.getSession();
		//RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		//rd.forward(request,response);
		PrintWriter out=response.getWriter();
		out.println("test servlet");
		  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");

		if(action.equals("fh")){

		RequestDispatcher rd = request.getRequestDispatcher("begin.jsp");
		rd.forward(request,response);

		}
	    else {
	    	String id=request.getParameter("id");
		    String xb=request.getParameter("xb");
		    String userName=request.getParameter("userName");
		    String mima=request.getParameter("mima");

	    	if(action.equals("sc")){

	    	new StudentDao().insert(id,userName,xb,mima);
	        }else {
	        String idd=request.getParameter("idd");
	        new StudentDao().updatee(id,userName,xb,mima,idd);
	    }
	    	RequestDispatcher rd = request.getRequestDispatcher("begin.jsp");
		    rd.forward(request,response);

	   
	}
	}

}
