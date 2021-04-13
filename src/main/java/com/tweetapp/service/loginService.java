package com.tweetapp.service;

import java.util.List;
import java.util.Scanner;

import com.tweetapp.Dao.userDao;
import com.tweetapp.models.userModel;

public class loginService {
	public userModel loginTemplate() {
		Scanner sc=new Scanner(System.in);
		userModel user=new userModel();
		do{
			System.out.println("Please enter username\n");
			user.setEmailId(sc.nextLine());
		 } while(user.getEmailId()==""|| user.getEmailId().isEmpty());
		do{
			System.out.println("Please enter password\n");
			user.setPassword(sc.nextLine());
		 } while(user.getPassword()==""|| user.getPassword().isEmpty());
		userModel result=login(user);
		return result;
	}
	public userModel login(userModel user) {
		userDao uDao=new userDao();
		List <userModel>userList =uDao.getUser();
		for(userModel u:userList) {
			if((u.getEmailId().equalsIgnoreCase(user.getEmailId()))
					&&(u.getPassword().equals(user.getPassword()))) {
				try {
					u.setLoggedIn(1);
					uDao.UpdateLogin(u);
					return u;
				} catch (Exception e) {
					return u;
				}
			}
		}
		return null;
	}
	public void logOut(userModel user) {
		userDao uDao=new userDao();
		user.setLoggedIn(0);
		uDao.UpdateLogin(user);
	}

}
