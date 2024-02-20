package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Role;
import models.UserModel;
import repositories.UserRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String name =request.getParameter("name"); String
		  password=request.getParameter("password");
		  
		  UserModel user=new UserModel(); user.setName(name);
		  user.setPassword(password); request.setAttribute("user", user);
		  if(user.getName()==null || user.getPassword()==null || name.equals("") ||
		  password.equals("")) {
			  HttpSession session=request.getSession();
		  session.setAttribute("LogIn", user); request.setAttribute("error",
		  "Please check your data again!!");
		  request.getRequestDispatcher("login.jsp").forward(request, response);
		  
		  }else { UserRepository repo=new UserRepository(); List<UserModel>
		  urs=repo.userBy(name); if(urs.size()==0 ) { request.setAttribute("error",
		  "Login Fail!!"); request.getRequestDispatcher("login.jsp").forward(request,
		  response); }if(password.equals(urs.get(0).getPassword()) &&
		  urs.get(0).getRole().equals("Admin")){
		  request.getSession().setAttribute("user", urs.get(0) );
		  request.getRequestDispatcher("menu.jsp").forward(request, response); }else
		  if(password.equals(urs.get(0).getPassword()) &&
		  urs.get(0).getRole().equals("User")){
		  request.getSession().setAttribute("user", urs.get(0) );
		  request.getRequestDispatcher("menu.jsp").forward(request, response); }else {
		  request.setAttribute("error", "Password do not match");
		  request.getRequestDispatcher("login.jsp").forward(request, response);
		  
		  } }
	}
}
	
		 
		/*
		 * String email = request.getParameter("email"); String password =
		 * request.getParameter("password");
		 * 
		 * UserModel user = new UserModel(); user.setEmail(email);
		 * user.setPassword(password); if(!user.getEmail().equals("") &&
		 * !user.getPassword().equals("")) { boolean error = false; UserRepository repo
		 * = new UserRepository(); List<UserModel> userList = repo.getallUser();
		 * Iterator<UserModel> itr = userList.iterator(); while(itr.hasNext()) {
		 * UserModel dto = itr.next(); if(user.getEmail().equals(dto.getEmail()) &&
		 * user.getPassword().equals(dto.getPassword())) {
		 * if(dto.getRole().equalsIgnoreCase(Role.ADMIN.name())) {
		 * request.getSession().setAttribute("User", dto);
		 * request.getRequestDispatcher("welcome.jsp").forward(request, response); }
		 * else if(dto.getRole().equalsIgnoreCase(Role.USER.name())){
		 * request.getSession().setAttribute("User",dto);
		 * request.getRequestDispatcher("welcome.jsp").forward(request, response); } } }
		 * 
		 * } }
		 * 
		 * }
		 */