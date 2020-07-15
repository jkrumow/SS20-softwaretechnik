import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class AircraftTest {

	private SimpleDateFormat format;
	private Arrival arrival;
	private Departure departure, invalid;
	private Aircraft aircraft;

	@Mock
	AircraftState aircraftState;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws ParseException {
		format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));

		arrival = new Arrival("LH31", format.parse("2020-06-20T10:30:00Z"), format.parse("2020-06-20T10:38:00Z"));
		departure = new Departure("LH32", format.parse("2020-06-20T14:10:00Z"), format.parse("2020-06-20T14:20:00Z"));
		invalid = new Departure("LH666", format.parse("2020-06-20T10:10:00Z"), format.parse("2020-06-20T10:20:00Z"));

		aircraft = new Aircraft("DACNA", "XY", "100", "CLH", aircraftState);
		arrival.setAircraft(aircraft);
		departure.setAircraft(aircraft);
	}

	@Test
	public void testGetOnblockDuration() throws ParseException {
		long onblockDuration = aircraft.getOnblockDuration();
		assertEquals(onblockDuration, 12720);
	}

	@Test
	public void testNegativeSchedule() throws ParseException {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Onblock time must not be negative!");
		invalid.setAircraft(aircraft);
	}

	@Test
	public void testStartupGiven() {
		when(aircraftState.getACDMStatus()).thenReturn(ACDMStatus.SUG);
		assertTrue(aircraft.hasStartupGiven());
	}

	@Test
	public void testStartupNotGiven() {
		when(aircraftState.getACDMStatus()).thenReturn(ACDMStatus.ONB);
		assertFalse(aircraft.hasStartupGiven());
	}

}
