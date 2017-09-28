package com.kriss.spring.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImplDerby {
	
	public static final String DEFAULT_SQL = "SELECT * FROM Circle";
	
	@Autowired
	private DataSource dataSource;
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public void connect() {
		try {
			System.out.println("Connecting to database...");
			conn = dataSource.getConnection();
		} catch(SQLException e) { e.printStackTrace(); }
	}
	
	public void executeStatement() {
		executeStatement(DEFAULT_SQL);
	}
	
	public void executeStatement(String sql) {
		connect();
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i=1; i<=metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i));
				System.out.print("\t");
			}
			System.out.println();
			//Extract data from result set
			while(rs.next()){
				//Retrieve by column index
				for (int i=1; i<=metaData.getColumnCount(); i++) {
					System.out.print(rs.getObject(i));
					System.out.print("\t");
				}
				System.out.println();
				
				/*int id  = rs.getInt("person_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");*/
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(stmt!=null) stmt.close(); } catch(SQLException se) {se.printStackTrace();}
			try { if(conn!=null) conn.close(); } catch(SQLException se) {se.printStackTrace();}
		}
	}
	
}