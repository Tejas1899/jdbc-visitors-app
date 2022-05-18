package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.visitor.dto.Visitor;
import com.ty.visitor.util.AESalgorithm;
import static com.ty.visitor.util.AppConstants.*;
import com.ty.visitor.util.ConnectionObject;

public class VisitorDao {

	public int saveVisitor(Visitor visitor)
	{
		Connection connection=ConnectionObject.getConnection();
		String name_enc=AESalgorithm.encrypt(visitor.getName(),SECRET_KEY);
		String email_enc=AESalgorithm.encrypt(visitor.getEmail(),SECRET_KEY);
		String phone_enc=AESalgorithm.encrypt(visitor.getPhone(),SECRET_KEY);
		//Long phone_enc=AESalgorithm.encrypt(visitor.getPhone(),SECRET_KEY);
		String query="Insert into visitor values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,visitor.getId());
			preparedStatement.setString(2,name_enc);
			preparedStatement.setString(3,email_enc);
			preparedStatement.setString(4,phone_enc);
			preparedStatement.setInt(5,visitor.getAge());
			preparedStatement.setString(6,visitor.getGender());
			preparedStatement.setString(7,visitor.getDob());
			preparedStatement.setString(8,visitor.getVisitdatetime());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Visitor getVisitorById(int id)
	{
		Connection connection = ConnectionObject.getConnection();
		String query = "Select * from visitor where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Visitor visitor=new Visitor();
				visitor.setId(resultSet.getInt("id"));
				visitor.setName(resultSet.getString("name"));
				visitor.setEmail(resultSet.getString("email"));
				visitor.setPhone(resultSet.getString("phone"));
				visitor.setAge(resultSet.getInt("age"));
				visitor.setGender(resultSet.getString("gender"));
				visitor.setDob(resultSet.getString("dob"));
				visitor.setVisitdatetime(resultSet.getString("visitdatetime"));
			} else {
				System.out.println("No details available for this id :" + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void getVisitorByDate(String date)
	{
		Connection connection = ConnectionObject.getConnection();
		String query = "Select * from visitor where dob=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, date);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("age"));
				System.out.println(resultSet.getString("gender"));
				System.out.println(resultSet.getString("dob"));
				System.out.println(resultSet.getString("visitdatetime"));
			} else {
				System.out.println("No details available for this date :" + date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void getVisitorByAgeRange(int age,int age1)
	{
		Connection connection = ConnectionObject.getConnection();
		String query = "Select * from visitor where age between ? and ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, age);
			preparedStatement.setInt(2, age1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("age"));
				System.out.println(resultSet.getString("gender"));
				System.out.println(resultSet.getString("dob"));
				System.out.println(resultSet.getString("visitdatetime"));
			} 
				//System.out.println("No details available for this age :" + age);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
