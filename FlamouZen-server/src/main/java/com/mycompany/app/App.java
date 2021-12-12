package com.mycompany.app;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
// import java.net.Socket;

import com.mycompany.IOConnect;

/**
 * Hello world!
 *
 */
public class App
{
    private static int port;

    public static void main(String[] args)
    {
        System.out.println("Initialization du serveur de communication");
        port = args.length > 0 ? Integer.parseInt(args[0]) : 4000;
        IOConnect ioConnect = new IOConnect(port);

        System.out.println("Connection créée.");
        ioConnect.start();
    }

    // private static void _communication(Socket client)
    // {
    //     if(client == null)
    //     {
    //         System.err.println(("No one want to speak with you"));
    //         return;
    //     }

    //     try
    //     {
    //         PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    //         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    //         String userInput;

    //         while((userInput = in.readLine()) != null)
    //         {
    //             out.println(userInput);
    //             System.out.println(userInput);
    //         }
    //     }
    //     catch(IOException error)
    //     {
    //         System.err.println((error.getMessage()));
    //     }
    // }
}