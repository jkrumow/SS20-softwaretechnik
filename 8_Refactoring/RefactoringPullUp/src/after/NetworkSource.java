package after;

import before.base.DataSource;

public class NetworkSource extends DataSource {

	@Override
	public void open() {
		// start session on server

	}

	@Override
	public void close() {
		// stop session on server

	}

	@Override
	public String fetch(String query) {
		// create and send a query request (GET, POST with body or URL parameters)
		return null;
	}
}
