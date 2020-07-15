package before;

import java.util.zip.Checksum;

import before.base.DataSource;

public class DBSource extends DataSource {

	public void addPassword(String password) {

	}

	@Override
	public void open() {
		// open database connection

	}

	@Override
	public void close() {
		// close database connection

	}

	@Override
	public String fetch(String query) {
		// send a database specific query (SQL ...)
		return null;
	}

	public boolean verify(Checksum checksum) {
		// verify checksum and return true / false
		return false;
	}

}
