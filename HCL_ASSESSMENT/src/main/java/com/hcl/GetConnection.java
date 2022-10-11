package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static Connection Databaseconection()
	        throws Exception
	    {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HCL_Percipio","root","Sumanth$23");
		return cn;
	    }

}
