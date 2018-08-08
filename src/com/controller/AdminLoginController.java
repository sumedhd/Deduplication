package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.APbean;
import com.dao.APDao;
import com.dao.APDaoImpl;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminLoginController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
        APbean bean=new APbean();
		
		bean.setEmail(email);
		bean.setPassword(password);
		
		APDao dao=new APDaoImpl();
		
		if(dao.CheckAdmin(email, password))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Successfully..');");
			out.println("location='AdminView.jsp';");
			out.println("</script>");
			HttpSession session=request.getSession();  
	        session.setAttribute("email",email);
			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Login Failed..');");
			out.println("location='AdminLogin.jsp';");
			out.println("</script>");
		}
	}

}
