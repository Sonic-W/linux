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
import com.ysu.page.Page;


/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
@MultipartConfig
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Part file =null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		String id = request.getParameter("id");
		int ids = Integer.parseInt( id );
		String stupic=upload(request);//照片上传至pic目录
		String stuno=request.getParameter("stuno");
		String stuname=request.getParameter("stuname");
		String stusex=request.getParameter("stusex");
		String stumajor=request.getParameter("stumajor");
		student.setId(ids);
		student.setStuname(stuname);
		student.setStuno(stuno);
		student.setStusex(stusex);
		student.setStumajor(stumajor);
		student.setStupic(stupic);
		//System.out.println(studentDao.update(student));
		if(studentDao.update(student)) {
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

	public String upload(HttpServletRequest request){
		String newfilename="";
		try{
			file = request.getPart("stupic");
			String header = file.getHeader("content-disposition");
			String filename =((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
			String extname = filename.substring(filename.lastIndexOf('.')+1);
			int i=(int)((Math.random()*9+1)*100000);
			newfilename = System.currentTimeMillis()+"-"+i+"."+extname;//此方法较为安全
			String uploadpath = getServletContext().getRealPath("/pic");
			file.write(uploadpath+File.separator+newfilename);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "pic/"+newfilename;
	}
	
	public void delpic(String f){
		String path=getServletContext().getRealPath("/pic");
		String file=f.substring(f.lastIndexOf('/')+1);
		File ff=new File(path+File.separator+file);
		if(ff.exists()) ff.delete();
}
}
