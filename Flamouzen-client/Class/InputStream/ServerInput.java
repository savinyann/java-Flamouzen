package Class.InputStream;
import java.io.IOException;
import java.io.InputStream;

import utils.IOClientSocket;

public class ServerInput extends InputReader
{
	public ServerInput(InputStream in, IOClientSocket client)
	{
		super(in, client);
	}

	public void run()
	{
		String message;

		try
		{
			while((message = this._in.readLine()) != null)
			{
				System.out.print("\r" + message + "\n");
				this.getClient().prompt();
			}
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	public void close()
	{
		super.close();
	}
}
