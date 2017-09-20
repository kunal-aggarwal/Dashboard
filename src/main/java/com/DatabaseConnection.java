package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {
	
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSourceTest datasource = (DataSourceTest) ctx.getBean("datasource");
		datasource.createModuleField();
		System.out.println("done!!");
	}
	
	
	
	

	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error accessing database");
		}
	}

}
