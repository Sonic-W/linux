package com.ysu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysu.dao.StudentDao;
import com.ysu.entity.Student;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;

/**
 * Servlet implementation class DoubleSelect
 */
@WebServlet("/DoubleSelect")
public class DoubleSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoubleSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		String stuno=request.getParameter("stuno");
		String stuname=request.getParameter("stuname");
		String stusex=request.getParameter("stusex");
		String stumajor=request.getParameter("stumajor");
		
		Page<Student> page = new Page<Student>(1,100);
		page.getSearchProporties().add(new SearchProperty("stuno",stuno,Operator.EQ));
		page.getSearchProporties().add(new SearchProperty("stuname",stuname,Operator.EQ));
		page.getSearchProporties().add(new SearchProperty("stusex",stusex,Operator.EQ));
		page.getSearchProporties().add(new SearchProperty("stumajor",stumajor,Operator.EQ));
		List<Student> content =studentDao.findList(page).getContent();
		
		request.setAttribute("students",content);
		request.getRequestDispatcher("doubleShow.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
