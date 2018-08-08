package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Bean;
import com.bean.UploadBean;
import com.bean.DataHolderBean;

public interface DataHolderDao {

	public boolean InsertUser(DataHolderBean user);
	
	public boolean availableUser(DataHolderBean user);
	
	public DataHolderBean CheckUser(String email,String password);
	
	public boolean UserDelete(DataHolderBean user);
	
	public DataHolderBean SelectUser(String email);

	
	public boolean UpdateUserStatus(int userID,String status);
	
	public ResultSet SelectUser();
	
	public boolean InsertKeyDetails(Bean bean);
	

	
	
}
