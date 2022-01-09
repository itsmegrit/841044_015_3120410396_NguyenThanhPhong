public class Author extends Person {
	private int authorID;
	private String authorNickname;

	private static int TGIDCount = 0;

	private static int TGIDIdentity() {
		return ++TGIDCount;
	}

// constructor
	public Author() {
		this.name = "";
		this.authorID = TGIDIdentity();
		this.age = 0;
		this.authorNickname = "";
	}

	public Author(String authorName, String authorNickname, int age) {
		this.name = authorName;
		this.age = age;
		this.authorID = TGIDIdentity();
		this.authorNickname = authorNickname;
	}

// setter
	public void setAuthorNickname(String nickname) {
		this.authorNickname = nickname;
	}

// getter
	public int getAuthorID() {
		return this.authorID;
	}

	public String getAuthorNickname() {
		return this.authorNickname;
	}

// toString
	@Override
	public String toString() {
		return this.authorID + ";" + super.toString() + ";" + this.authorNickname;
	}
}