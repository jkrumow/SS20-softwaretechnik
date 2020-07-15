public class Flight {

	protected Aircraft aircraft;
	protected String flightNo;

	public Flight(String flightNo) {
		super();
		this.flightNo = flightNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Aircraft getAircraft() {
		return this.aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
}
