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
import com.mail.SendEmail;
import com.mail.SendRegistration;

@WebServlet("/UserRegisterController")
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserRegisterController() {
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
		String status="InActive";
		
		DataHolderBean user= new DataHolderBean();
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobileno(mobileno);
		user.setAddress(address);
		user.setGender(gender);
		user.setDob(dob);
		user.setStatus(status);
		
		DataHolderDao dao=new DataHolderDaoImpl();
		
		if(dao.availableUser(user))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User is already available');");
			out.println("location='Register.jsp';");
			out.println("</script>");
			System.out.println("User is already available");
		}
		else
		{
			if(dao.InsertUser(user))
			{
				//EmailSend es = new EmailSend();
				//es.sendRegistrationEmail(email);
				
				out.println("<script type=\"text/javascript\">");
				
				out.println("alert('Registration Successfully..');");
				SendEmail mail=new SendEmail();
				mail.RegistrationMail(email);
				
				SendRegistration ss=new SendRegistration();
				ss.RegistrationMail("anupama.murkute@gmail.com");
				out.println("location='UserLogin.jsp';");
				out.println("</script>");
				
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration UnSuccessfull..');");
				out.println("location='Register.jsp';");
				out.println("</script>");
			}
		}
		
		
	}
	//}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
