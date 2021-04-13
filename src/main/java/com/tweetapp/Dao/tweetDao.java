package com.tweetapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tweetapp.models.tweetModel;


public class tweetDao {
	userDao uDao =new userDao();
	public List<tweetModel> getTweet() {
		try {
			Connection con=uDao.databaseConnection();
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select tweetdata.userid,firstname,tweetmsg from tweetdata "
					+ "join userdata on tweetdata.userid=userdata.userid"); 
			List<tweetModel> list = new ArrayList<tweetModel>();
			try {
			while (rs.next()) {
				tweetModel tweetmsg = new tweetModel();
				tweetmsg.setTweetmsg(rs.getString("tweetmsg"));
				tweetmsg.setUserName(rs.getString("firstname"));
				tweetmsg.setUserId(rs.getInt("userid"));
				list.add(tweetmsg);
			} 
			
			} finally {
				rs.close();
				con.close();
			}
			return list;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		
	}	public List<tweetModel> getTweet(int userId) {
		try {
		Connection con=uDao.databaseConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * from tweetdata WHERE  userId = ?");
		statement.setInt(1, userId);
		ResultSet rs=statement.executeQuery();
		List<tweetModel> list = new ArrayList<tweetModel>();
		try {
		while (rs.next()) {
			tweetModel tweetmsg = new tweetModel();
			tweetmsg.setTweetmsg(rs.getString("tweetmsg"));
			tweetmsg.setUserId(rs.getInt("userid"));
			list.add(tweetmsg);
		} 
		} finally {
			rs.close();
			con.close();
		}
		return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public boolean addTweet(tweetModel tweet) {
		try {
			Connection con=uDao.databaseConnection();
			String query = "insert into tweetdata(userId,tweetmsg) values (?,?)";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString (2, tweet.getTweetmsg());
	      preparedStmt.setInt (1,tweet.getUserId());
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
	
}
