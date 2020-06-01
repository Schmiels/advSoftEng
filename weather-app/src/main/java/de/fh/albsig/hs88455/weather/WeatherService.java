package de.fh.albsig.hs88455.weather;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Weather-Api anfragen
 * @author svenb
 *
 */
public class WeatherService {
	
	private String apiKey = "0faf94f3aa783dbf3030947b5c36cf41";

	public WeatherService() {
		
	}
	
	public JSONObject getDataByCityName(String cityName) {
		
		String url;
		String respBody;
		
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http");
		builder.setHost("api.openweathermap.org");
		builder.setPath("/data/2.5/weather");
		builder.addParameter("q", cityName);
		builder.addParameter("appid", this.getApiKey());
		
		url = builder.toString();
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		try {
			HttpGet get = new HttpGet(url);
			//System.out.println(url);
			CloseableHttpResponse resp = httpClient.execute(get);
			//System.out.println(resp);
			respBody = EntityUtils.toString(resp.getEntity(), StandardCharsets.UTF_8);
			
			resp.close();
			
			JSONObject jsonObj = new JSONObject(respBody);
			
			return jsonObj;
			//System.out.println(jsonObj);
		} catch (ClientProtocolException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		return new JSONObject();
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
