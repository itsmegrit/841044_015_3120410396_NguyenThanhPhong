public class Reader extends Person {
	private String passport;
	private int readerType;
	private int readerID;

	private static int IDCount = 0;

	private static int IDIdentity() {
		return ++IDCount;
	}

// constructor
	public Reader(String readerName, int age, String passport, int readerType) {
		this.name = readerName;
		this.age = age;
		this.readerID = IDIdentity();
		this.passport = passport;
		this.readerType = readerType;
	}

	public Reader() {
		this.name = null;
		this.readerID = IDIdentity();
		this.age = age;
		this.passport = "";
		this.readerType = 0;
	}

// setter
	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setReaderType(int readerType) {
		this.readerType = readerType;
	}

// getter
	public int getReaderID() {
		return this.readerID;
	}

	public String getPassport() {
		return this.passport;
	}

	public int getReaderType() {
		return this.readerType;
	}

// intType to stringType
	private String printType(int type) {
		if (type == 0) {
			return "sinh vien";
		}
		return "giang vien";
	}

// toString
	@Override
	public String toString() {
		return this.readerID + ";" + super.toString() + ";" + this.passport + ";" + printType(this.readerType);
	}
}