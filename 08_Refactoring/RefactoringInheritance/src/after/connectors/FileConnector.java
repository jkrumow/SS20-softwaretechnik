package after.connectors;

public class FileConnector implements IConnectable {

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

}
