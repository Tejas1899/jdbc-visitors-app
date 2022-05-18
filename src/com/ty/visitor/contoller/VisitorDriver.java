package com.ty.visitor.contoller;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;

public class VisitorDriver {
public static void main(String[] args) {
//	Visitor visitor=new Visitor();
//	visitor.setId(4);
//	visitor.setName("priya");
//	visitor.setEmail("priya@gmail.com");
//	visitor.setPhone("6499441654");
//	visitor.setAge(18);
//	visitor.setGender("female");
//	visitor.setDob("1/1/2003");
//	visitor.setVisitdatetime("14/15/2022 5:15PM");
//	VisitorDao dao=new VisitorDao();
//	dao.saveVisitor(visitor);
//	if(visitor!=null)
//	{
//		System.out.println("Data inserted");
//	}
//	else
//	{
//		System.out.println("Data not inserted");
//	}
	VisitorDao dao=new VisitorDao();
	//dao.getVisitorById(1);
	
	//dao.getVisitorByDate("22/07/1999");
	dao.getVisitorByAgeRange(20,40);
}
}
