import java.io.BufferedReader;
import java.time.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;


public class CalculateSunTime {

	public static void main(String[] args) {
		try {
			weatherData(43.071974,-89.387191);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static double weatherData(double lat, double lon) throws IOException, MalformedURLException {

		String locationUrl = "http://dataservice.accuweather.com/locations/v1/cities/"
				+ "geoposition/search?apikey=qAV3nAnWDhGyKRWoiDcbgsg2P2EeYxed&q=" + lat + "," + lon;

		URL url = new URL(locationUrl);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		String locationKey;
		
		StringBuffer content = null;
		
//		System.out.println(status);
		if (status == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
		}
		
//		System.out.println(content);
		
		// get index of K to find the index of the key. Add 6 to it. Then get the substring from that character to that plus 6."
		
		int index = content.indexOf("K");
		
		index = index + 6;
		
		locationKey = content.substring(index, index+6);
		
		System.out.println("Location Key: " + locationKey);
		
		// need to print cloud cover, time of day, sunset/sunrise"
		
		// FIND WEATHER DATA
		
		String weatherUrl = "http://dataservice.accuweather.com/currentconditions/v1/"
				+ locationKey + "?apikey=qAV3nAnWDhGyKRWoiDcbgsg2P2EeYxed&details=true";

		url = new URL(weatherUrl);

		con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("GET");

		status = con.getResponseCode();
		
		content = null;
		
		System.out.println(status);
		if (status == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
		}
		
		System.out.println(content);
		
		DateTime dt = new DateTime(content.substring(30,55));
		
		
		System.out.println("Local Date/Time: " + dt);
		
		String cloudCover = content.substring(content.indexOf("CloudCover")+12,content.indexOf("CloudCover")+14);
		
		System.out.println("Cloud Cover: " + cloudCover);
		
		// next steps are to get sunset/sunrise time, and calculate minutes based on that need to spend outside.


		return 0.0;
	}

}
