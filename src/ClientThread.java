import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;


public class ClientThread implements Runnable {
	 Socket threadSocket;
     
     //This constructor will be passed the socket
     public ClientThread(Socket socket)
     {
         //Here we set the socket to a local variable so we can use it later
         threadSocket = socket;
     }
      
     public void run()
     {
         //All this should look familiar
         try {
             //Create the streams
             PrintWriter output = new PrintWriter(threadSocket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(threadSocket.getInputStream()));
              
             //Tell the client that he/she has connected
             output.println("You have connected at: " + new Date());
              
             while (true) {
                 //This will wait until a line of text has been sent
                 String chatInput = input.readLine();
                 System.out.println(chatInput);
             }
         } catch(IOException exception) {
             System.out.println("Error: " + exception);
         }
     }
}
