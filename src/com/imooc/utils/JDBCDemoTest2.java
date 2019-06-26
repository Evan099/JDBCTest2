package com.imooc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

import org.junit.jupiter.api.Test;



//登录操作
public class JDBCDemoTest2 {

	@Test
	//测试漏洞
	public void demotest2() {
		boolean flag = JDBCDemoTest2.login2("lipanchen' or '1=1", "sad");
		if(flag == true) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	//登录操作（有防注入漏洞）
	public static boolean login2(String username,String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		
		try {
			//获得连接
			 conn = JDBCUtils.getConnetion();
			 //编写sql
			 String sql = "select * from user where username = ? and password = ?";
			 
			 
			 //预处理sql
			 pstmt = conn.prepareStatement(sql);//注意，预处理sql，在此处加入sql
			 //设置参数
			 pstmt.setString(1, username);
			 pstmt.setString(2, password);
			 
			 
			 //执行sql
			 rs = pstmt.executeQuery();//注意，预处理之后，括号里就不写sql了
			 //判断结果集
			if(rs.next()) {
				flag = true;
			}else {
				flag = false;
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		 return flag;
		
	}
	
	
	
	
	//登录操作（无防注入漏洞）
	public static boolean login(String username,String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		boolean flag = false;
		
		try {
			conn = JDBCUtils.getConnetion();
			//创建执行sql的语句
			stmt = conn.createStatement();
			//编写sql;
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"' ";
			//执行sql
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				flag = true;
			}else {
				flag = false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		
		
		return flag;
		
		
	
	}
	
	
	
	
	
}
