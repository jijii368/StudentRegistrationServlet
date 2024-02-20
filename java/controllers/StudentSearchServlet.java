package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.StudentModel;
import repositories.StudentRepository;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         String id=request.getParameter("id"); 
//		
//		if(!id.equals("") ){
//			StudentRepository dao=new StudentRepository();
//			List<StudentModel> srs=dao.studentById(Integer.parseInt(id));
//			
//				request.getServletContext().setAttribute("sr", srs);
//				
//				request.getRequestDispatcher("studentSearch.jsp").forward(request, response);
//		}else {
//			request.getServletContext().setAttribute("sr", "search null");
//			request.getRequestDispatcher("studentSearch.jsp").forward(request, response);
//		}
	
	  String studentId=request.getParameter("id"); 
		
	  String name = request.getParameter("name");
	  String attend = request.getParameter("attend"); 
	  StudentRepository dao = new StudentRepository();
	  
		
		 /* if (studentId.equals("") && name.equals("") && attend.equals("")) {
		  List<StudentModel> studentsList = dao.allStudentUser();
		  request.setAttribute("List", studentsList); } 
		  else if (!attend.equals("") && studentId.equals("") && name.equals("")) { 
			  List<StudentModel> studentsList =
		  dao.studentAttend(attend); 
			  if (studentsList.size()==0) {
		  request.setAttribute("error", "Student not found"); 
		  } else {
		  request.setAttribute("List", studentsList); } 
			  } else if (attend.equals("") && !studentId.equals("") && name.equals("")) {
				  List<StudentModel> studentsList = dao.studentById(id); 
				  if (studentsList.size()==0) {
		  request.setAttribute("error", "Student not found"); 
		  } else {
		  request.setAttribute("List", studentsList); }
				  } else if (attend.equals("") &&
		  studentId.equals("") && !name.equals("")) { 
					  List<StudentModel> studentsList =
		  dao.studentName(name);
					  if (studentsList.size() == 0) {
		  request.setAttribute("error", "Student not found"); }
					  else {
		  request.setAttribute("List", studentsList); } 
					  } else if(!studentId.equals("") || !name.equals("") || !attend.equals("")) {
		  List<StudentModel> studentsList = dao.studentMore(id, name.trim(), attend);
		  if (studentsList.size() == 0) {
			  request.setAttribute("error", "Student not found"); 
			  }
		  else { request.setAttribute("List", studentsList); }
		  request.getRequestDispatcher("studentSearch.jsp").forward(request, response);
		  } 
		  }*/
		 
		    if((!studentId.isEmpty() && studentId != null) && (!name.isEmpty() && name != null) && (!attend.isEmpty() && attend != null)) {
		    	
		    	int id = Integer.valueOf(studentId);
		    	List<StudentModel> studentsList = dao.studentMore(id, name.trim(), attend);
		    	
		    	request.setAttribute("List", studentsList);
		    }else 
		    	
		    	if(!studentId.isEmpty() && studentId != null) {
		    	int id = Integer.valueOf(studentId);
		     List<StudentModel> studentList = dao.studentById(id);
		      
		     request.setAttribute("List", studentList);
		    }else if(!name.isEmpty() && name != null) {
		    	List<StudentModel> studentList = dao.studentName(name.trim());
		    	
		    	request.setAttribute("List", studentList);
		    }else if(!attend.isEmpty() && attend != null) {
		    	List<StudentModel> studentList = dao.studentAttend(attend);
		    	
		    	request.setAttribute("List", studentList);
		    }else {
		    	request.setAttribute("error", "Student not found"); 
		    }

		    request.getRequestDispatcher("studentSearch.jsp").forward(request, response);
		}
		
		



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
