package com.mycompany;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.mycompany.error.ErrorHandler;

public class IOConnect extends Thread
{
	private int _port = 4000;
	private ServerSocket _serverSocket;
	private Socket _connexionSocket;
	private int _clientPort = this._port;
	private PrintWriter _out;

	public IOConnect(int port)
	{
		this._port = port;
		_initializeServerSocket();
	}

	private void _initializeServerSocket()
	{
		try
		{
			this._serverSocket = new ServerSocket(_port);
		}
		catch(IOException error)
		{
			ErrorHandler.handle(error);
		}
	}

	public void run()
	{
		while(true)
		{
			try
			{
				this._connexionSocket = this._serverSocket.accept();
				// System.out.println("Reception d'une nouvelle connextion");

				this._out = new PrintWriter(this._connexionSocket.getOutputStream(), true);
				this._acceptUser();

				// System.out.println("Et c'est reparti pour un tour !");
			}
			catch(IOException error)
			{
				ErrorHandler.handle(error);
			}
		}
	}

	private void _acceptUser()
	{
		this._clientPort++;
		// System.out.println("Allocation du port " + this._clientPort + " pour le nouvel utilisateur");
		this._out.println(this._clientPort);
		final ClientSocket user = new ClientSocket(this._clientPort);
		this._out = null;
		this._connexionSocket = null;

		UserManager.addUser(user);
	}

	private void _closeServerSocket()
	{
		try
		{
			_serverSocket.close();
			_serverSocket = null;
		}
		catch(IOException error)
		{
			System.err.println(error.getMessage());
		}
	}

	public ServerSocket getServerSocket()
	{
		return _serverSocket;
	}

	public Socket getClient()
	{
		return _connexionSocket;
	}

	public int getPort()
	{
		return _port;
	}

	public void close()
	{
		this._closeServerSocket();
		Thread.currentThread().interrupt();
	}
}