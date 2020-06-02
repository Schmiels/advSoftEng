package de.fh.albsig.hs88455.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * WeatherService bedienen und Daten per XML zur Verfügung stellen
 * @author svenb
 *
 */
public class WeatherDataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384272787556882954L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, IOException {
		
		/*
		 * TODO: Parameterauswertung auf alle Parameter ausweiten
		 */
		String cityName = req.getParameter("cityName");
		
		WeatherService weatherService = new WeatherService();
		
		/*
		 * TODO: Serviceaufruf an ausgeweitete Parameter anpassen
		 */
		JSONObject jsonObj = weatherService.getDataByCityName(cityName);
		
		Weather weather = new Weather();
		weather.setCityName(cityName);
		
		JSONObject main = (JSONObject) jsonObj.get("main");
		JSONObject sys = (JSONObject) jsonObj.get("sys");
		JSONObject coord = (JSONObject) jsonObj.get("coord");
		JSONObject wind = (JSONObject) jsonObj.get("wind");
		
		JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
		JSONObject weatherData = (JSONObject) weatherArray.get(0);
		
		
		weather.setCityId(jsonObj.getInt("id"));
		weather.setCountryCode(sys.getString("country"));
		weather.setWeatherDesc(weatherData.getString("description"));
		weather.setTemp(main.getDouble("temp"));
		weather.setTempMax(main.getDouble("temp_max"));
		weather.setTempMin(main.getDouble("temp_min"));
		weather.setHumidity(main.getInt("humidity"));
		weather.setPressure(main.getInt("pressure"));
		weather.setSunrise(sys.getInt("sunrise"));
		weather.setSunset(sys.getInt("sunset"));
		weather.setLon(coord.getDouble("lon"));
		weather.setLat(coord.getDouble("lat"));
		weather.setWindDeg(wind.getInt("deg"));
		weather.setWindSpeed(wind.getDouble("speed"));
		
		PrintWriter output = resp.getWriter();
		
		//weather.toxml
		output.println(weather.toXML());
		
		
		
	}
}
