package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
	private final String DRIVER="com.mysql.cj.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/ojt12";
	private final String USERNAME="root";
	private final String PASSWORD="root";
	private static Connection connection;
	private static MyConnection instance;
	
	private MyConnection() {
		
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static MyConnection getInstance(){
		if(instance==null) {
			instance=new MyConnection();
		}
		return instance;
		}
	public  Connection getConnection() {
		return connection;
	}
	

}
