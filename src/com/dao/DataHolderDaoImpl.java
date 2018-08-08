package com.dao;
import java.sql.*;
import java.util.ArrayList;

import com.bean.Bean;
import com.bean.UploadBean;
import com.bean.DataHolderBean;
import com.connection.DBConnection;

public class DataHolderDaoImpl implements DataHolderDao{
	
	boolean flag=false;
	String sql;
	PreparedStatement pm;
	ResultSet rs;
	Connection con;
	
	@Override
	public boolean InsertUser(DataHolderBean user) {
		
		
		try {
			
			sql="insert into tbl_dataholder(name,email,password,mobileno,address,gender,dob,status) values(?,?,?,?,?,?,?,?)";
			Connection con=DBConnection.getConnection();
			
			 pm=con.prepareStatement(sql);
			
			pm.setString(1, user.getName());
			pm.setString(2, user.getEmail());
			pm.setString(3, user.getPassword());
			pm.setString(4, user.getMobileno());
			pm.setString(5, user.getAddress());
			pm.setString(6, user.getGender());
			pm.setString(7, user.getDob());
			pm.setString(8, user.getStatus());
			
			int index=pm.executeUpdate();
			
			if(index>0)
			{
				System.out.println("enter into the database");
				flag=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean availableUser(DataHolderBean user) {
		
		sql="select * from tbl_dataholder where email='"+user.getEmail()+"'";
		try {
			Statement st=DBConnection.getConnection().createStatement();
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return flag;
	}

	@Override
	public DataHolderBean CheckUser(String email, String password) {
		
		DataHolderBean user = new DataHolderBean();
		sql="select * from tbl_dataholder where email='"+email+"' and password='"+password+"'";
		
		//Connection con=DBConnection.getConnection();
		
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				   user.setId(rs.getInt(1));
				   user.setName(rs.getString(2));
	               user.setEmail(rs.getString(3));
	               user.setPassword(rs.getString(4));
	               user.setMobileno(rs.getString(5));
	               user.setAddress(rs.getString(6));
	               user.setGender(rs.getString(7));
	               user.setDob(rs.getString(8));
	               user.setStatus(rs.getString(9));
			}
			else
			{
				flag=false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean UserDelete(DataHolderBean user) {
		
	 String sql="delete from tbl_dataholder where name='"+user.getName()+"'";
	 Connection con=DBConnection.getConnection();
	 try {
		pm=con.prepareStatement(sql);
		int index =pm.executeUpdate();
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
	public DataHolderBean SelectUser(String email) {
		
		DataHolderBean user = new DataHolderBean();
		String sql = "Select * from tbl_dataholder where email ='"+email+"'";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			 rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				   user.setName(rs.getString(2));
	               user.setEmail(rs.getString(3));
	               user.setPassword(rs.getString(4));
	               user.setMobileno(rs.getString(5));
	               user.setAddress(rs.getString(6));
	               user.setGender(rs.getString(7));
	               user.setDob(rs.getString(8));
					
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public boolean UpdateUserStatus(int userID, String status) {
		
		if(status.equalsIgnoreCase("Inactive"))
			status="Active";
		else
			status="Inactive";
		
		String sql="update tbl_dataholder set status=? where id=?";
		
		try {
			pm=DBConnection.getConnection().prepareStatement(sql);
			pm.setString(1, status);
			pm.setInt(2, userID);
			
			int index=pm.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ResultSet SelectUser() {
		
		ResultSet rs= null;
		String sql ="Select * from tbl_dataholder";
		try {
			PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean InsertKeyDetails(Bean bean) {
		try {
			sql="insert into keydetails(email,filename,filekey) values(?,?,?)";
			
			Connection con=DBConnection.getConnection();
			
			 pm=con.prepareStatement(sql);
			
			pm.setString(1, bean.getEmail());
			pm.setString(2, bean.getFilename());
			pm.setString(3, bean.getFilekey());
			
			int index=pm.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}	
}
