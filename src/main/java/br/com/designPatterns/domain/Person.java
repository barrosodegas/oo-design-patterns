package br.com.designPatterns.domain;

public class Person {

	String name;
	String lastName;
	int age;
	
	public Person() { }
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public Person(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
