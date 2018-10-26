package utill;
/*
@shubsing
This class is used to Push the XML to Dash board.
*/
import java.io.FileReader;
import java.io.BufferedReader;
import java.net.URL;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.InputStream;


public class PushData {
	public static void main(String[] args) {
		System.out.println("In main");
	}
	
	public String readFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			br.close();
			return sb.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}

	}

	public String sendData(String xmlContent) {
		URL url;
		HttpURLConnection connection = null;
		// xmlContent = "Hello I am post data.";
		try {
			// Create connection
			
				url = new URL("http://flashresults.corp.adobe.com/fpresult/push/pushresult/");
			
			
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			// connection.setRequestProperty("Content-Type",
			// "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(xmlContent.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(xmlContent);
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}

			rd.close();
			System.out.println(response.toString());
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}

	}
}
