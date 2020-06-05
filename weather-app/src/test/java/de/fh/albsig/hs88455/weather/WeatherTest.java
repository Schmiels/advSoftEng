package de.fh.albsig.hs88455.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Test class for testing the WeatherClass.
 * 
 * @author svenb
 */
public class WeatherTest {	
	
	private Weather weatherMock;
	
	private Weather weather;

	/**
	 * Test method for {@link de.fh.albsig.hs88455.weather.Weather#toXML()}.
	 */
	@Test
	public void testToXML() {
		this.weatherMock = Mockito.mock(Weather.class);
		String filePath = "example.xml";
		String expectedOutput = "";
		
		try {
			
			ClassLoader classLoader = this.getClass().getClassLoader();
			File file = new File(classLoader.getResource(filePath).getFile());
			System.out.println(file.toString());
			
			expectedOutput = Files.readString(Paths.get(file.toString()));
			
			Mockito.when(this.weatherMock.toXML()).thenReturn(expectedOutput);
			
			this.weather = new Weather();
			this.weather.setCityId(2945024);
			this.weather.setCityName("Braunschweig");
			this.weather.setCountryCode("DE");
			this.weather.setWeatherDesc("broken clouds");
			this.weather.setTemp(290.12);
			this.weather.setTempMax(290.37);
			this.weather.setTempMin(289.82);
			this.weather.setHumidity(48);
			this.weather.setPressure(1021);
			this.weather.setSunrise(1591066889);
			this.weather.setSunset(1591126242);
			this.weather.setLon(10.53);
			this.weather.setLat(52.27);
			this.weather.setWindDeg(360);
			this.weather.setWindSpeed(1.5);
			
			assertEquals(this.weatherMock.toXML(), this.weather.toXML());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
