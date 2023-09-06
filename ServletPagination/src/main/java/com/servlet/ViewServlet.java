package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.bean.Emp;
import com.servlet.dao.EmpDao;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("hello ViewServlet");
		String spageid = req.getParameter("page");
		int pageid = Integer.parseInt(spageid);
		int total = 5;
		if (pageid == 1) {}
		else {
			pageid=pageid-1;
		 pageid=pageid*total+1;
	
	}
		  List<Emp> list=EmpDao.getRecords(pageid,total);  
		  
	        out.print("<h1>Page No: "+spageid+"</h1>");  
	        out.print("<table border='1' cellpadding='4' width='60%'>");  
	        out.print("<tr><th>Id</th><th>Name</th><th>City</th>");  
	        for(Emp e:list){  
	            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getCity()+"</td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.print("<a href='ViewServlet?page=1'>1</a> ");  
	        out.print("<a href='ViewServlet?page=2'>2</a> ");  
	        out.print("<a href='ViewServlet?page=3'>3</a> ");  
	          
	        out.close();  
}}
