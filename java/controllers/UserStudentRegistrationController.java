package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import models.StudentModel;
import repositories.StudentRepository;

/**
 * Servlet implementation class StudentRegistrationController
 */
@WebServlet("/UserStudentRegistrationController")
@MultipartConfig
public class UserStudentRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserStudentRegistrationController() {
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
PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String gender=request.getParameter("gender");
	    String phone=request.getParameter("phone");
	    String education=request.getParameter("education");
		 String[] attend1=request.getParameterValues("attend"); 
		/* String[] attend1 = request.getParameter("attend").split(","); */
		
		byte[] photoByte = null;
		
		 Part filePart = request.getPart("part");
		 out.print("photo"+filePart);
	if(filePart != null) {
		InputStream fileContextInputStream = filePart.getInputStream();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int checkPhoto;
		byte[] data = new byte[1024];
		while((checkPhoto = fileContextInputStream.read(data, 0 , data.length)) != -1) {
			byteArrayOutputStream.write(data, 0 , checkPhoto);
		}
		byteArrayOutputStream.flush();
		photoByte = byteArrayOutputStream.toByteArray();
	}
	
	StringBuffer stringBuffer = new StringBuffer(attend1[0]);
	for (int i = 1; i < attend1.length; i++) {
		stringBuffer.append(", ").append(attend1[i]);
	}
		StudentModel srs=new StudentModel(name,date,gender,phone,education,stringBuffer.toString(),photoByte);
	StudentRepository dao = new StudentRepository();
	int status = dao.createStudentRegistration(srs);
	if(status == 1) {
		
		request.setAttribute("success", "Success Registiration");
		request.getRequestDispatcher("studentRegistration_1.jsp").forward(request, response);
		
	}else {
		request.setAttribute("errors", "Insert Fail!!");
		request.getRequestDispatcher("studentRegistration_1.jsp").forward(request, response);
	}
	
	}
}