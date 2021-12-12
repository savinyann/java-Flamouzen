import java.io.IOException;

import utils.IOClientConnect;
import utils.IOClientSocket;

public class FlamouzenClient
{
    public static void main(String[] args)
    {
        String username = args.length > 0 ? args[0] : "Anonyme";
        IOClientConnect client = new IOClientConnect();

        try
        {
            final int port = client.connect();
            new IOClientSocket(port, username);
        }
        catch(IOException error)
        {
            System.out.println("Impossible de se connecter au serveur.");
            return;
        }
    }
}