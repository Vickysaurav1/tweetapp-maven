package com.tweetapp.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tweetapp.models.userModel;
public class userDao {
	public List<userModel> getUser() {
		try {
		Connection con=databaseConnection();
		Statement stmt=con.createStatement(); 
		ResultSet rs=stmt.executeQuery("select * from userdata"); 
		List<userModel> list = new ArrayList<userModel>();
		try {
		while (rs.next()) {
			userModel user = new userModel();

			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setGender(rs.getString("gender"));
			user.setDob((Date)rs.getDate("dob"));
			user.setUserId(rs.getInt("userId"));
			user.setEmailId(rs.getString("emailId"));
			user.setPassword(rs.getString("password"));
			list.add(user);
		} 
			rs.close();
		} finally {
			con.close();
		}
		return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	public boolean registerUser(userModel user) {
		
		try {
			Connection con=databaseConnection();
			String query = " insert into userdata (firstname,lastname,emailid,password,gender,dob)"
		        + " values (?, ?, ?, ?, ?,?)";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString (1, user.getFirstName());
	      preparedStmt.setString (2, user.getLastName());
	      preparedStmt.setDate   (6, user.getDob());
	      preparedStmt.setString(3, user.getEmailId());
	      preparedStmt.setString(4, user.getPassword());
	      preparedStmt.setString(5,user.getGender());
	      try {
	      preparedStmt.execute();
	      } catch (Exception e) {
	    	 System.out.println(e);
			}
	      finally {
	    	  con.close();
	      }
	      
	      return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean ResetPassword(userModel user) {
		try {
			Connection con=databaseConnection();
			String query = "update userdata set password=? where userid=?";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString(1, user.getPassword());
	      preparedStmt.setInt(2, user.getUserId());
	      try {
	      preparedStmt.execute();
	      } catch (Exception e) {
	    	 System.out.println(e);
			}
	      finally {
	    	  con.close();
	      }
	      
	      return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void UpdateLogin(userModel user) {
		try {
			Connection con=databaseConnection();
			String query = "update userdata set loggedIn=? where userid=?";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setInt(1,user.getLoggedIn());
	      preparedStmt.setInt(2, user.getUserId());
	      try {
	      preparedStmt.execute();
	      } catch (Exception e) {
	    	 System.out.println(e);
			}
	      finally {
	    	  con.close();
	      }
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public Connection databaseConnection() {
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/tweetappdb","tweetAdmin","tweetAdmin");   
		return con; 
		}catch(Exception e){ System.out.println(e);}  
	return null;
	} 
}
