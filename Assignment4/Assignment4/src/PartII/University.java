package PartII;

import java.util.ArrayList;
import PartI.Student;

public class University {
	private ArrayList<Student> registeredStudents;
	
	public University() {
		this.registeredStudents = new ArrayList<Student>();
	}
	
	public void registerStudent(Student s) {
		if(!studentRegistered(s)) {
			registeredStudents.add(s);
		}
	}
	
	public boolean deregisterStudent(Student s) {
		return registeredStudents.remove(s);
	}
	
	public boolean deregisterStudent(int id) {
		boolean removed = false;
		for(int i = 0; i < registeredStudents.size(); i++) {
			if(registeredStudents.get(i).getId() == id) {
				registeredStudents.remove(i);
				removed = true;
			}
		}
		return removed;
	}
	
	public boolean studentRegistered(Student s) {
		boolean registered = false;
		
		for(Student student : registeredStudents) {
			if (student.equals(s)){
				registered = true;
				System.out.println("Student is already registered");
			}
		}
		return registered;
	}
	
	public boolean studentRegistered(int id) {
		boolean registered = false;
		
		for(Student student : registeredStudents) {
			if (student.getId() == id){
				registered = true;
				System.out.println("Student is already registered");
			}
		}
		return registered;
	}
	
	public void printAllStudents() {
		
		for(Student student : registeredStudents) {
			System.out.println(student);
		}
	}
}
