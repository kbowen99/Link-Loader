import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class downloader {

	public static boolean containsChallenge(String maybeChallenge){
		return (maybeChallenge.contains(":"));
	}
	
	private static String getFileName(String Challenge){
		return (String) P(Challenge.substring(0, Challenge.indexOf(":")));
	}
	
	private static String getFileURL(String Challenge){
		return (String) P(Challenge.substring((Challenge.indexOf(":") + 1)));
	}
	
	public static void challengeDownload(String Challenge){
		try{
			saveURL(getFileName(Challenge), getFileURL(Challenge));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
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
	
	private static Object P(Object p){
		System.out.println(p.toString()); return p;
	}
}
