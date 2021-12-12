import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Flamouzen
{
    private static int port;
    public static void main(String[] args)
    {
        port = args.length > 0 ? Integer.parseInt(args[0]) : 4000;
        IOConnect ioConnect = new IOConnect(port);

        communication(ioConnect.getClient());
    }

    private static void communication(Socket client)
    {
        if(client == null)
        {
            System.err.println("No one want to speak with you");
            return;
        }

        try
        {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch(IOException error)
        {
            System.err.println(error.getMessage());
        }
    }
}