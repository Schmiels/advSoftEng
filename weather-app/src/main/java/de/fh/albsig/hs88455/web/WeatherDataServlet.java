package de.fh.albsig.hs88455.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.JSONArray;
import org.json.JSONObject;

import de.fh.albsig.hs88455.weather.Weather;
import de.fh.albsig.hs88455.weather.WeatherService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(
		name = "weatherdataservlet", 
		urlPatterns = "/WeatherData")

/**
 * Servlet class to perform web requests that are aiming at /WeatherData.
 * Currently performing a post request querying the openweatherapi with
 * the city's Name as a parameter. 
 * 
 * TODO: evaluate all get parameters and perform the request accordingly.
 * 
 * @author svenb
 */
public class WeatherDataServlet extends HttpServlet {

	private static final long serialVersionUID = -6384272787556882954L;

	/**
	 * Method handling a post action aimed at /WeatherData
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, IOException {
		
		String cityName = req.getParameter("cityName");
		
		WeatherService weatherService = new WeatherService();

		// Execute API-call
		JSONObject jsonObj = weatherService.getDataByCityName(cityName);		
		
		JSONObject main = (JSONObject) jsonObj.get("main");
		JSONObject sys = (JSONObject) jsonObj.get("sys");
		JSONObject coord = (JSONObject) jsonObj.get("coord");
		JSONObject wind = (JSONObject) jsonObj.get("wind");		
		JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
		JSONObject weatherData = (JSONObject) weatherArray.get(0);
		
		Weather weather = new Weather();
		
		if (jsonObj.has("id")) {
			weather.setCityId(jsonObj.getInt("id"));
		}
		if (jsonObj.has("name")) {
			weather.setCityName(jsonObj.getString("name"));
		}
		if (sys.has("country")) {
			weather.setCountryCode(sys.getString("country"));
		}
		if (weatherData.has("description")) {
			weather.setWeatherDesc(weatherData.getString("description"));
		} 
		if (main.has("temp")) {
			weather.setTemp(main.getDouble("temp"));
		}
		if (main.has("temp_max")) {
			weather.setTempMax(main.getDouble("temp_max"));
		}
		if (main.has("temp_min")) {
			weather.setTempMin(main.getDouble("temp_min"));
		}
		if (main.has("humidity")) {
			weather.setHumidity(main.getInt("humidity"));
		}
		if (main.has("pressure")) {
			weather.setPressure(main.getInt("pressure"));
		}
		if (sys.has("sunrise")) {
			weather.setSunrise(sys.getInt("sunrise"));
		}
		if (sys.has("sunset")) {
			weather.setSunset(sys.getInt("sunset"));
		}
		if (coord.has("lon")) {
			weather.setLon(coord.getDouble("lon"));
		}
		if (coord.has("lat")) {
			weather.setLat(coord.getDouble("lat"));
		}
		if (wind.has("deg")) {
			weather.setWindDeg(wind.getInt("deg"));
		}
		if (wind.has("speed")) {
			weather.setWindSpeed(wind.getDouble("speed"));
		}
		
		PrintWriter output = resp.getWriter();
		
		// Print Weather object as xml
		try {
			output.println(weather.toXML());	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
