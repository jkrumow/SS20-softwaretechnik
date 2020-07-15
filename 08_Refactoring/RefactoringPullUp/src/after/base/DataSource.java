package after.base;

import java.util.zip.Checksum;

public abstract class DataSource {

	public abstract void open();

	public abstract void close();

	public abstract String fetch(String query);

	public boolean verify(Checksum checksum) {
		// verify checksum and return true / false
		return false;
	}
}
