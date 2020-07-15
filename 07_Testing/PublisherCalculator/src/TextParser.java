import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

interface Operation {
	int count(String line);
}

public class TextParser {

	private final String picture = "<Picture>";

	public int countCharacters(String path) throws FileNotFoundException, IOException, IllegalStateException {

		Operation characters = (line) -> {
			return line.length();
		};

		return parseLines(path, characters);
	}

	public int countPictures(String path)
			throws FileNotFoundException, IOException, IllegalArgumentException, IllegalStateException {

		Operation pictures = (line) -> {
			return countPicturesInLine(line);
		};

		return parseLines(path, pictures);
	}

	private int parseLines(String path, Operation operation)
			throws FileNotFoundException, IOException, IllegalStateException {
		if (path == null) {
			throw new IllegalArgumentException("Path can not be null!");
		}
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		int count = 0;
		String line;
		while (br.ready()) {
			line = br.readLine();

			if (count > (Integer.MAX_VALUE - line.length())) {
				br.close();
				fr.close();
				throw new IllegalStateException("Maximum character count exceeded.");
			}
			count += operation.count(line);
		}
		br.close();
		fr.close();
		return count;
	}

	private int countPicturesInLine(String line) {
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {
			lastIndex = line.indexOf(picture, lastIndex);
			if (lastIndex != -1) {
				count++;
				lastIndex += picture.length();
			}
		}

		return count;
	}
}
