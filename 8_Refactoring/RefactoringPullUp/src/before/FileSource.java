package before;

import java.util.zip.Checksum;

import before.base.DataSource;

public class FileSource extends DataSource {

	public void addPassword(String password) {

	}

	@Override
	public void open() {
		// open a file in the file system

	}

	@Override
	public void close() {
		// close the file in the file system

	}

	@Override
	public String fetch(String query) {
		// read from file, depending on file format
		return null;
	}
	
	public boolean verify(Checksum checksum) {
		// verify checksum and return true / false
		return false;
	}

}
