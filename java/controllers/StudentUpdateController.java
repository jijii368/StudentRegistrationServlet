package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.StudentModel;
import models.UserModel;
import repositories.StudentRepository;
import repositories.UserRepository;

/**
 * Servlet implementation class StudentUpdateController
 */
@WebServlet("/StudentUpdateController")
@MultipartConfig
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateController() {
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
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String name=request.getParameter("name");
		String date=request.getParameter("date");
		String gender=request.getParameter("gender");
	    String phone=request.getParameter("phone");
	    String education=request.getParameter("education");
	    System.out.println("ok ok");
	    String[] attend1 = request.getParameterValues("attend");
		/* System.out.println(attend1[0]); */
	    
//		String[] attend1=request.getParameterValues("attend");
		byte[] photoByte = null;
		
		 Part filePart = request.getPart("part");
		
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
	
		StudentModel srs=new StudentModel(id,name,date,gender,phone,education,stringBuffer.toString(),photoByte);
	  StudentRepository dao = new StudentRepository();
	int status = dao.updateStudentRegistration(srs);
	if(status == 1) {
		request.setAttribute("success", "Update Successfully.");	
		request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
		
	}else {
		request.setAttribute("error", "Update Fail!!");
		request.getRequestDispatcher("studentUpdate.jsp").forward(request, response);
	}
	
	}

	}
