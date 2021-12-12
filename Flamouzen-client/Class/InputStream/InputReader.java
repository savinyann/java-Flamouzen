package Class.InputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import utils.IOClientSocket;

public class InputReader extends Thread
{
	protected BufferedReader _in;
	private IOClientSocket _client;

	public InputReader(InputStream in, IOClientSocket client)
	{
		this._in = new BufferedReader(new InputStreamReader(in));
		this._client = client;
	}

	public void close()
	{
		try
		{
			this._in.close();
			this._client = null;
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}

		Thread.currentThread().interrupt();
	}

	protected IOClientSocket getClient()
	{
		return this._client;
	}
}
