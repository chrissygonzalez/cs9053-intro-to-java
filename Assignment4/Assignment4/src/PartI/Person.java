package PartI;

public class Person {
	private String name;
	private int age;
	private char gender;
	private static int nextId = 0;
	private int id;
	
  public Person() {
	  this.id = nextId++;
	  this.gender = '?';
  }
  
  public Person(String name, int age, char gender) {
	  this.id = nextId++;
	  this.name = name;
	  this.age = age;
	  this.gender = gender;
  }
  
  public void setName(String name) {
	  this.name = name;
  }
  
  public String getName() {
	  return this.name;
  }
  
  public void setAge(int age) {
	  this.age = age;
  }
  
  public int getAge() {
	  return this.age;
  }
  
  public void setGender(char gender) {
	  this.gender = gender;
  }
  
  public char getGender() {
	  return this.gender;
  }
  
  public int getId() {
	  return this.id;
  }
  
  public String toString() {
		return "name: " + this.name 
				+ ", age: " + this.age 
				+ ", gender: " + this.gender 
				+ ", id: " + this.id;
  }
  
  public boolean equals(Object o) {
	  if(o instanceof Person) {
			if(this.name == ((Person)o).name 
					&& this.age == ((Person)o).age 
					&& this.gender == ((Person)o).gender) {
				return true;
			}
		} 
		return false;
	}
}