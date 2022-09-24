package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {

	public String insertCart(int id, String email, String username, String password, String address) {
		Connection connection = null;

		try {
			// 1
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2.Establish the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
			// 3.prepare statement
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cart VALUES(?,?,?,?,?)");

			ps.setInt(1, id);
			ps.setString(2, email);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, address);
			ps.executeUpdate();
			System.out.println("saved");
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "saved";

	}

	public String updateCart(int id) {

		try {
			// 1.Load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
			// 3.prepare statement
			PreparedStatement ps = connection
					.prepareStatement("UPDATE cart set id=? where email=rriyazahmed@gmail.com");

			ps.setInt(1, id);
			ps.executeUpdate();

			// 5.Close the connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "updated";
	}
	public String deleteCart(int id) {

	try {
		//1.Load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.Establish the connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		PreparedStatement ps=connection.prepareStatement("Delete from cart where id=?");
		ps.setInt(1, id);
		ps.execute();
		//5.Close the connection
		connection.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "deleted";

}
}
