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
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		int id=Integer.parseInt(id1);
        String name = request.getParameter("name");
        System.out.println(id1);
        System.out.println(id);
        System.out.println(name);
        
		/*
		 * HttpSession session=request.getSession(); UserModel users=(UserModel)
		 * session.getAttribute("LogIn"); if(users == null) {
		 * request.setAttribute("warn", "Please Login First!!");
		 * request.getRequestDispatcher("login.jsp").forward(request, response); }else {
		 */

        UserRepository dao = new UserRepository();
       

        if (id1.equals("") && name.equals("")) {
            List<UserModel> urs = dao.getallUser();
            request.setAttribute("ur", urs);
        } else if (!id1.equals("")) {
            List<UserModel> urs = dao.userId(id);
            if (urs.size() == 0) {
                request.setAttribute("error", "User not found");
            } else {
                request.setAttribute("ur", urs);
            }
        } else {
            List<UserModel> urs = dao.userByName(id, name);
            if (urs.size() == 0) {
                request.setAttribute("error", "User not found");
            } else {
                request.setAttribute("ur", urs);
            }
        }

        request.getRequestDispatcher("userManagement.jsp").forward(request, response);
    }
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
