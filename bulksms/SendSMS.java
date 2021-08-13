package bulksms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendSMS {

	public static void main(String[] args) {
	    try {
            // Construct data
            String apiKey = "apikey=" + "MzY3MjY2NjIzNjY0Mzc1YTMxNDQzMjQ5Njc2NTY1NjM=";
            String message = "message=" + "Greetings from Harris Info TECH!";
            String numbers = "numbers=" + "8072946976";
 
            // Send data
            HttpURLConnection  conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message ;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
             
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            System.out.println(stringBuffer.toString());
            rd.close();
 
 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
	}