package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bean.CloudBean;
import com.dao.APDao;
import com.dao.APDaoImpl;

@WebServlet("/CloudLoginController")
public class CloudLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CloudLoginController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
        CloudBean bean=new CloudBean();
		
		bean.setEmail(email);
		bean.setPassword(password);
		
		APDao dao=new APDaoImpl();
		
		if(dao.CheckCloudServer(email, password))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successfully..');");
			out.println("location='CloudView.jsp';");
			out.println("</script>");
			HttpSession session=request.getSession();  
	        session.setAttribute("email",email);
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Failed..');");
			out.println("location='CloudLogin.jsp';");
			out.println("</script>");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
