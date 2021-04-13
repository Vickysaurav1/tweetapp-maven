package com.tweetapp.models;

public class tweetModel {
	private String tweetmsg;
	private int userId;
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String UserName) {
		this.userName = UserName;
	}
	public String getTweetmsg() {
		return tweetmsg;
	}
	public void setTweetmsg(String tweetmsg) {
		this.tweetmsg = tweetmsg;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "tweetModel [tweetmsg=" + tweetmsg + ", userId=" + userId + ", setUserName=" + userName + "]";
	}

}
