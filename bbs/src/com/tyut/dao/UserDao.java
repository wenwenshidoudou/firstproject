package com.tyut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tyut.servlet.Users;
import com.tyut.util.JDBCUtil;



//��ɾ�Ĳ�
public class UserDao {
	Connection conn=null;
	PreparedStatement psmt =null;
	ResultSet rs=null;
	public boolean login(String un,String pw){
		
		boolean f=false;
		//1.�������ݿ�
		conn =JDBCUtil.getConn();
	
		// 2 ����sql���
		String sql="select * from user1 where username=? And password=?";
		
			
		try{
		//3,Ԥ����	
		 psmt =conn.prepareStatement(sql);
		//4,���ò���
			psmt.setString (1,un);
			psmt.setString (2,pw);
			//5ִ��sql���
			rs=psmt.executeQuery();
			//6��ȡ���
			f=rs.next();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			//�ر�����
			JDBCUtil.close(conn, psmt, rs);
		}
		
		return f;
		
	}
	public List<Users> getUserList() {
		List<Users> userList =new ArrayList<Users>();
		// TODO Auto-generated method stub
		//1.�������ݿ�
		conn =JDBCUtil.getConn();
	
		// 2 ����sql���
		String sql="select * from user1" ;
		List<Users> userList1 = new ArrayList<Users>();
			
		try{
		//3,Ԥ����	
		 psmt =conn.prepareStatement(sql);
		
			//5ִ��sql���
			rs=psmt.executeQuery();
			//System.out.println("id");
			//6��ȡ���
			//List<Users> userList1 = new ArrayList<Users>();
			
			while(rs.next()){
				Users user =new Users();
        	user.setId(rs.getInt("id"));
        	user.setUsername(rs.getString("username"));
        	user.setPassword(rs.getString("password"));
        	user.setStatus(rs.getInt("status"));
        	userList1.add(user);
        
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			//�ر�����
			JDBCUtil.close(conn, psmt,rs);
		}
		return  userList1;
	
	}
public boolean deleteUserById(String id){
		int i=-1;
		//boolean f=false;
		//1.�������ݿ�
		conn =JDBCUtil.getConn();
	
		// 2 ����sql���
		String sql="delete from user1 where id=?";
		
			
		try{
		//3,Ԥ����	
		 psmt =conn.prepareStatement(sql);
		//4,���ò���
			psmt.setInt(1,Integer.parseInt(id));
			
			//5ִ��sql���
		 i=psmt.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			//�ر�����
			JDBCUtil.close(conn, psmt, rs);
		}
		
		return (i>0);
		
	}
	
}
