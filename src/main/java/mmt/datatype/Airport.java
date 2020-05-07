package mmt.datatype;

import javax.inject.Named;

@Named
public class Airport {
	
	private String city;
	private String state;
	private double latitude;
	private double longitude;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Airport [city=" + city + ", state=" + state + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
	

}
