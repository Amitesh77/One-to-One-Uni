package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String user="root";
		String password="Captain@007";
		
		String jdbcurl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false";
		
		
		try {
			System.out.println("Connectiong to Database  "+jdbcurl);
			
			Connection myConn=DriverManager.getConnection(jdbcurl,user,password);
			
			
			System.out.println("Connection  Successfull!!!!");

			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
