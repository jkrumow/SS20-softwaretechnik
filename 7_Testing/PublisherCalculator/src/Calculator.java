import java.io.FileNotFoundException;
import java.io.IOException;

public class Calculator {

	private TextParser textParser;
	private double tariff;

	public Calculator(double tariff, TextParser textParser) {
		this.tariff = tariff;
		this.textParser = textParser;
	}

	public double getRoyalties(String path)
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {
		int count = this.textParser.countCharacters(path);
		return count * this.tariff;
	}

	public int countPictures(String path)
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {

		return this.textParser.countPictures(path);
	}
}
