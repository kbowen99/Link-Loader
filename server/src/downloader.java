import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class downloader {
	
	/**
	 * Checks whether or not the string is in a "Challenge" format
	 * @param maybeChallenge What to check
	 * @return if it is a challenge
	 */
	public static boolean containsChallenge(String maybeChallenge){
		return (maybeChallenge.contains(":"));
	}
	
	/**
	 * @param Challenge String to get file name from
	 * @return file name
	 */
	private static String getFileName(String Challenge){
		return (String) P(Challenge.substring(0, Challenge.indexOf(":")));
	}
	
	/**
	 * @param Challenge String to get file URL from
	 * @return File URL
	 */
	private static String getFileURL(String Challenge){
		return (String) P(Challenge.substring((Challenge.indexOf(":") + 1)));
	}
	
	/**
	 * Safely Downloads file as specified in challenge
	 * @param Challenge file specifications
	 */
	public static void challengeDownload(String Challenge){
		try{
			saveURL(getFileName(Challenge), getFileURL(Challenge));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Does all the hard work of downloading the file
	 * @param filename What to save the file as
	 * @param urlString Where to get the file from
	 * @throws MalformedURLException Messed Up URL
	 * @throws IOException Bad File System
	 */
	public static void saveURL(final String filename, final String urlString)
	        throws MalformedURLException, IOException {
	    BufferedInputStream in = null;
	    FileOutputStream fout = null;
	    try {
	        in = new BufferedInputStream(new URL(urlString).openStream());
	        fout = new FileOutputStream(filename);
	
	        final byte data[] = new byte[1024];
	        int count;
	        while ((count = in.read(data, 0, 1024)) != -1) {
	            fout.write(data, 0, count);
	        }
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	        if (fout != null) {
	            fout.close();
	        }
	    }
	}
	
	/**
	 * Lazy Printing
	 * @param p Object to Print
	 * @return Passed Object
	 */
	private static Object P(Object p){
		System.out.println(p.toString()); return p;
	}
}
