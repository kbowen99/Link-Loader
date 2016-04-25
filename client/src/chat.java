import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class chat {

	/**
	 * Runs the "Chat" Protocol
	 * @param address IP address to use
	 * @param port Port used to connect
	 * @param link File to download
	 * @param fileName What to name the file
	 */
	public static void chatRunner(String address, int port, String link, String fileName) {		
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
		
		fileName = fileName.replace(":", "");
		fileName = fileName.replace(" ", "-");
		String Challenge = fileName + ":" + link;

		out.println(Challenge);

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