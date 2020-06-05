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
 * Class for holding weather data and displaying it as xml
 * 
 * @author Sven Bartos
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
	
	/**
	 * Weather class constructor
	 */
	public Weather() {
		
	}

	/**
	 * Getter method for returning a weather object's cityId attribute.
	 * 
	 * @return cityId | integer value to identify the city 
	 */
	public int getCityId() {
		return cityId;
	}

	/**
	 * Setter method for setting a weather object's cityId attribute.
	 * 
	 * @param cityId | integer value
	 */
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	/**
	 * Getter method for returning a weather object's cityName attribute.
	 * 
	 * @return cityName | city's name as a String
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Setter method for setting a weather object's cityName attribute.
	 * 
	 * @param cityName | String value
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * Getter method for returning a weather object's countryCode attribute.
	 * 
	 * @return countryCode | international country code displaying the country the
	 * city is located in as a String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Setter method for setting a weather object's countryCode attribute.
	 * 
	 * @param countryCode | String value
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Getter method for returning a weather object's weatherDesc attribute.
	 * 
	 * @return weatherDesc | short description for the current weather situation as 
	 * a String
	 */
	public String getWeatherDesc() {
		return weatherDesc;
	}

	/**
	 * Setter method for setting a weather object's weatherDesc attribute.
	 * 
	 * @param weatherDesc | String value
	 */
	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}

	/**
	 * Getter method for returning a weather object's temp attribute.
	 * 
	 * @return temp | current temperature for the queried city as a double
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * Setter method for setting a weather object's weatherDesc attribute.
	 * 
	 * @param temp | double value
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * Getter method for returning a weather object's tempMax attribute.
	 * 
	 * @return tempMax | maximum temperature on the queried day as a double
	 */
	public double getTempMax() {
		return tempMax;
	}

	/**
	 * Setter method for setting a weather object's tempMax attribute.
	 * 
	 * @param tempMax | double value
	 */
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	/**
	 * Getter method for returning a weather object's tempMin attribute.
	 * 
	 * @return tempMin | minimum temperature on the queried day as a double
	 */
	public double getTempMin() {
		return tempMin;
	}

	/**
	 * Setter method for setting a weather object's tempMin attribute.
	 * 
	 * @param tempMin | double value
	 */
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	/**
	 * Getter method for returning a weather object's humidity attribute.
	 * 
	 * @return humidity | integer value for the queried city
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * Setter method for setting a weather object's humidity attribute.
	 * 
	 * @param humidity | integer value
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	/**
	 * Getter method for returning a weather object's pressure attribute.
	 * 
	 * @return pressure | integer value for the air pressure in the queried city
	 */
	public int getPressure() {
		return pressure;
	}

	/**
	 * Setter method for setting a weather object's pressure attribute.
	 * 
	 * @param pressure | integer value
	 */
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	/**
	 * Getter method for returning a weather object's sunrise attribute.
	 * 
	 * @return sunrise | information about the queried city's sunrise time
	 */
	public Date getSunrise() {
		return sunrise;
	}

	/**
	 * Setter method for setting a weather object's sunrise attribute.
	 * 
	 * @param sunrise | Date
	 */
	public void setSunrise(int sunrise) {
		this.sunrise = new Date(sunrise);
	}

	/**
	 * Getter method for returning a weather object's sunset attribute.
	 * 
	 * @return sunset | information about the queried city's sunset time
	 */
	public Date getSunset() {
		return sunset;
	}

	/**
	 * Setter method for setting a weather object's sunset attribute.
	 * 
	 * @param sunset | Date
	 */
	public void setSunset(int sunset) {
		this.sunset = new Date(sunset);
	}

	/**
	 * Getter method for returning a weather object's lon attribute.
	 * 
	 * @return lon | city's longitude as a double
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Setter method for setting a weather object's lon attribute.
	 * 
	 * @param lon | double value
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Getter method for returning a weather object's lat attribute.
	 * 
	 * @return lat | city's latitude as a double
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Setter method for setting a weather object's lat attribute.
	 * 
	 * @param lat | double value
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * Getter method for returning a weather object's windDeg attribute.
	 * 
	 * @return | integer value for the current wind degree
	 */
	public int getWindDeg() {
		return windDeg;
	}

	/**
	 * Setter method for setting a weather object's lat attribute.
	 * 
	 * @param windDeg | integer value
	 */
	public void setWindDeg(int windDeg) {
		this.windDeg = windDeg;
	}

	/**
	 * Getter method for returning a weather object's windSpeed attribute.
	 * 
	 * @return | current wind speed as a double
	 */
	public double getWindSpeed() {
		return windSpeed;
	}

	/**
	 * Setter method for setting a weather object's windSpeed attribute.
	 * 
	 * @param | String value
	 */
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	/**
	 * Parsing a weather object into a String that represents an xml document.
	 * 
	 * @return | String value
	 * @throws TransformerException
	 * @throws ParserConfigurationException
	 */
	public String toXML() throws TransformerException, ParserConfigurationException {
		try {
			// Creating initial xml document
			DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element root = doc.createElement("weatherData");
			doc.appendChild(root);

			// Appending attributes to xml document
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
			
			Element windSpeed = doc.createElement("windSpeed");
			windSpeed.appendChild(doc.createTextNode(this.getWindSpeed()+""));
			wind.appendChild(windSpeed);
			
			// Transforming xml document
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
