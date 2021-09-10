package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class cartDao {
	public void push(String uname,String bill,String rname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/foodexpress","root","1234");
			PreparedStatement sql;
				sql = con.prepareStatement("insert into orders(uname,restname,bill) values(?,?,?)");
				sql.setString(1, uname);
				sql.setString(2, rname);
				sql.setString(3, bill);
				sql.execute();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
