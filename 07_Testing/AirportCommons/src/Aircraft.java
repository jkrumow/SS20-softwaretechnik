public class Aircraft {

	private String registration;
	private String type;
	private String spanCode;
	private String icaoCode;

	private AircraftState aircraftState;

	private Arrival arrival;
	private Departure departure;

	public Aircraft(String registration, String type, String spanCode, String icaoCode, AircraftState aircraftState) {
		super();
		this.registration = registration;
		this.type = type;
		this.spanCode = type;
		this.icaoCode = icaoCode;
		this.aircraftState = aircraftState;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpanCode() {
		return spanCode;
	}

	public void setSpanCode(String spanCode) {
		this.spanCode = spanCode;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public Arrival getArrival() {
		return arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
		checkValidOnblockDuration();
	}

	public Departure getDeparture() {
		return departure;
	}

	public void setDeparture(Departure departure) {
		this.departure = departure;
		checkValidOnblockDuration();
	}

	public boolean hasStartupGiven() {
		return (this.aircraftState.getACDMStatus() == ACDMStatus.SUG);
	}

	public long getOnblockDuration() {
		return (this.departure.getOfb().getTime() - this.arrival.getOnb().getTime()) / 1000;
	}

	private void checkValidOnblockDuration() {
		if (this.arrival == null || this.departure == null) {
			return;
		}
		if (getOnblockDuration() < 0) {
			throw new IllegalArgumentException("Onblock time must not be negative!");
		}
	}
}
