package com.ysu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ysu.dao.UserDao;
import com.ysu.entity.User;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		UserDao userDao = new UserDao();
		user = (User)request.getAttribute("user");
		Page<User> page = new Page<User>(1,10);
		page.getSearchProporties().add(new SearchProperty("username",user.getUsername(),Operator.EQ));
		page.getSearchProporties().add(new SearchProperty("password",user.getPassword(),Operator.EQ));
		List<User> content = userDao.findList(page).getContent();
		
		if(content.size() == 1){
			request.getSession().setAttribute("user", user.getUsername());
			
			request.getRequestDispatcher("/main.jsp").forward(request,response);
		}
		else{
			request.getRequestDispatcher("/login.html").forward(request,response);
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
