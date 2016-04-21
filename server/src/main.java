import javax.swing.JOptionPane;

public class main {

	private static String password;
	public static void main(String[] args) {
		password = JOptionPane.showInputDialog("Server Password");
		System.out.println("Server Running");
		System.out.println("Server Password is: " + password);
		new server().start();
	}
	
	public static String getPass(){
		return password;
	}
}
