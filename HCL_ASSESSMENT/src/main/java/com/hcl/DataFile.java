package com.hcl;

import com.hcl.GetConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginformhcl")
public class DataFile extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse res) throws IOException{
		String first_name = req.getParameter("firstname");
		String last_name =req.getParameter("lastname");
		long p_number=Long.parseLong(req.getParameter("mobnum"));
		String email=req.getParameter("email");
		String language =req.getParameter("language");
		PrintWriter out=res.getWriter();
		try {
			Connection cn=GetConnection.Databaseconection();
			PreparedStatement ps=cn.prepareStatement("insert into User_Info values(?,?,?,?,?)");
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setLong(3, p_number);
			ps.setString(4, email);
			ps.setString(5, language);
		
			int count =ps.executeUpdate();
			System.out.println("Number of rows afftected: "+count);
			cn.close();
			ps.close();
		}
		catch(SQLIntegrityConstraintViolationException s) {
			out.println("User Already Exists");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		out.println("Form Successfully Created\n");
		out.println("User First Name: "+first_name);
		out.println("User Last Name: "+last_name);
		out.println("User phone number : "+p_number);
		out.println("User E-mail: "+email);
		out.println("Language : "+language);
		
		
		
		
		
		
	}}
