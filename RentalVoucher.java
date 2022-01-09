import java.util.Date;

public class RentalVoucher {
	private int RTVoucherID;
	private Reader reader;
	private Date borrowedDate,
	        returnDate,
	        payDay;
	private Book book;

	private static int RIDCount = 0;

	private static int RIDIdentity() {
		return ++RIDCount;
	}

// constructor
	public RentalVoucher() {
		this.RTVoucherID = RIDIdentity();
		this.book = null;
		this.reader = null;
		this.borrowedDate = null;
		this.returnDate = null;
		this.payDay = null;
	}

	public RentalVoucher(Book book, Reader reader, Date borrowedDate, Date returnDate, Date payDay) {
		this.RTVoucherID = RIDIdentity();
		this.book = book;
		this.reader = reader;
		this.borrowedDate = borrowedDate;
		this.returnDate = returnDate;
		this.payDay = payDay;
	}

// setter
	public void setBook(Book book) {
		this.book = book;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

// getter
	public Book getBook() {
		return this.book;
	}

	public int getRTVoucherID() {
		return this.RTVoucherID;
	}

	public Reader getReader() {
		return this.reader;
	}

	public Date getBorrowedDate() {
		return this.borrowedDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public Date getPay() {
		return this.payDay;
	}

// toString
	public String toString() {
		return this.RTVoucherID + ";" + this.book.getBookID() + ";" + this.reader.getReaderID()
		       + ";" + this.borrowedDate + ";" + this.returnDate + ";" + this.payDay;
	}
}