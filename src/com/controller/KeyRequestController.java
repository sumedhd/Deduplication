package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Bean;
import com.bean.UploadBean;
import com.dao.DataHolderDao;
import com.dao.DataHolderDaoImpl;

@WebServlet("/KeyRequestController")
public class KeyRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public KeyRequestController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String filename=request.getParameter("filename");
		String filekey=request.getParameter("filekey");
	
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		
		Bean bean=new Bean();
		
		bean.setFilename(filename);
		bean.setFilekey(filekey);
		bean.setEmail(email);
		
		DataHolderDao dao=new DataHolderDaoImpl();
		
		if(dao.InsertKeyDetails(bean))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Key Request send successfully..');");
			out.println("location='ViewAllFiles.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Key Request sending fail..');");
			out.println("location='ViewAllFiles.jsp';");
			out.println("</script>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
