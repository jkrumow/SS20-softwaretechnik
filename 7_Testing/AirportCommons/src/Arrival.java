import java.util.Date;

public class Arrival extends Flight {

	private Date onb;
	private Date sta;
	private Date eta;
	private Date ata;

	public Arrival(String flightNo, Date sta, Date onb) {
		super(flightNo);
		this.sta = sta;
		this.onb = onb;
	}

	public Date getOnb() {
		return onb;
	}

	public void setOnb(Date onb) {
		this.onb = onb;
	}

	public Date getSta() {
		return sta;
	}

	public void setSta(Date sta) {
		this.sta = sta;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Date getAta() {
		return ata;
	}

	public void setAta(Date ata) {
		this.ata = ata;
	}

	@Override
	public void setAircraft(Aircraft aircraft) {
		super.setAircraft(aircraft);
		this.aircraft.setArrival(this);
	}
}
