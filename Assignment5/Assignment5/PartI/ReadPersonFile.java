import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import personnel.*;

/* your tasks:
 * create a class called PersonException
 * createPerson should throw a PersonException
 * in main(), you should catch the PersonException
 * 
 */
public class ReadPersonFile {
	
	public static Person createEmployee(String type, String name, int age, char gender, String[] args, ArrayList<Person> personList) {
		double salary = Double.parseDouble(args[4]);
		String title = args[5];
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		String startDate = args[6];
		
		try {
			switch(type) {
				case "Faculty": {
					boolean tenured = Boolean.parseBoolean(args[7]);
					String department = args[8];
					Date parsed = sdf.parse(startDate);
					return new Faculty(name, age, gender, salary, title, parsed, tenured, department);
				}
				
				case "Staff": {
					String managerName = args.length >= 8 ? args[7] : "";
					Staff manager = null;
					for(Person p : personList) {
						if(p.getName().equals(managerName) && p.getClass().getSimpleName().equals("Staff")) {
							manager = (Staff) p;
						}
					}
					Date parsed = sdf.parse(startDate);
					return new Staff(name, age, gender, salary, title, parsed, manager);
				}
				
				case "Contractor": {
					String contractCompany = args[7];
					String endDate = args[8];
					Date parsedStart = sdf.parse(startDate);
					Date parsedEnd = sdf.parse(endDate);
					return new Contractor(name, age, gender, salary, title, parsedStart, contractCompany, parsedEnd);
				}
			}
		} catch(ParseException e) {
			System.err.println("Invalid date entered for Employee " + name + ".");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Attempting to access index outside of array range (Employee " + name + ").");
		}
		
		throw new PersonException("Unable to create Employee " + name);
	}
	
	public static Person createStudent(String type, String name, int age, char gender, String[] args, ArrayList<Person> personList) {		
		String department = args[4];
		
		try {
			switch(type) {
				case "UndergraduateStudent": {
					int year = Integer.parseInt(args[5]);
					return new UndergraduateStudent(name, age, gender, department, year);
				}
				
				case "GraduateStudent": {
					String advisorName = args[5];
					Faculty advisor = null;
					for(Person p : personList) {
						if(p.getName().equals(advisorName) && p.getClass().getSimpleName().equals("Faculty")) {
							advisor = (Faculty) p;
						}
					}
					return new GraduateStudent(name, age, gender, department, advisor);
				}
				
				case "SpecialStudent": {
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
					String endDate = args[5];
					Date parsedEnd = sdf.parse(endDate);
					return new SpecialStudent(name, age, gender, department, parsedEnd);
				}
			} 
		} catch(ParseException e) {
			System.out.println("Invalid date entered for Student " + name + ".");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Attempting to access index outside of array range (Student " + name + ").");
		} catch(NumberFormatException e) {
			System.err.println("Unable to parse graduation year.");
		}
		
		throw new PersonException("Unable to create Student " + name);
	}

	public static Person createPerson(String p, ArrayList<Person> personList) {
		String[] args = p.split(",");
		
		if(args.length < 4) {
			throw new PersonException("Not enough information to create Person");
		}
		
		String type = args[0];
		String name = args[1];
		int age = Integer.parseInt(args[2]);
		char gender = args[3].charAt(0);
		
		if(type.equals("Faculty") || type.equals("Staff") || type.equals("Contractor")) {
			return createEmployee(type, name, age, gender, args, personList);
		}
		
		if(type.equals("UndergraduateStudent") || type.equals("GraduateStudent") || type.equals("SpecialStudent")) {
			return createStudent(type, name, age, gender, args, personList);
		}
		
		throw new PersonException("Unable to create Person " + name);
	}
	
	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		
		try(FileReader f = new FileReader("personnel.txt");
			BufferedReader in = new BufferedReader(f)) {
			String ln = in.readLine();
			
			while (ln != null) {
				try {
					Person person = createPerson(ln, personList);
					personList.add(person);
				} catch (PersonException e) {
					System.err.println(e.getMessage());
				}
				ln = in.readLine();
			}
		} catch(IOException e) {
			System.out.println("IO exception occurred: " + e.getMessage());
		}
		
		for(int i = 0; i < personList.size(); i++) {
			int index = i+1;
			System.out.println(index + ". " + personList.get(i));
		}
	}
}
