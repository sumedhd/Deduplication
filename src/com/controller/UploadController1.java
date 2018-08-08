package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import com.algorithm.BlowFishEncryptor;
import com.algorithm.KeyGeneration;
import com.algorithm.MD5;
import com.bean.UploadBean;
import com.connection.DBConnection;
import com.dao.APDao;
import com.dao.APDaoImpl;

@WebServlet("/UploadController1")
@MultipartConfig(maxFileSize=1024*1024*50)

public class UploadController1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String dbName="deduplication_bigdata";
	private String dbURL = "jdbc:mysql://localhost:3306/"+dbName; 
	private String dbUser = "root";
	private String dbPass = "root";
	
	
	String file=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
            {
    	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String filename=request.getParameter("filename");
		
		UploadBean bean=new UploadBean();
		
				
		InputStream inputStream = null; 
        Part part=request.getPart("file");
        String file_name=extractFileName(part);
        bean.setFilename(file_name);
        System.out.println("FirstPath==="+file_name); 
       
        APDao dao=new APDaoImpl();
        ResultSet rm=dao.getfilename(file_name);
        
        try {
			if(rm.next())
			{
				System.out.println("File Name Exists. Please Change File Name");
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('File Name Exists.Deduplication Occur');");  
				out.println("</script>");    
				request.getRequestDispatcher("UploadFile.jsp").include(request, response);
			}
			else {
			
			 String savePath="C:\\upload\\"+File.separator+"Original File";
			String EncryptedPath="C:\\upload\\"+File.separator+"Encryption File";
			
			ArrayList<String> list=new ArrayList<>();

			list.add(savePath);
			list.add(EncryptedPath);

			
			for(String s:list)
			{
			File fileSaveDir=new File(s);
			   if(!fileSaveDir.exists())
			   {
			       fileSaveDir.mkdir();
			   }
			} 
			
      
			String filePath= savePath + File.separator + file_name ; 
     
			BlowFishEncryptor bfe=new BlowFishEncryptor();
			try {
				
				bfe.encrypt(filePath);
				  
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
      
           KeyGeneration key=new KeyGeneration();
           String filekey=key.blowFishKey(file_name);
           
			part.write(filePath);
			file= EncryptedPath + File.separator + file_name ; 
			
			if (part != null) 
			{
			    System.out.println(part.getName());
			    System.out.println(part.getSize());
			    System.out.println(part.getContentType());
			  
			    inputStream = part.getInputStream();
			}
			 
			    bean.setKey(filekey);
			
				bean.setFile(inputStream);
				
			    Connection conn = DBConnection.getConnection();
			   
			    MD5 md=new MD5();
			    
			    
			    
			  try {
				
				PreparedStatement ps;
				
				String sql="insert into files(filename,file,filekey,hashcode) values(?,?,?,?)";
				Connection con=DBConnection.getConnection();
				
					ps=con.prepareStatement(sql);
				
				
					ps.setString(1, bean.getFilename());
				
					
					if(inputStream!=null)
					{
						ps.setBlob(2, inputStream);
					}
					
					ps.setString(3, bean.getKey());
					ps.setString(4, null);
					int index=ps.executeUpdate();
					
					
					if(index>0)
					{
						
						//out.println("<script type=\"text/javascript\">");
						//out.println("alert('Upload File Successfully');");
						//out.println("location='UploadFile.jsp';");
						//out.println("</script>");
						System.out.println("upload file");
					}
					
					String content=dao.getfilecontent(file_name);
				    String database_hashcode=dao.getfilehashcode(content);
				    System.out.println("Database Hashcode:"+database_hashcode);
					String hashcode=md.generate(content);
					String sql1="update files set hashcode=? where filename='"+file_name+"'";
					ps=con.prepareStatement(sql1);
					ps.setString(1, hashcode);
					int index1=ps.executeUpdate();
					if(index1>0)
					{
						System.out.println("enter hashcode");
					}
					
					String sql2="select * from files";
					ps=con.prepareStatement(sql2);
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
						String cc=rs.getString(5);
						
						if(cc.equals(database_hashcode))
						{
							out.println("<script type=\"text/javascript\">");
							out.println("alert('Dedulication Occur');");
							out.println("location='UploadFile.jsp';");
							out.println("</script>");
							
							dao.DeleteFile(file_name);
						}
					}
					
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('File uploaded successfully');");  
			        out.println("location='UploadFile.jsp';");
				    out.println("</script>");
					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			finally
			{
			 if (conn != null) 
			 {
			     try
			     {
			         conn.close();
			     } 
			     
			     catch (SQLException ex)
			     {
			         ex.printStackTrace();
			     }
			 }
			}}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
            }
	
    
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}