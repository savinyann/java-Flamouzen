package com.mycompany;

import java.util.ArrayList;

public class UserManager
{
	private static final ArrayList<ClientSocket> _users = new ArrayList<ClientSocket>();

	public static void addUser(ClientSocket user)
	{
		System.out.println("Adding user to user pool");
		UserManager._users.add(user);
		user.start();
	}

	public static void sendMessage(ClientSocket sender, String message)
	{
		System.out.println("message received: " + message);
		for(ClientSocket user: UserManager._users)
		{
			if(!user.equals(sender))
				user.sendMessage(message);
		}
	}
}