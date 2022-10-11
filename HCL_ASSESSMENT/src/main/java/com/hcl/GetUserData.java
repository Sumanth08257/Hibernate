package com.hcl;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.GetConnection;
@WebServlet("/userinfo")
public class GetUserData extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String choose = req.getParameter("opt");
		PrintWriter out=res.getWriter();
		
		
		try {
			Connection cn=GetConnection.Databaseconection();
			PreparedStatement ps=cn.prepareStatement("select * from User_Info where Language=?");
			ps.setString(1, choose);
			ResultSet rs=ps.executeQuery();
			out.println("THE USER LIST");
			while(rs.next()) {
				out.println("User First Name:"+rs.getString("F_Name"));
				out.println("User Last Name:"+rs.getString("L_Name"));
				out.println("User Phone Number:"+rs.getLong("P_Number"));
				out.println();
				
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	

}
