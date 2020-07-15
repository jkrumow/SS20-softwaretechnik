package after.connectors;

public interface IConnectable {

	public void open();

	public void close();

	public String fetch(String query);

}
