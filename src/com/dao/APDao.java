package com.dao;

import java.sql.ResultSet;

import com.bean.Bean;
import com.bean.UploadBean;

public interface APDao {
	
	
	
	public boolean CheckAdmin(String email,String password);
	
	public boolean CheckCloudServer(String email,String password);
	
	public  ResultSet getfilename(String filename) ;
	
	public boolean DeleteKeyRequest(int id,String email,String filename);
	
	public Bean SelectFilename(String filename);
	
	public  String getfilecontent(String filename) ;

	public  String getfilehashcode(String filename) ;
	
	public boolean DeleteFile(String filename);
}
