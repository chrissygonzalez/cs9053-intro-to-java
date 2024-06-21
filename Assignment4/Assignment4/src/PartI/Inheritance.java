package PartI;

import java.time.LocalDate;
import PartII.University;

public class Inheritance {

	public static void main(String[] args) {
		// Part II: University and Student requirements
		System.out.println("UNIVERSITY AND STUDENTS");
		System.out.println("---------------");
		
		Faculty james = new Faculty("James Kaiser", 45, 'M', 130000, "Associate Professor", LocalDate.parse("2020-09-01"), true, "Electrical Engineering");
		UndergraduateStudent john = new UndergraduateStudent("John Smith", 20, 'M', "Computer Science", 2026);
		UndergraduateStudent amy = new UndergraduateStudent("Amy Ferguson", 22, 'F', "Chemistry", 2024);
		GraduateStudent margaret = new GraduateStudent("Margaret Johnson", 25, 'F', "Electrical Engineering", james);
		
		University u = new University();
		u.registerStudent(john);
		u.registerStudent(amy);
		u.registerStudent(margaret);
		
		u.printAllStudents();
		
		u.deregisterStudent(margaret);
		u.printAllStudents();
		
		u.registerStudent(margaret);
		u.printAllStudents();
		
		// More University testing
		u.deregisterStudent(2);
		u.printAllStudents();
		
		u.studentRegistered(3);
		System.out.println(u.studentRegistered(5));
		
		// Trying the equals methods
		System.out.println("\nEQUALS METHODS");
		System.out.println("---------------");
		Person bob = new Person();	
		Employee mary = new Employee("Mary", 53, 'F', 85000, "Manager", "2024-05-06");
		System.out.println(bob.equals(mary));
		
		SpecialStudent jim = new SpecialStudent("Jim Slim", 25, 'F', "Electrical Engineering", LocalDate.parse("2024-05-06"));
		SpecialStudent joe = new SpecialStudent("Jim Slim", 25, 'F', "Electrical Engineering", "2024-05-06");
		System.out.println(jim.equals(joe));
		
		joe.setName("Joe Slim");
		System.out.println(jim.equals(joe));
	}

}