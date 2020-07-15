package after;

import after.connectors.IConnectable;

public class DataSource {

	private IConnectable connector;

	public DataSource(IConnectable connector) {
		this.connector = connector;
	}

	public void open() {
		connector.open();
	}

	public void close() {
		connector.close();
	}

	public String fetch(String query) {
		return connector.fetch(query);
	}
}
