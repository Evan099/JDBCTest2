package com.imooc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//工具栏抽取
public class JDBCUtils {
	public static final String url = "jdbc:mysql://localhost:3306/jdbcTest";
	public static final String user = "root";
	public static final String password = "111111";


	
	//注册驱动方法
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	
	//连接数据库方法
	public static Connection getConnetion() throws Exception{
		loadDriver();
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	
	//释放
	public static void release(Statement stmt,Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	//释放(结果集)
	public static void release(ResultSet rs,Statement stmt,Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
	
	
	
	

}
