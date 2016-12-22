package com.tyut.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCUtil {

	//数据库驱动类型
		static{ 
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		} ;
		//数据库地址
		 static String	url="jdbc:oracle:thin:@localhost:1521:orcl" ;	
		//用户
		static String user="scott" ;	
		//密码
	   static String pwd="bsoft";
	
	public static Connection getConn(){
		Connection conn=null;
		try {
		    conn=DriverManager.getConnection(url,user,pwd);
		    System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args){
		
		Connection conn=JDBCUtil.getConn();
    	System.out.println(conn);    	
	}
	public static void close(Connection conn,Statement stmt,ResultSet rs){
			try{
				if(rs!=null){
					rs.close();
				}
				
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
				}catch(SQLException e){
					e.printStackTrace();
			}
	}
}
