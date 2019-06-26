package com.imooc.utils;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

//保存操作（没有加防注入漏洞）
public class JDBCDemoTest {
	@Test
	//保存记录
	public void demo1() {
		Connection conn = null;
		Statement stmt = null;
		
		
		
		try {
			//获得连接
			conn = JDBCUtils.getConnetion();
			//创建执行sql语句
			stmt = conn.createStatement();
			//编写sql
			String sql = "insert into user values(null,'lipanchen','123','小五')";
			//执行sql
			int num = stmt.executeUpdate(sql);
			if(num>0) {
				System.out.println("保存成功！");
			}else {
				System.out.println("保存失败！");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	

}
