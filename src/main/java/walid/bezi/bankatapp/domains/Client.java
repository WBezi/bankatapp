package walid.bezi.bankatapp.domains;

public class Client {
	private final String id;
	private final String name;

	public Client(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Client client = (Client) o;
		return id.equals(client.id);

	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Client " + name + " with id " + id;
	}
}