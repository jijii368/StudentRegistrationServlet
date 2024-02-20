package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserModel;
import repositories.UserRepository;

/**
 * Servlet implementation class UserUpdateController
 */
@WebServlet("/UserUpdateController")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		 
		if( !name.equals("")){
			UserRepository dao=new UserRepository(); 
			List<UserModel> urs=dao.userBy(name);
			request.setAttribute("ur", urs);
			request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		}
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id1=request.getParameter("id");
		  String name=request.getParameter("name");
		  String email=request.getParameter("email");
		  String password=request.getParameter("password"); 
		  String role=request.getParameter("role");
		  int id=Integer.parseInt(id1);
		 UserModel users=new UserModel();
		 
		 users.setName(name);
		 users.setEmail(email);
		 users.setPassword(password);
		 users.setRole(role);
		 
		  if(!id1.equals("") && !name.equals("") && !email.equals("") && !password.equals("") && !role.equals("")) {
			
			  UserModel user=new UserModel(id,name,email,password,role); 
			 UserRepository dao=new UserRepository(); 
		  int status=dao.updateUserRegistration(user); 
		  if(status==1) {
			  request.setAttribute("success", "Update Successfully.");
			  request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		  }else {
			  request.setAttribute("error", "Update Fail!!");
			  request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		  }
		  }else if(id1.equals("") || name.equals("") || email.equals("") || password.equals("") || role.equals("")){
			  request.setAttribute("error", "Fill in the Blank!!");
			  request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
		  }
		
	}

}

