package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import bean.Student;
import java.util.ArrayList;
import dao.StudentDao;



@WebServlet("/Servlet")
public class Servlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
	//	String actionn=request.getParameter("actionn");
	    String id;
		if(action.equals("sx")){

		RequestDispatcher rd = request.getRequestDispatcher("begin.jsp");
		rd.forward(request,response);

		}
	    else if(action.equals("fh")){

	    RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request,response);

	    }else{

	       id=request.getParameter("str");

	       if(action.equals("del")){
	       new StudentDao().deletee(id);
	       RequestDispatcher rd = request.getRequestDispatcher("begin.jsp");
		   rd.forward(request,response);

		   }
		   else if((action.equals("fin"))||(action.equals("cha"))){

	       Student stu =new Student();
	       stu=new StudentDao().findo(id);
	       HttpSession session = request.getSession();
	       session.setAttribute("user",stu);
	       session.setAttribute("act",action);

		   RequestDispatcher rd = request.getRequestDispatcher("fe.jsp");
		   rd.forward(request,response);

		   }
		   else if(action.equals("ins")){

	       Student stu =new Student();
	       stu.setId("");
	       stu.setUserName("");
	       stu.setXb("");
	       stu.setMima("");
	       HttpSession session = request.getSession();
	       session.setAttribute("user",stu);
	       session.setAttribute("act",action);
		   RequestDispatcher rd = request.getRequestDispatcher("fe.jsp");
		   rd.forward(request,response);

		}    

	}

	}

}
