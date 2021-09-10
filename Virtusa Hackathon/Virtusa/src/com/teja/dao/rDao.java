package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class rDao {
	public boolean push(String uid,String uname,String mbno,String pass) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/foodexpress","root","1234");
			PreparedStatement sql;
			try {
				sql = con.prepareStatement("insert into customer values(?,?,?,?)");
				sql.setString(1, uid);
				sql.setString(2, uname);
				sql.setString(3, mbno);
				sql.setString(4, pass);
				sql.execute();
			}catch(Exception e) {
				return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}
