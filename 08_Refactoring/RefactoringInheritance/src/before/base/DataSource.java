package before.base;

public abstract class DataSource {

	public abstract void open();

	public abstract void close();

	public abstract String fetch(String query);
}
