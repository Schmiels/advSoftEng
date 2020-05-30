package de.fh.albsig.hs88455.weather;

/**
 * Wetter Objekt
 * @author svenb
 *
 */
public class Weather {

	private int cityId;
	private String cityName;
	
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
}
