package com.mycompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.mycompany.error.ErrorHandler;

public class ClientSocket extends Thread
{
	private int _port;
	// private String _username;
	private ServerSocket _socket;
	private Socket _client;

	private PrintWriter _out;
	private BufferedReader _in;

	public ClientSocket(int port)
	{
		this._port = port;
		this._initializeClientSocket();
	}

	private void _initializeClientSocket()
	{
		try
		{
			this._socket = new ServerSocket(this._port);
			this._client = this._socket.accept();

			this._out = new PrintWriter(this._client.getOutputStream(), true);
			this._in = new BufferedReader(new InputStreamReader(this._client.getInputStream()));

		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	public void run()
	{
		String message;

		try
		{
			while((message = this._in.readLine()) != null)
				UserManager.sendMessage(this, message);
		}
		catch(IOException error)
		{
			this._handleError(error);
		}
	}

	public void close()
	{
		try
		{
			this._client.close();
			this._socket.close();
			this._out.close();
			this._in.close();
			this._client = null;
			this._socket = null;
			this._out = null;
			this._in = null;
		}
		catch(IOException error)
		{
			this._handleError(error);
		}
		Thread.currentThread().interrupt();
	}

	public Socket getClientSocket()
	{
		return this._client;
	}

	public void sendMessage(String message)
	{
		this._out.println(message);
	}

	public BufferedReader receiveMessage()
	{
		return this._in;
	}

	private void _handleError(Exception error)
	{
		ErrorHandler.handle(error);
	}

	public int getPort() { return this._port; }
}
