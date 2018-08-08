package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DataHolderBean;
import com.dao.DataHolderDao;
import com.dao.DataHolderDaoImpl;

@WebServlet("/UserDeleteController")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserDeleteController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobileno=request.getParameter("mobileno");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String status=request.getParameter("status");
		DataHolderBean user=new DataHolderBean();
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobileno(mobileno);
		user.setAddress(address);
		user.setGender(gender);
		user.setDob(dob);
		user.setStatus(status);
		
		DataHolderDao dao=new DataHolderDaoImpl();
		if(dao.UserDelete(user))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Delete Successfully..');");
			out.println("location='ViewUsers.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Delete UnSuccessful..');");
			out.println("location='ViewUsers.jsp';");
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
