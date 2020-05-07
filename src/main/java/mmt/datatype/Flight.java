package mmt.datatype;

import javax.inject.Named;

@Named
public class Flight {
	
	private String flightNo;
	private String toCity;
	private String fromCity;
	private String fromTime;
	private String toTime;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", toCity=" + toCity + ", fromCity=" + fromCity + ", fromTime="
				+ fromTime + ", toTime=" + toTime + "]";
	}

	
}
