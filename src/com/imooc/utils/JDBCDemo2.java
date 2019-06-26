package com.imooc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

//保存（防注入漏洞）
public class JDBCDemo2 {
	@Test
	//查询一条
	public void demo5() {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			//连接
			conn = JDBCUtils.getConnetion();
			//编写sql
			String sql = "select * from user where uid = ?";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数		
			pstmt.setInt(1, 2);
//			pstmt.setObject(1, 2);//obejct可以是任意类型
			//执行sql
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("uid")+" "+rs.getString("username")+" "+rs.getString("password"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		
		
		
	}
	
	
	
	
	
	
//	@Test
	//查询所有
	public void demo4() {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			//连接
			conn = JDBCUtils.getConnetion();
			//编写sql
			String sql = "select * from user";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数		
			//执行sql
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("uid")+" "+rs.getString("username")+" "+rs.getString("password"));
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs, pstmt, conn);
		}
		
		
		
		
		
		
	}
	
	
	
//	@Test
	//删除
	public void demo3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//获的连接
			conn = JDBCUtils.getConnetion();
			//编写sql
			String sql = "delete from user where uid = ?";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, 11);
			//执行sql
			int num = pstmt.executeUpdate();
			if(num>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
		
		
		
		
	}
	
	
	
	
	
//	@Test
	//修改（防注入漏洞）
	public void demo2() {
		Connection conn= null;
		PreparedStatement pstmt =null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnetion();
			//编写sql
			String sql = "update user set username = ?,password= ? where uid = ?";
			//预编译sql
			pstmt = conn.prepareStatement(sql);
			//设置参数值
			pstmt.setString(1, "lisuai");
			pstmt.setString(2, "123");
			pstmt.setInt(3, 3);
			//执行sql
			int num = pstmt.executeUpdate();
			if(num>0) {
				System.out.println("修改成功！");
			}else {
				System.out.println("修改失败！");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
		
		
		
		
	}
	
	
	
	
	
//	@Test
	//添加（防注入漏洞）
	public void demo1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//获得连接
		conn = JDBCUtils.getConnetion();
		//填写sql
		String sql = "insert into user values(null,?,?,?)";
		//预处理sql
		pstmt = conn.prepareStatement(sql);
		//设置参数的值
		pstmt.setString(1,"zhagnsan");
		pstmt.setString(2,"97988");
		pstmt.setString(3,"zs");
		//执行sql
		int num = pstmt.executeUpdate();
		//判断结果集
		if(num>0) {
			System.out.println("保存成功");
		}else {
			System.out.println("保存失败");
		}

		
		
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtils.release(pstmt, conn);
		}
	}
}
