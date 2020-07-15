import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CalculatorTest {

	private Calculator calculator;

	@Mock
	TextParser mockTextParser;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		calculator = new Calculator(1.0, new TextParser());
	}

	@Test
	public void testNoPath()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Path can not be null!");
		calculator.getRoyalties(null);
	}

	@Test
	public void testInvalidPath()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		exception.expect(FileNotFoundException.class);
		calculator.getRoyalties("./fixtures/nonexistent.txt");
	}

	@Test
	public void testEmptyText()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		double royalties = calculator.getRoyalties("./fixtures/empty.txt");
		assertEquals(0.0, royalties, 0);
	}

	@Test
	public void testSpaceText()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		double royalties = calculator.getRoyalties("./fixtures/space.txt");
		assertEquals(1.0, royalties, 0);
	}

	@Test
	public void testShortText()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		double royalties = calculator.getRoyalties("./fixtures/short.txt");
		assertEquals(3.0, royalties, 0);
	}

	@Test
	public void testLongText()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		double royalties = calculator.getRoyalties("./fixtures/long.txt");
		assertEquals(46.0, royalties, 0);
	}

	@Test
	public void testMaximumTextSize()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {

		calculator = new Calculator(1.0, mockTextParser);

		// using mock parser because we do not want to create a 2GB text file
		when(mockTextParser.countCharacters("./fixtures/huge.txt")).thenReturn(2147483584);

		double royalties = calculator.getRoyalties("./fixtures/huge.txt");
		assertEquals(2147483584.0, royalties, 0);
	}

	@Test
	public void testHugeText()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {

		calculator = new Calculator(1.0, mockTextParser);

		// using mock parser because we do not want to create a 2GB text file
		when(mockTextParser.countCharacters("./fixtures/huge.txt")).thenThrow(IllegalStateException.class);

		exception.expect(IllegalStateException.class);
		calculator.getRoyalties("./fixtures/huge.txt");
	}

	@Test
	public void testCounNoPictures() throws FileNotFoundException, IOException {
		int count = calculator.countPictures("./fixtures/nopicture.txt");
		assertEquals(count, 0);
	}

	@Test
	public void testCounOnePicture() throws FileNotFoundException, IOException {
		int count = calculator.countPictures("./fixtures/onepicture.txt");
		assertEquals(count, 1);
	}

	@Test
	public void testCounManyPictures() throws FileNotFoundException, IOException {
		int count = calculator.countPictures("./fixtures/manypictures.txt");
		assertEquals(count, 3);
	}

	@Test
	public void testCounOnlyPictures() throws FileNotFoundException, IOException {
		int count = calculator.countPictures("./fixtures/onlypictures.txt");
		assertEquals(count, 8);
	}

	@Test
	public void testCounBrokenPictures() throws FileNotFoundException, IOException {
		int count = calculator.countPictures("./fixtures/brokenpictures.txt");
		assertEquals(count, 0);
	}

	@Test
	public void testCountPicturesInHugeFile()
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		calculator = new Calculator(1.0, mockTextParser);

		// using mock parser because we do not want to create a 2GB text file
		when(mockTextParser.countPictures("./fixtures/huge.txt")).thenThrow(IllegalStateException.class);

		exception.expect(IllegalStateException.class);
		calculator.countPictures("./fixtures/huge.txt");
	}
}
