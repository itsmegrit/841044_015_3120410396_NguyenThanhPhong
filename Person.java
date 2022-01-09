public abstract class Person {
	protected String name;
	protected int age;

	public Person() {
		this.name = "";
		this.age = 0;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String toString() {
		return this.name + ";" + this.age;
	}
}