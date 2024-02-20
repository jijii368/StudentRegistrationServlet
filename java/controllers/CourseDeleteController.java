package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.CourseRepository;
import repositories.UserRepository;

/**
 * Servlet implementation class CourseDeleteController
 */
@WebServlet("/CourseDeleteController")
public class CourseDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String id1=request.getParameter("id");
	int id=Integer.parseInt(id1);
	CourseRepository dao=new CourseRepository(); 
	int status=dao.getCourseDelete(id);
	if(status==1) {
		response.sendRedirect("courseManagement.jsp");
	}else {
		response.sendRedirect("courseRegistration.jsp");
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
