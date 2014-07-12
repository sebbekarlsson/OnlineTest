import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Program {




	public static void main(String[] args){

		String choice = JOptionPane.showInputDialog("choose server/client");


		if(choice.equals("server")){
			//We need a try-catch because lots of errors can be thrown
			try {
				
				ServerFrame sf = new ServerFrame();
				
				ServerSocket sSocket = new ServerSocket(25569);
				System.out.println("Server started at: " + new Date());
				sf.writeToConsole("Server started at: " + new Date());

				//Wait for a client to connect
				while(true){
					Socket socket = sSocket.accept();

					ClientThread ct = new ClientThread(socket);
					new Thread(ct).start();
					
					sf.addConnection();
				}
			} catch(IOException exception) {
				System.out.println("Error: " + exception);
			}

		}
		else if(choice.equals("client")){
			//We set up the scanner to receive user input
			
			ClientFrame cf = new ClientFrame();
			Scanner scanner = new Scanner(System.in);
			try {
				Socket socket = new Socket("localhost",25569);
				PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				//This will wait for the server to send the string to the client saying a connection
				//has been made.
				String inputString = input.readLine();
				System.out.println(inputString);
				//Again, here is the code that will run the client, this will continue looking for 
				//input from the user then it will send that info to the server.
				while(true) {
					//Here we look for input from the user
					String userInput = scanner.nextLine();
					//Now we write it to the server
					output.println(userInput);
				}
			} catch (IOException exception) {
				System.out.println("Error: " + exception);
			}
		}
	}

}
