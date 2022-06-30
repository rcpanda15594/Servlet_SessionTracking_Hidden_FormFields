package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,page=null,pms=null;
		
		
//general setting
		pw=res.getWriter();
		res.setContentType("text/html");
		
//read form1 data
		pname=req.getParameter("tname");
		fname=req.getParameter("fname");
		page=req.getParameter("tage");
		pms=req.getParameter("ms");
		
//design & send dynamic form page to browser based on marital status
		
		if(pms.equals("single")) {
			pw.println("<form action='secondurl' method='post'>");
			pw.println("When do U want to merry:<input type='text' name='f2t1'><br>");
			pw.println("Why do U want to merry:<input type='text' name='f2t2'><br>");
			
	//add form1/req1 data to dynamic form page as hidden box values
			
			pw.println("<input type='hidden' name='hname' value="+pname+"><br>");
			pw.println("<input type='hidden' name='hfname' value="+fname+"><br>");
			pw.println("<input type='hidden' name='hage' value="+page+"><br>");
			pw.println("<input type='hidden' name='hms' value="+pms+"><br>");
			
			pw.println("<input type='submit' value='submit'><br>");
			pw.println("</form>");	
			
		}//if
		else {
			pw.println("<form action='secondurl' method='post'>");
			pw.println("Spouse Name:<input type='text' name='f2t1'><br>");
			pw.println("No of Kids:<input type='text' name='f2t2'><br>");
			
	//add form1/req1 data to dynamic form page as hidden box values
			
			pw.println("<input type='hidden' name='hname' value="+pname+"><br>");
			pw.println("<input type='hidden' name='hfname' value="+fname+"><br>");
			pw.println("<input type='hidden' name='hage' value="+page+"><br>");
			pw.println("<input type='hidden' name='hms' value="+pms+"><br>");
			
			pw.println("<input type='submit' value='submit'><br>");
			pw.println("</form>");	
			
		}//else
		
		//close stream
		pw.close();
	}//doget
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}//class
