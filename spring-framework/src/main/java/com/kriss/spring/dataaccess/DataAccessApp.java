package com.kriss.spring.dataaccess;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataAccessApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		//JdbcDaoImplDerby dao = (JdbcDaoImplDerby) context.getBean("jdbcDaoImplDerby");
		//dao.executeStatement();
		JdbcDaoTemplateImpl dao = (JdbcDaoTemplateImpl) context.getBean("jdbcDaoTemplateImpl");
		//dao.getCount("Select count(*) from Circle");
		/*Circle circle = dao.getCircle("Select * from Circle where id = ?");
		System.out.println(circle.getId());
		System.out.println(circle.getName());*/
		//System.out.println(dao.getAllCircles("Select * from Circle"));
		dao.insertCircle(new Circle(3, "Third Circle"));
	}
}
