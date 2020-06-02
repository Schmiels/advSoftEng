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
	
	public Weather() {
		
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
			
			Element general = doc.createElement("general");
			root.appendChild(general);
			
			Element cityName = doc.createElement("cityName");
			cityName.appendChild(doc.createTextNode(this.getCityName()));
			general.appendChild(cityName);
			
			Element cityId = doc.createElement("cityId");
			cityId.appendChild(doc.createTextNode(this.getCityId()+""));
			general.appendChild(cityId);
			
			Element countryCode = doc.createElement("countryCode");
			countryCode.appendChild(doc.createTextNode(this.getCountryCode()));
			general.appendChild(countryCode);
			
			Element sunrise = doc.createElement("sunrise");
			sunrise.appendChild(doc.createTextNode(this.getSunrise().toString()));
			general.appendChild(sunrise);
			
			Element sunset = doc.createElement("sunset");
			sunset.appendChild(doc.createTextNode(this.getSunset().toString()));
			general.appendChild(sunset);
			
			Element coords = doc.createElement("coords");
			root.appendChild(coords);
			
			Element lon = doc.createElement("lon");
			lon.appendChild(doc.createTextNode(this.getLon()+""));
			coords.appendChild(lon);
			
			Element lat = doc.createElement("lat");
			lat.appendChild(doc.createTextNode(this.getLat()+""));
			coords.appendChild(lat);
			
			Element desc = doc.createElement("desc");
			desc.appendChild(doc.createTextNode(this.getWeatherDesc()));
			root.appendChild(desc);
			
			Element temp = doc.createElement("temp");			
			root.appendChild(temp);
			
			Element currentTemp = doc.createElement("currentTemp");
			currentTemp.appendChild(doc.createTextNode(this.getTemp()+""));
			temp.appendChild(currentTemp);
			
			Element maxTemp = doc.createElement("maxTemp");
			maxTemp.appendChild(doc.createTextNode(this.getTempMax()+""));
			temp.appendChild(maxTemp);
			
			Element minTemp = doc.createElement("minTemp");
			minTemp.appendChild(doc.createTextNode(this.getTempMin()+""));
			temp.appendChild(minTemp);
			
			Element humidity = doc.createElement("humidity");
			humidity.appendChild(doc.createTextNode(this.getHumidity()+""));
			root.appendChild(humidity);
			
			Element pressure = doc.createElement("pressure");
			pressure.appendChild(doc.createTextNode(this.getPressure()+""));
			root.appendChild(pressure);
			
			Element wind = doc.createElement("wind");
			root.appendChild(wind);
			
			Element windDeg = doc.createElement("windDeg");
			windDeg.appendChild(doc.createTextNode(this.getWindDeg()+""));
			wind.appendChild(windDeg);
			
			Element windSpped = doc.createElement("windSpped");
			windSpped.appendChild(doc.createTextNode(this.getWindSpeed()+""));
			wind.appendChild(windSpped);
			
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
