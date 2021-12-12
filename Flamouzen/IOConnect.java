import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class IOConnect
{
    private int port = 4000;

    private ServerSocket serverSocket;
    private Socket client;

    public IOConnect(int port)
    {
        this.port = port;
        initializeServerSocket();
    }

    public IOConnect()
    {
        initializeServerSocket();
    }

    private void initializeServerSocket()
    {
        try
        {
            serverSocket = new ServerSocket(port);
            client = serverSocket.accept();
        }
        catch(IOException error)
        {
            System.out.println(error.getMessage());
        }
    }

    public void reset()
    {
        this.initializeServerSocket();
    }

    public void closeServerSocket()
    {
        try
        {
            serverSocket.close();
            serverSocket = null;
        }
        catch(IOException error)
        {
            System.err.println(error.getMessage());
        }
    }

    public ServerSocket getServerSocket()
    {
        return serverSocket;
    }

    public Socket getClient()
    {
        return client;
    }

    public int getPort()
    {
        return port;
    }
}
