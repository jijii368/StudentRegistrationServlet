package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.MyConnection;
import models.StudentModel;

public class StudentRepository {
public int createStudentRegistration(StudentModel student) {
		
		int status=0;
		String query="insert into student(name,date,gender,phone,education,attend,photo) values(?,?,?,?,?,?,?)";
		Connection con=MyConnection.getInstance().getConnection();
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getDate());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getPhone());
			ps.setString(5, student.getEducation());
			ps.setString(6, student.getAttend());
			ps.setBytes(7, student.getPhoto());
			status =ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		return status;
	}

public List<StudentModel> allStudentUser() {
	List<StudentModel> srs=new ArrayList<StudentModel>();
	String query="select * from student";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			StudentModel sr = new StudentModel();
				sr.setId(rs.getInt("id"));
				sr.setName(rs.getString("name"));
				sr.setDate(rs.getString("date"));
				sr.setGender(rs.getString("gender"));
				sr.setPhone(rs.getString("phone"));
				sr.setEducation(rs.getString("education"));
				sr.setAttend(rs.getString("attend"));
				sr.setPhoto(rs.getBytes("photo"));
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;

    }
public List<StudentModel> studentAttend(String attend){ 
	
	List<StudentModel> srs=new ArrayList<StudentModel>();
	String query="select * from student where attend like ?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
	     ps.setString(1,"%"+ attend +"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			StudentModel sr = new StudentModel();

			sr.setId(rs.getInt("id"));
			sr.setName(rs.getString("name"));
			sr.setDate(rs.getString("date"));
			sr.setGender(rs.getString("gender"));
			sr.setPhone(rs.getString("phone"));
			sr.setEducation(rs.getString("education"));
			sr.setAttend(rs.getString("attend"));
			sr.setPhoto(rs.getBytes("photo"));
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;
}

public List<StudentModel> studentById(int id){ 
	
	List<StudentModel> srs=new ArrayList<StudentModel>();
	String query="select * from student where id=?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			StudentModel sr = new StudentModel();
			sr.setId(rs.getInt("id"));
			sr.setName(rs.getString("name"));
			sr.setDate(rs.getString("date"));
			sr.setGender(rs.getString("gender"));
			sr.setPhone(rs.getString("phone"));
			sr.setEducation(rs.getString("education"));
			sr.setAttend(rs.getString("attend"));
			sr.setPhoto(rs.getBytes("photo"));
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;
}

public List<StudentModel> studentName(String name){ 
	
	List<StudentModel> srs=new ArrayList<StudentModel>();
	String query="select * from student where name like ?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
	     ps.setString(1,"%"+ name +"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			StudentModel sr = new StudentModel();

			sr.setId(rs.getInt("id"));
			sr.setName(rs.getString("name"));
			sr.setDate(rs.getString("date"));
			sr.setGender(rs.getString("gender"));
			sr.setPhone(rs.getString("phone"));
			sr.setEducation(rs.getString("education"));
			sr.setAttend(rs.getString("attend"));
			sr.setPhoto(rs.getBytes("photo"));
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;
}

public List<StudentModel> studentMore(int id,String name,String attend){ 
	
	List<StudentModel> srs=new ArrayList<StudentModel>();
	String query="select * from student where id=? and name like ? and attend like ?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		 ps.setString(2, "%"+name+"%" );
	     ps.setString(3, "%"+attend+"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			StudentModel sr = new StudentModel();

			sr.setId(rs.getInt("id"));
			sr.setName(rs.getString("name"));
			sr.setDate(rs.getString("date"));
			sr.setGender(rs.getString("gender"));
			sr.setPhone(rs.getString("phone"));
			sr.setEducation(rs.getString("education"));
			sr.setAttend(rs.getString("attend"));
			sr.setPhoto(rs.getBytes("photo"));
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;
}
public int updateStudentRegistration(StudentModel srs) {
	int status=0;
	String query="update student set name=?,date=?,gender=?,phone=?,education=?,attend=?,photo=? where id=?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1, srs.getName());
		ps.setString(2, srs.getDate());
		ps.setString(3, srs.getGender());
		ps.setString(4, srs.getPhone());
		ps.setString(5, srs.getEducation());
		ps.setString(6, srs.getAttend());
		ps.setBytes(7, srs.getPhoto());
		ps.setInt(8, srs.getId());
		status=ps.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return status;
}

  public int studentDelete(int id){
	int status=0;
	String query="delete from student where id=?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		status=ps.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return status;
}
}
