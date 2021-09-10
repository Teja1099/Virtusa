package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class loginDao {
	
	public boolean check(String name,String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/foodexpress","root","1234");
			PreparedStatement st=  con.prepareStatement("select name from customer where username=? and password=?");
			st.setString(1, name);
			st.setString(2, pass);
			ResultSet rs= st.executeQuery();
			if(rs.next())  {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
