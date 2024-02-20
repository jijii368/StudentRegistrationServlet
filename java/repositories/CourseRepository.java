package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.MyConnection;
import models.CourseModel;

public class CourseRepository {
     public int createCourse(CourseModel course) {
    	 int status=0;
    	 String query="insert into course(course_name) values(?)";
    	 Connection con=MyConnection.getInstance().getConnection();
    	 try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, course.getCourse_name());
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return status;
     }

     public List<CourseModel> allCourse() {
    		List<CourseModel> courses=new ArrayList<CourseModel>();
    		String query="select * from course";
    		Connection con=MyConnection.getInstance().getConnection();
    		try {
    			PreparedStatement ps=con.prepareStatement(query);
    			
    			ResultSet rs=ps.executeQuery();
    			while (rs.next()) {
    				CourseModel course = new CourseModel();
    				course.setId(rs.getInt("id"));
    				course.setCourse_name(rs.getString("course_name"));
    					
    				courses.add(course);
    			}
    		} catch (SQLException e) {
    			System.out.println(e.getMessage());
    			e.printStackTrace();
    		}
    		return courses;

    	    }
     public int updateCourse(CourseModel course) {
    		int status=0;
    		String query="update course set course_name=? where id=?";
    		Connection con=MyConnection.getInstance().getConnection();
    		try {
    			PreparedStatement ps=con.prepareStatement(query);
    			ps.setString(1, course.getCourse_name());
    			ps.setInt(2, course.getId());
    			
    			status=ps.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println(e);
    			e.printStackTrace();
    		}
    		return status;
    	}
     public int getCourseDelete(int id){
    		int status=0;
    		String query="delete from course where id=?";
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
