package com.tweetapp.service;

import java.util.List;
import java.util.Scanner;
import java.sql.Date;
import com.tweetapp.Dao.userDao;
import com.tweetapp.models.userModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registerService {
	public boolean registerTemplate() {
		Scanner sc =new Scanner(System.in);
		userModel user =new userModel();
		do{
			System.out.println("please enter First Name\n");
			user.setFirstName(sc.nextLine());
		 } while(user.getFirstName()==""|| user.getFirstName().isEmpty());
		
		System.out.println("please enter Last Name\n");
		user.setLastName(sc.nextLine());
		do{
			System.out.println("Please enter gender\n");
			user.setGender(sc.nextLine());
		 } while(user.getGender()==""|| user.getGender().isEmpty()||(!user.getGender().toLowerCase().equals("f")
				 &&!user.getGender().toLowerCase().equals("m")));
		
		boolean valiadDate=false;
		do {
			System.out.println("Please enter dob:'DD-MM-YYYY'\n");
			String[] input_date=sc.nextLine().split("-");
			String date1=input_date[2]+"-"+input_date[1]+"-"+input_date[0];
			try {
				Date date=Date.valueOf(date1);
			      user.setDob(date);
			      valiadDate=false;
			} catch (Exception e) {
				if (input_date!=null)
					valiadDate=true;
				user.setDob(null);
			} 
		}while (valiadDate);
			System.out.println("Please enter email\n");
		do{
			valiadDate=true;
			user.setEmailId(sc.nextLine());
			String regexString="^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                    "[a-zA-Z0-9_+&*-]+)*@" + 
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                    "A-Z]{2,7}$"; 
			Pattern pat = Pattern.compile(regexString);
			if (user.getEmailId()==null||user.getEmailId().isEmpty())
				System.out.println(" Please enter email\n");
			else if(!checkUserExists(user))
				System.out.println(user.getEmailId()+" is taken please try somethings else\n");
			else if(!pat.matcher(user.getEmailId()).matches())
				System.out.println(user.getEmailId()+" is invaild \n");
			else {
				valiadDate=false;
			}
		 } while(valiadDate);
		
		System.out.println("Please enter Password\n");
		user.setPassword(sc.nextLine());
		userDao uDao =new userDao();
		if(uDao.registerUser(user)) {
			System.out.println("user is succefully registerd.\n please login to continue.\n________________________________________________________________\n");
			return true;
		}
		else{
			System.out.println("userId is already exist.\n Try with new username.\n");
		}
		return false;
		
	}
	public boolean checkUserExists(userModel user) {
		userDao uDao=new userDao();
		List <userModel>userList =uDao.getUser();
		for(userModel u:userList) {
			if (u.getEmailId()==user.getEmailId())
				return false;
		}
		return true;
	}

}
