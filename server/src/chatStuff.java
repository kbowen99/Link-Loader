import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class chatStuff extends Thread{
	server cs;
	Socket o;
	boolean running = true;
	
	public chatStuff(server chatterServer, Socket outlit) {
	   cs = chatterServer;
	   o = outlit;
	   System.out.println(o.getInetAddress().toString());
	}
	
	
	public boolean onoff() {
		return running;
	}
	public void run() {
		BufferedReader in = getBufferedReader(o);
		while(running) {
			try {
				String message = in.readLine();
				if(message == null) {
					running = false;
				} else {
					//cs.sendMessage(message);
					System.out.println(message);
					System.out.println(downloader.containsChallenge(message));
					if (downloader.containsChallenge(message)){
						downloader.checkPassword(message);
					}
				}
				
			} catch (IOException e) {
				running = false;
			}
		}		
	}
	
	public void sender(String message) {
			PrintWriter out = getPrintWriter(o);
			out.println(message);
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
	
	public static PrintWriter getPrintWriter(Socket clientSocket) {
		try {
		    return new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
}
