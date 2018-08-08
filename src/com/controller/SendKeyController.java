package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bean;
import com.bean.UploadBean;
import com.dao.APDao;
import com.dao.APDaoImpl;
import com.dao.DataHolderDao;
import com.dao.DataHolderDaoImpl;
import com.mail.SendKeyMail;

@WebServlet("/SendKeyController")
public class SendKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SendKeyController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("email");
		String filename=request.getParameter("filename");
		
		APDao admindao=new APDaoImpl();
		Bean bean=admindao.SelectFilename(filename);
		
		SendKeyMail keymail=new SendKeyMail();
		
		if(bean.getFilekey()!=""&&bean.getFilekey()!=null)
		{
			System.out.println("filekey:"+bean.getFilekey());
			keymail.SecretKeySend(email, bean.getFilekey());
			out.println("<script type=\"text/javascript\">");
			out.println("alert('send key successfully..');");
			out.println("location='ViewKeyRequest.jsp';");
			out.println("</script>");
			
			admindao.DeleteKeyRequest(id,email,filename);
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('key sending fail..');");
			out.println("location='ViewKeyRequest.jsp';");
			out.println("</script>");
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
