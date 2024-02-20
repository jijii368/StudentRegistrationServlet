package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.MyConnection;
import models.UserModel;

public class UserRepository {
	
	public int createUserRegistration(UserModel user) {
		
		int status=0;
		String query="insert into user(name,email,password,role) values(?,?,?,?)";
		Connection con=MyConnection.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			status =ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  status;
	}
	
public List<UserModel> userBy(String name){ 
		
		List<UserModel> users=new ArrayList<UserModel>();
		String query="select * from user where name=?";
		
		Connection con=MyConnection.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return users;
	}
public List<UserModel> getallUser() {
	List<UserModel> urs=new ArrayList<UserModel>();
	
	String query="select * from user ";
	
	
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			UserModel ur = new UserModel();
			ur.setId(rs.getInt("id"));
			ur.setName(rs.getString("name"));
			ur.setEmail(rs.getString("email"));
			ur.setPassword(rs.getString("password"));
			ur.setRole(rs.getString("role"));
			urs.add(ur);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return urs;

    }
public List<UserModel> userId(int id){ 
	
	List<UserModel> urs=new ArrayList<UserModel>();
	String query="select * from user where id=?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			UserModel ur = new UserModel();
			ur.setId(rs.getInt("id"));
			ur.setName(rs.getString("name"));
			ur.setEmail(rs.getString("email"));
			ur.setPassword(rs.getString("password"));
			ur.setRole(rs.getString("role"));
			urs.add(ur);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return urs;
}
public List<UserModel> userByName(int id,String name){ 
	
	List<UserModel> urs=new ArrayList<UserModel>();
	String query="select * from user where id=? or name like ?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, "%"+ name +"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			UserModel ur = new UserModel();
			ur.setId(rs.getInt("id"));
			ur.setName(rs.getString("name"));
			ur.setEmail(rs.getString("email"));
			ur.setPassword(rs.getString("password"));
			ur.setRole(rs.getString("role"));
			urs.add(ur);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return urs;
}

public int updateUserRegistration(UserModel user) {
	int status=0;
	String query="update user set name=?,email=?,password=?,role=? where id=?";
	Connection con=MyConnection.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getRole());
		ps.setInt(5, user.getId());
		status=ps.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return status;
}
public int getUserDelete(int id){
	int status=0;
	String query="delete from user where id=?";
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
