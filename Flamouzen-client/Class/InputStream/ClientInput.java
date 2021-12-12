package Class.InputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import utils.IOClientSocket;

public class ClientInput extends InputReader
{
	private PrintWriter _out;

	public ClientInput(InputStream in, PrintWriter out, IOClientSocket client)
	{
		super(in, client);
		this._out = out;
	}

	public void run()
	{
		String message;

		try
		{
			while((message = this._in.readLine()) != null)
			{
				this._sendMessage(message);
				this.getClient().prompt();
			}
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}

	private void _sendMessage(String message)
	{
		this._out.println(this.getClient().getPrompt() + message);
	}

	public void close()
	{
		this._out.close();
		super.close();
	}
}
