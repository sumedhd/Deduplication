package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import com.bean.Bean;
import com.bean.UploadBean;
import com.connection.DBConnection;

public class APDaoImpl implements APDao {
	
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	String sql;
	Connection con;
	InputStream inputstream;

	@Override
	public boolean CheckAdmin(String email, String password) {
		
		sql="select * from tbl_ap where username=? and password=?";
		
		con=DBConnection.getConnection();
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs= ps.executeQuery(); 
			if(rs.next())
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}



	@Override
	public boolean CheckCloudServer(String email, String password) {
		
    sql="select * from tbl_csp where email=? and password=?";
		
		con=DBConnection.getConnection();
		
		try {
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs= ps.executeQuery(); 
			if(rs.next())
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}



	@Override
	public ResultSet getfilename(String filename) {

		sql="select filename from files where filename='"+filename+"'";
		
		con=DBConnection.getConnection();
		
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}



	@Override
	public boolean DeleteKeyRequest(int id,String email, String filename) {
		
		String sql="delete from keydetails where id='"+id+"' and email='"+email+"' and filename='"+filename+"'";
		
		 Connection con=DBConnection.getConnection();
		 try {
			 ps=con.prepareStatement(sql);
			int index =ps.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
			return flag;
	}



	@Override
	public Bean SelectFilename(String filename) {
		
		Bean bean=new Bean();
		
		String sql = "select * from keydetails where filename ='"+filename+"'";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			 rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				bean.setId(rs.getInt(1));
				bean.setEmail(rs.getString(2));
				bean.setFilename(rs.getString(3));
	            bean.setFilekey(rs.getString(4));
	            
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bean;
	}



	@Override
	public String getfilecontent(String filename) {
		
		String content = null;
      sql="select file from files where filename='"+filename+"'";
		
		con=DBConnection.getConnection();
		
		try {
			ps=con.prepareStatement(sql);
		
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				content=rs.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return content;
	}



	@Override
	public String getfilehashcode(String filename) {
		
		  String content = null;
	      sql="select hashcode from files where file='"+filename+"'";
			
			con=DBConnection.getConnection();
			
			try {
				ps=con.prepareStatement(sql);
			
				rs=ps.executeQuery();
				
				if(rs.next())
				{
					content=rs.getString(1);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			return content;
	}

	@Override
	public boolean DeleteFile(String filename) {
		
		String sql="delete from files where filename='"+filename+"'";
		
		 Connection con=DBConnection.getConnection();
		 try {
			 ps=con.prepareStatement(sql);
			int index =ps.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
			return flag;
	}



	
}
