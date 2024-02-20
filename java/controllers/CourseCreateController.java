package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CourseModel;
import repositories.CourseRepository;

/**
 * Servlet implementation class CourseCreateController
 */
@WebServlet("/CourseCreateController")
public class CourseCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course_name=request.getParameter("name");
		
		if( !course_name.equals("")) {
			
		CourseModel course=new CourseModel(course_name);
		
		CourseRepository crepo=new CourseRepository();
		
	    int status=crepo.createCourse(course);
	    
	    if(status==1) {
	    	request.setAttribute("success", "Successfully");
			request.getRequestDispatcher("courseRegistration.jsp").forward(request, response);
	    }else {
			request.setAttribute("error", "Course Name is do not match!!");
			request.getRequestDispatcher("courseRegistration.jsp").forward(request, response);
		}
		}else if( course_name.equals("")){
			request.setAttribute("error", "Fill the Blank!");
			request.getRequestDispatcher("courseRegistration.jsp").forward(request, response);
		}
	}

}