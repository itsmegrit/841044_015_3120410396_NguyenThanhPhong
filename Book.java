public class Book {
	private int bookID;
	private int numberOfPages,
	        publishYear;
	private String bookName;
	String type;
	Author author;

	private static int BIDCount = 0;

	private static int BIDIdentity() {
		return ++BIDCount;
	}

// constructor
	public Book() {
		this.bookID = BIDIdentity();
		this.author = null;
		this.numberOfPages = 0;
		this.publishYear = 0;
		this.bookName = "";
		this.type = "";
	}

	public Book(String bookName, String type, Author author, int numberOfPages, int publishYear) {
		this.bookID = BIDIdentity();
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.publishYear = publishYear;
		this.bookName = bookName;
		this.type = type;
	}

// setter
	public void setBookName(String bookname) {
		this.bookName = bookname;
	}

	public void setNumberOfPages(int number) {
		this.numberOfPages = number;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setType(String type) {
		this.type = type;
	}

// getter
	public String getBookName() {
		return this.bookName;
	}

	public int getBookID() {
		return this.bookID;
	}

	public int getNumberOfPages() {
		return this.numberOfPages;
	}

	public Author getAuthor() {
		return this.author;
	}

	public String getType() {
		return this.type;
	}

// toString
	public String toString() {
		return this.bookID + ";" + this.bookName + ";" + this.author.getAuthorID() + ";" + this.numberOfPages + ";" + this.publishYear + ";" + this.type;
	}
}