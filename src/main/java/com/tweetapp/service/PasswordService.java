package com.tweetapp.service;

import java.util.List;
import java.util.Scanner;

import com.tweetapp.Dao.userDao;
import com.tweetapp.models.userModel;

public class PasswordService {

	public void PasswordReset(userModel user) {
		Scanner sc=new Scanner(System.in);
		userDao uDao=new userDao();
		do{
			System.out.println("Please enter new password");
			user.setPassword(sc.nextLine());
		 } while(user.getPassword()==""|| user.getPassword().isEmpty());
//		sc.close();
		uDao.ResetPassword(user);
	}
	public void ForgotPassword() {
		Scanner sc=new Scanner(System.in);
		userModel user=new userModel();
		do{
			System.out.println("Please enter username");
			user.setEmailId(sc.nextLine());
		 } while(user.getEmailId()==""|| user.getEmailId().isEmpty());
		do{
			System.out.println("Please enter first name");
			user.setFirstName(sc.nextLine());
		 } while(user.getFirstName()==""|| user.getFirstName().isEmpty());
		user=UserNameAndFirstNameValidate(user);
		if(user!=null) {
			PasswordReset(user);
		}
		else
		System.out.println("Invalid data\n");
	}
	public userModel UserNameAndFirstNameValidate(userModel user) {
		userDao uDao=new userDao();
		List <userModel>userList =uDao.getUser();
		for(userModel u:userList) {
			if((u.getFirstName().equalsIgnoreCase(user.getFirstName()))
					&&(u.getEmailId().equalsIgnoreCase(user.getEmailId()))) {
				return u;
			}
		}
		return null;
	}
}
