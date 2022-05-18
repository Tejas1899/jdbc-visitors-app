package com.ty.visitor.contoller;

import com.ty.visitor.dao.Userdao;
import com.ty.visitor.dto.User;

public class UserDriver {
public static void main(String[] args) {
//	User user=new User();
//	user.setId(2);
//	user.setName("Raj");
//	user.setEmail("raj@mail.com");
//	user.setPhone(89768746l);
//	user.setPassword("raj@123");
//	user.setRole("regular");
//	Userdao userdao=new Userdao();
//	userdao.saveUser(user);
//	if(user!=null)
//	{
//		System.out.println("Query Executed");
//	}
//	else
//	{
//		System.out.println("Query not executed");
//	}
//	User user=new User();
//	user.setId(2);
//	user.setPhone(35468766l);
//	
//	Userdao userdao=new Userdao();
//	userdao.updateUser(user);
//	if(user!=null)
//	{
//		System.out.println("Data updated");
//	}
//	else
//	{
//		System.out.println("Data not updated");
//	}
	
	User user=new User();
	Userdao userdao=new Userdao();
	userdao.validateUser("tej@mail.com","tej@123");
	
}
}
