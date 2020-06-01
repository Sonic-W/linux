package com.ysu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysu.dao.StudentDao;
import com.ysu.entity.Student;
import com.ysu.page.Page;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		String id=request.getParameter("id");
		
		int ids = Integer.parseInt( id );
		if(studentDao.delete(ids)) {
			Page<Student> page = new Page<Student>(1,100);
			List<Student> content =studentDao.findList(page).getContent();
			System.out.println(content.size());
			request.setAttribute("students",content);
			request.getRequestDispatcher("query.jsp").forward(request,response);
		}
		else{
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
