package com.teja.dao;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;


public class rating {
	public void rateRest(int rate,String rid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/foodexpress","root","1234");
			PreparedStatement st =  con.prepareStatement("select rating from restr where rname=?");
			st.setString(1,rid);
			ResultSet rs= st.executeQuery();
			if(rs.next()){
			rate=(rate+rs.getInt("rating"))/2;
			System.out.println(rate);
			st =  con.prepareStatement("update restr set rating = ? where rname=?");
			st.setInt(1,rate);
			st.setString(2,rid);
			st.executeUpdate();
			}
		}
	
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
