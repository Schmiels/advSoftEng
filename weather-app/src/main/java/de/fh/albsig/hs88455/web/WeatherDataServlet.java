package de.fh.albsig.hs88455.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, IOException {
		
		String cityName = req.getParameter("cityName");
		
		WeatherService weatherService = new WeatherService();
		
		JSONObject jsonObj = weatherService.getDataByCityName(cityName);
		
		//System.out.println(jsonObj.toString(100));
		
		Weather weather = new Weather(cityName);
		
		JSONObject main = (JSONObject) jsonObj.get("main");
		JSONObject sys = (JSONObject) jsonObj.get("sys");
		JSONObject coord = (JSONObject) jsonObj.get("coord");
		JSONObject weatherData = (JSONObject) jsonObj.get("weather");
		JSONObject wind = (JSONObject) jsonObj.get("wind");
		
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
		weather.setLat(coord.getDouble("sunset"));
		weather.setWindDeg(wind.getInt("deg"));
		weather.setWindSpeed(wind.getDouble("speed"));
		
		PrintWriter output = resp.getWriter();
		
		//weather.toxml
		//output.println(weather.toXML);
		
		
		
	}
}
