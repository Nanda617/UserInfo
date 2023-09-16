package DataAccess;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import Model.User_InfoModel;


public class User_Info {
	
	static String url="jdbc:mysql://localhost:3306/thirdyr_project?user=root&password=root";
	
	public static void Insert(String name,String password) throws SQLException{
		
		Connection conn=DriverManager.getConnection(url);
		
		String sql = "insert into User_Info(UserName,Password)values(?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, name);
		pstm.setString(2,password);
		
		int rowAffected = pstm.executeUpdate();
		
		if(rowAffected >=1) {
			System.out.println("Success");
		}
		else {
			System.out.println("Failed");
		}
		pstm.close();
		conn.close();
		}
	

	
	
	public static void Check() throws SQLException{
		
		Connection conn=DriverManager.getConnection(url);
		
		String sql = "select * from User_Info";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet res = pstm.executeQuery();
		
		while (res.next()) {
			
			User_InfoModel user = new User_InfoModel();
			user.setUserName(res.getString("UserName"));
			user.setPassword(res.getString("Password"));
		}
		
		pstm.close();
		conn.close();	
	}
	
	public static void main(String args[]) throws SQLException {
		User_Info.Insert("Chen Yi", "2023");
	}

}
