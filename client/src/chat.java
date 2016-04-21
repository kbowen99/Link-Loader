import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class chat {

	/**
	 * Runs the main chat "protocol"
	 * @param username Username sent to the server
	 * @param address IP Address to use
	 * @param port Port Used to connect
	 */
	public static void chatRunner(String password, String address, int port, String link, String fileName) {		
		Scanner sc = new Scanner(System.in);
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(address, port);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
			System.exit(1);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
		}

		PrintWriter out = getPrintWriter(clientSocket);
		//BufferedReader in = getBufferedReader(clientSocket);
		System.out.println("Connection Successful" );

		out.println("Client Connected!");
		
		String Challenge = "Password:" + password + "!"
						+ " Link:" + link + "#"
						+ " FileName:" + fileName + "$";
		out.println(Challenge);
		
//		new Thread() {
//			public void run() { 
//				boolean running = true;
//				while(running) {
//					try {
//						System.out.println(in.readLine());
//					} catch (IOException e) {
//						running = false;
//					}
//				}
//			}
//		}.start();
		
//		boolean inuse = true;
		//sc.nextLine();
//		while(inuse) {
//			String message = sc.nextLine();
//			out.println(message);
//			if(message.equals("exit")) {
//				inuse = false;
//			}
//		}
		
		sc.close();
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	public static PrintWriter getPrintWriter(Socket clientSocket) {
		try {
		    return new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	public static BufferedReader getBufferedReader(Socket clientSocket) {
		try {
			return new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;			
		}
	}
}