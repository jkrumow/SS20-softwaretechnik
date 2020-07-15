import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AircraftState {

	public ACDMStatus getACDMStatus() {
		try {
			URL url = new URL("https://acdmstatus.cargovillage.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			connection.disconnect();
		} catch (Exception e) {
			System.out.print(e);
			return ACDMStatus.NONE;
		}

		return ACDMStatus.NONE;
	}
}
