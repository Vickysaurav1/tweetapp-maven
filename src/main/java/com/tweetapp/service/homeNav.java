package com.tweetapp.service;

import java.util.Scanner;
import com.tweetapp.models.userModel;


public class homeNav {
	private static boolean isloggedIn=false;
	private static boolean isloggout=false;
	public static userModel loggedUser=null;

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		do {
			normalService();
		}while(!isloggedIn);
		do {
			loggedInService();			
		}while(!isloggout);
	}
	public static boolean  normalService() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welocome to Tweet App. Please select one");
		System.out.println(
				"1.Register\n"
				+ "2.Login\n"
				+ "3.Forgot Password"
				);
		int selection=sc.nextInt();
		switch(selection) {
		case 1:
			registerService rs =new registerService();
			rs.registerTemplate();
			normalService();
	    break;
		case 2:
			loginService lS =new loginService();
			
			do {
				loggedUser=lS.loginTemplate();
			}while(loggedUser==null);
			isloggedIn=true;
			
	    break;
		case 3:
			PasswordService pService=new PasswordService();
			pService.ForgotPassword();
			normalService();
	    break;
		default:
			isloggout=false;
			System.out.println("Please enter valid input.");
		}
		return true;
	}
	public static boolean loggedInService() {
		Scanner sc=new Scanner(System.in);
			System.out.println(
					"1. Post a tweet\n "
					+ "2. View my tweets\n"
					+ "3. View all tweets\n"
					+ "4. View All Users\n"
					+ "5. Reset Password\n"
					+ "6. Logout\n"
					+"__________________________________________________________________________"
					);
			int selection=sc.nextInt();
			displayService ds =new displayService();
			switch(selection) {
			case 1:
				tweetPost tPost =new tweetPost();
				tPost.PostTweetTemplate(loggedUser);
				isloggout=false;
		    break;
			case 2:
				ds.DisplayTweets(loggedUser.getUserId());
				isloggout=false;

		    break;
			case 3:
				ds.DisplayTweets();
				isloggout=false;
		    break;
			case 4:
				ds.displayUser();
				isloggout=false;
		    break;
			case 5:
				PasswordService pService=new PasswordService();
				pService.PasswordReset(loggedUser);
				loggedUser=null;
				isloggout=false;
				isloggedIn=false;
				normalService();
				
		    break;
			case 6:
				loginService lService=new loginService();
				lService.logOut(loggedUser);
				isloggout=false;
				loggedUser=null;
				isloggedIn=false;
				normalService();
				sc.close();
		    break;
			default:
				System.out.println("Please enter valid input.\n");
				
		}
		return true;
	}
}

