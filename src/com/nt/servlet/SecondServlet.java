package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null,fname=null,age=null,ms=null;
		String f2val1=null;
		String f2val2=null;
		
//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		
//read form1/request1 data
		name=req.getParameter("hname");
		fname=req.getParameter("hfname");
		age=req.getParameter("hage");
		ms=req.getParameter("hms");
		
//read form2/request2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		
//write  form1/req1 & form2/req2 values to DB tables as record
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");		
		PreparedStatement ps=con.prepareStatement("INSERT INTO PERSON_TAB VALUES(?,?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,fname);
		ps.setString(3,age);
		ps.setString(4,ms);
		ps.setString(5,f2val1);
		ps.setString(6,f2val2);
		
		int result=ps.executeUpdate();
		
		if(result==1)
			pw.println("<br>Record Inserted<br>");
		else
			pw.println("<br>Record not Inserted");
		
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
//display form1/req1 & form2/request2 data on browser
		pw.println("<br>Form1 data is:"+name+"...."+fname+"...."+age+"..."+ms);
		pw.println("<br>Form2 data is:"+f2val1+"...."+f2val2);
		
		pw.close();
	}//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	

}//class
