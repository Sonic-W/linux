package com.ysu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ysu.dao.StudentDao;
import com.ysu.entity.Student;
import com.ysu.page.Operator;
import com.ysu.page.Page;
import com.ysu.page.SearchProperty;
@WebServlet("/register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Part file =null;
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op=request.getParameter("op");
		if("reg".equals(op))
			register(request,response);
		else if("que".equals(op)) 
			query(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}
	
	public void register(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		String stupic=upload(request);//照片上传至pic目录
		String stuno=request.getParameter("stuno");
		String stuname=request.getParameter("stuname");
		String stusex=request.getParameter("stusex");
		String stumajor=request.getParameter("stumajor");
		student.setStuname(stuname);
		student.setStuno(stuno);
		student.setStusex(stusex);
		student.setStumajor(stumajor);
		student.setStupic(stupic);
		if(studentDao.add(student)) {
			//ArrayList<Student> list=null;
			Page<Student> page = new Page<Student>(1,100);
			List<Student> content =studentDao.findList(page).getContent();
			System.out.println(content.size());
			//list=studentDao.findList(page).getContent();
			request.setAttribute("students",content);
			request.getRequestDispatcher("query.jsp").forward(request,response);
		}
		else{
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
	}
	
	
	public void query(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		StudentDao sdao=new StudentDao();
		Student user = new Student();
		Page<Student> page = new Page<Student>(1,10);
		List<Student> content = sdao.findList(page).getContent();
		
		System.out.println(content.size());
	}
	public String upload(HttpServletRequest request){
		String newfilename="";
		try{
			file = request.getPart("stupic");
			String header = file.getHeader("content-disposition");
			String filename =((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
			String extname = filename.substring(filename.lastIndexOf('.')+1);
			int i=(int)((Math.random()*9+1)*100000);
			newfilename = System.currentTimeMillis()+"-"+i+"."+extname;
			String uploadpath = getServletContext().getRealPath("/pic");
			file.write(uploadpath+File.separator+newfilename);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "pic/"+newfilename;
	}
}
