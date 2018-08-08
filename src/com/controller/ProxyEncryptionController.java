package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algorithm.BlowFishEncryptor;
import com.algorithm.ProxyEncryption;

@WebServlet("/ProxyEncryptionController")
public class ProxyEncryptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProxyEncryptionController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String filename=request.getParameter("filename");
		
		System.out.println(filename);
		
		String filepath="D:\\upload\\Original File\\"+File.separator+filename;
		
		ProxyEncryption bb=new ProxyEncryption();
		
		try {
			
			bb.encrypt(filepath);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Encrypt File Successfully');");
			out.println("location='ReEncryptionFiles.jsp';");
			out.println("</script>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
