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
 * Servlet implementation class CourseUpdateController
 */
@WebServlet("/CourseUpdateController")
public class CourseUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		 String course_name=request.getParameter("name");
		 

			if( !id1.equals("") && !course_name.equals("")){
				 
				int id=Integer.parseInt(id1);
				CourseModel course=new CourseModel(id,course_name);
				
				request.setAttribute("ur", course);
			
				  request.getRequestDispatcher("courseRegistration_1.jsp").forward(request, response);
			}else {
				
				  request.getRequestDispatcher("courseRegistration_1.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		String course_name=request.getParameter("name");
		
	  CourseModel courses=new CourseModel(course_name);
	  
	  request.setAttribute("courses", courses);
	
	  if(!id1.equals("") && !course_name.equals("")) {
		  int id=Integer.parseInt(id1);
		  CourseModel course=new CourseModel(id,course_name); 
		  CourseRepository dao=new CourseRepository();
	  int status=dao.updateCourse(course); 
	  if(status==1) {
		  request.setAttribute("success", "Update Successfully.");
		  request.getRequestDispatcher("courseRegistration_1.jsp").forward(request, response);
	  }else {
		  request.setAttribute("error", "Update Fail!!");
		  request.getRequestDispatcher("courseRegistration_1.jsp").forward(request, response);
	  }
	  }
	}
}
