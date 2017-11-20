package bz.Java反射_很重要_里面有个配置文件_很重要;

public class Person {
	private String name;
	int age;
	public String address;

	public Person() {
	}

	@SuppressWarnings("unused")
	private Person(String name) {
		this.name = name;
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void show() {
		System.out.println("show");
	}

	public void method(String s) {
		System.out.println("method " + s);
	}

	public String getString(String s, int i) {
		return s + "---" + i;
	}

	@SuppressWarnings("unused")
	private void function() {
		System.out.println("function");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}