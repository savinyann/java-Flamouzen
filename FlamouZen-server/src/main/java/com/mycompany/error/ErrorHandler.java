package com.mycompany.error;

public class ErrorHandler
{
	public static void handle(Exception error)
	{
		System.out.println(error.getMessage());
	}
}