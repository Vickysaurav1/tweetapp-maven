package com.tweetapp.service;

import java.util.List;

import com.tweetapp.Dao.tweetDao;
import com.tweetapp.Dao.userDao;
import com.tweetapp.models.tweetModel;
import com.tweetapp.models.userModel;

public class displayService {
	public void displayUser(){
		userDao uDao=new userDao();
		List<userModel>user=uDao.getUser();
		if (user.isEmpty())
			System.out.println("NO user availble.\n");
		for(userModel u:user)
		System.out.println(u.getFirstName()+' '+u.getLastName());
	}
	public void DisplayTweets() {
		tweetDao tDao=new tweetDao();
		List<tweetModel>tweet=tDao.getTweet();
		if (tweet.isEmpty())
			System.out.println("NO tweets availble.\n");
		for(tweetModel u:tweet)
		System.out.println(u.getUserName()+"\t\t"+u.getTweetmsg()+"\n");
	}
	public void DisplayTweets(int userId) {
		tweetDao tDao=new tweetDao();
		List<tweetModel>tweet=tDao.getTweet(userId);
		if (tweet.isEmpty())
			System.out.println("NO tweets availble.\n");
		for(tweetModel u:tweet) {
		System.out.println(u.getUserId()+"\t\t"+u.getTweetmsg()+"\n");
		}
	}

}
