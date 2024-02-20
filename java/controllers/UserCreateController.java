		package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserModel;
import repositories.UserRepository;

/**
 * Servlet implementation class UserCreateController
 */
@WebServlet("/UserCreateController")
public class UserCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		/*
		 * HttpSession session=request.getSession(); UserModel users=(UserModel)
		 * session.getAttribute("LogIn"); if(users == null) {
		 * request.setAttribute("warn", "Please Login First!!");
		 * request.getRequestDispatcher("login.jsp").forward(request, response); }else {
		 */
		if(name.equals("")||email.equals("")||password.equals("")||role.equals("")) {
			request.setAttribute("error", "Fill in the blank");
			
			UserModel user=new UserModel();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("userRegistration.jsp").include(request, response);
		}else if(password.equals(password)) {
			
			UserModel user=new UserModel(name,email,password,role);
			UserRepository repo=new UserRepository();
			int status=repo.createUserRegistration(user);
			if(status==1) {
				request.setAttribute("success", "^^Successfully Register Please Login!^^");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "");
				request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
			}
			
		}else if(!password.equals(password)) {
			request.setAttribute("error", "Password don't match");
			request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
		}
			
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		String role=request.getParameter("role");
		
		if(name.equals("")||email.equals("")||password.equals("")||password1.equals("")||role.equals("")) {
			request.setAttribute("error", "Fill in the blank");
			UserModel user=new UserModel();
			user.setName(name);
			user.setEmail(email);
			user.setRole(role);
			request.setAttribute("user",user);
			request.getRequestDispatcher("userRegistration.jsp").include(request, response);
			
		}else if(password.equals(password1)) {
			
			UserModel user=new UserModel(name,email,password1,role);
			UserRepository repo=new UserRepository();
			int status=repo.createUserRegistration(user);
			if(status==1) {
				request.getRequestDispatcher("userManagement.jsp").forward(request, response);
				
			}else {
				request.setAttribute("error", "Id is Duplicate entry,so don't match Id");
				request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
			}
			
		}else if(!password.equals(password1)) {
			request.setAttribute("error", "Password don't match");
			request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
		}
		
		
	}
}