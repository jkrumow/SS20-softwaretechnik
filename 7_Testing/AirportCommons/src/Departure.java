import java.util.Date;

public class Departure extends Flight {

	private Date ofb;
	private Date std;
	private Date etd;
	private Date atd;

	public Departure(String flightNo, Date ofb, Date std) {
		super(flightNo);
		this.ofb = ofb;
		this.std = std;
	}

	public Date getOfb() {
		return ofb;
	}

	public void setOfb(Date ofb) {
		this.ofb = ofb;
	}

	public Date getStd() {
		return std;
	}

	public void setStd(Date std) {
		this.std = std;
	}

	public Date getEtd() {
		return etd;
	}

	public void setEtd(Date etd) {
		this.etd = etd;
	}

	public Date getAtd() {
		return atd;
	}

	public void setAtd(Date atd) {
		this.atd = atd;
	}

	@Override
	public void setAircraft(Aircraft aircraft) {
		super.setAircraft(aircraft);
		this.aircraft.setDeparture(this);
	}
}
