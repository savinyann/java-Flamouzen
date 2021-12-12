package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class IOClientConnect
{
    private static final String HOSTNAME = "localhost";
    private final int CONNEXION_PORT = 4000;

    private Socket socket;
    private BufferedReader in;

    public IOClientConnect() { }

    public int connect() throws IOException
    {
        socket = new Socket(HOSTNAME, CONNEXION_PORT);
        in = new BufferedReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));

        System.out.println("En attente d'allocation d'un port client...");

        final int clientPort = Integer.parseInt(in.readLine());
        System.out.println("Port de connection reçu: " + clientPort);
        socket.close();

        return clientPort;
    }
}
