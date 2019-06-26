package com.imooc.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.imooc.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//连接池的测试类
public class DataSourceDemo1 {
	
	@Test
	//手动设置连接池
	public void demo1() {

		//获得连接
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//创建连接池
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//设置连接池的参数
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcTest");
			dataSource.setUser("root");
			dataSource.setPassword("111111");
			dataSource.setMaxPoolSize(20);
			dataSource.setInitialPoolSize(3);
		
		
			
			//连接
			conn = dataSource.getConnection();
			//编写sql
			String sql = "select * from user";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数
			//执行sql
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("uid")+" "+rs.getString("username")+" "+rs.getString("password"));
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		
		
		
		
		
		
	}
	
	
	
	
	

}
