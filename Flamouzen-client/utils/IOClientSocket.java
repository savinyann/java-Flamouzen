package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import Class.InputStream.ClientInput;
import Class.InputStream.ServerInput;

public class IOClientSocket
{
    private static final String DEFAULT_USERNAME = "Anonymous_";
    private static final String HOSTNAME = "localhost";

    private String _username;
    private int _port;
    private Socket _socket;
    private PrintWriter _out;
    private ClientInput _clientIn;
    private ServerInput _serverIn;

    public IOClientSocket(int port, String username) throws IOException
    {
        this._port = port;
        this._username = username;
        this._initializeSocket();
    }

    public IOClientSocket(int port) throws IOException
    {
        this._port = port;
        this._username = IOClientSocket.DEFAULT_USERNAME + this._port;
        this._initializeSocket();
    }

    private void _initializeSocket() throws IOException
    {
        this._socket = new Socket(IOClientSocket.HOSTNAME, this._port);
        this._out = new PrintWriter(this._socket.getOutputStream(), true);
        this._clientIn = new ClientInput(System.in, this._out, this);
        this._serverIn = new ServerInput(this._socket.getInputStream(), this);

        this._clientIn.start();
        this._serverIn.start();

        System.out.println("Connecté en temps que \"" + this._username + "\".");
        this.prompt();
    }

    public void prompt()
    {
        System.out.print(this._username + "> ");
    }
}