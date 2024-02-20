package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.StudentRepository;
import repositories.UserRepository;

/**
 * Servlet implementation class StudentDeleteController
 */
@WebServlet("/StudentDeleteController")
@MultipartConfig
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		String id1=request.getParameter("id");
		
		if(!id1.isEmpty()||id1!=null) {
			id=Integer.valueOf(id1);
		}
		StudentRepository dao=new StudentRepository(); 
		int status=dao.studentDelete(id);
		if(status==1) {
			response.sendRedirect("studentSearch.jsp");
		}else {
			request.setAttribute("error", "Something wrong!!");
			response.sendRedirect("studentSearch.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
