package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.Dao.tweetDao;
import com.tweetapp.models.tweetModel;
import com.tweetapp.models.userModel;

public class tweetPost {
	public void PostTweetTemplate(userModel user) {
		Scanner sc =new Scanner(System.in);
		tweetModel tModel=new tweetModel();
		tModel.setTweetmsg(sc.nextLine());
		tModel.setUserId(user.getUserId());
		tweetDao tDao=new tweetDao();
		tDao.addTweet(tModel);
	}
}