package client;



public class User {

	//private Long id;


	private String username;

	private String hash;

	public User(String username, String hash) {
		this.username = username;
		this.hash = hash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "User{" +
				", username='" + username + '\'' +
				", hash='" + hash + '\'' +
				'}';
	}
}