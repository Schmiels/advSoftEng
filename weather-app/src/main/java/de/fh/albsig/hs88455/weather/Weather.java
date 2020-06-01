package de.fh.albsig.hs88455.weather;

import java.io.StringWriter;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Wetter Objekt
 * @author svenb
 *
 */
public class Weather {

	private int cityId;
	private String cityName;
	private String countryCode;
	private String weatherDesc;
	private double temp;
	private double tempMax;
	private double tempMin;
	private int humidity;
	private int pressure;
	private Date sunrise;
	private Date sunset;
	private double lon;
	private double lat;
	private int windDeg;
	private double windSpeed;
	
	public Weather(String cityName) {
		this.cityName = cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getWeatherDesc() {
		return weatherDesc;
	}

	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = new Date(sunrise);
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(int sunset) {
		this.sunset = new Date(sunset);
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getWindDeg() {
		return windDeg;
	}

	public void setWindDeg(int windDeg) {
		this.windDeg = windDeg;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public String toXML() {
		try {
			DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element root = doc.createElement("weatherData");
			doc.appendChild(root);
			
			Element cityName = doc.createElement("cityName");
			cityName.appendChild(doc.createTextNode(this.getCityName()));
			root.appendChild(cityName);
			
			Element temp = doc.createElement("temp");
			temp.appendChild(doc.createTextNode(this.getTemp()+""));
			root.appendChild(temp);
			
			TransformerFactory transformerFac = TransformerFactory.newInstance();
			Transformer transformer = transformerFac.newTransformer();
			DOMSource transformerSrc = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult transformerRslt = new StreamResult(writer);
			transformer.transform(transformerSrc, transformerRslt);
			
			return writer.getBuffer().toString();
		} catch (TransformerException e) {
			System.out.println(e.toString());
		} catch (ParserConfigurationException e) {
			System.out.println(e.toString());
		}
		
		return null;
	}
}
