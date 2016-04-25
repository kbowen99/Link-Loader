import javax.swing.JOptionPane;

public class main {

	/**
	 * Does magic
	 * @param args Stuff
	 */
	public static void main(String[] args) {
		String IP = JOptionPane.showInputDialog("IP Address to Use");
		String tmpPort = JOptionPane.showInputDialog("Port to use");
		String urlLink = JOptionPane.showInputDialog("File to Download");
		String fileName = JOptionPane.showInputDialog("What should this file be called?");
		int port = Integer.parseInt(tmpPort);
		IP = (IP.length() > 1 ? IP : "localhost");
		port = (port > 1 ? port : 25563);
		fileName = (fileName.length() > 1 ? fileName : "magic");
		chat.chatRunner(IP, port, urlLink, fileName);
	}
}
