package personnel;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* your tasks:
 * create a class called PersonException
 * createPerson should throw a PersonException
 * in main(), you should catch the PersonException
 * 
 */
public class ReadPersonFile {

	public static final SimpleDateFormat SDF = new SimpleDateFormat("MM-dd-yyyy");
	public static Person createPerson(String personString) {
		String[] personData = personString.split(",");
		Person person = null;
		String type = personData[0];
		String name = personData[1];
		int age = Integer.parseInt(personData[2]);
		char gender = personData[3].charAt(0);
		try {
			switch (type) {
			/*String name, int age, char gender, 
				double salary, String title, Date startDate, 
				boolean tenured, String department)*/
				case "Faculty":
					double salary = Double.parseDouble(personData[4]);
					String title = personData[5];
					Date startDate = SDF.parse(personData[6]);
					boolean tenured = Boolean.parseBoolean(personData[7]);
					String department = personData[8];
					person = new Faculty(name, age, gender, 
								salary, title, startDate, tenured, department);
					break;
				case "Contractor":
					/* String name, int age, char gender, 
			double salary, String title, Date startDate,
			String contractCompany, Date endDate*/
					 salary = Double.parseDouble(personData[4]);
					 title = personData[5];
					 startDate = SDF.parse(personData[6]);
					 String contractingCompany = personData[7];
					 Date endDate = SDF.parse(personData[8]);
					 person = new Contractor(name, age, gender, 
								salary, title, startDate, contractingCompany, endDate);
					break;
				case "Staff":
					/* String name, int age, char gender, double salary, 
					 * String title, Date startDate, Staff manager
					 */
					salary = Double.parseDouble(personData[4]);
					title = personData[5];
					startDate = SDF.parse(personData[6]);
					person = new Staff(name, age, gender, 
								salary, title, startDate, null); // handle this later
					
					break;
				case "UndergraduateStudent":
					/* String name, int age, char gender, String department, 
					 * int graduationYear) {
					 */
					department = personData[4];
					int graduationYear = Integer.parseInt(personData[5]);
					person = new UndergraduateStudent(name, age, gender, 
							department, graduationYear);
					break;
				case "GraduateStudent":
					/* String name, int age, char gender, 
						String department, Faculty advisor*/
					department = personData[4];
					person = new GraduateStudent(name, age, gender, 
							department, null);
					break;
				case "SpecialStudent":
					/* String name, int age, char gender, 
			String department, Date endDate*/
					department = personData[4];
					endDate = SDF.parse(personData[5]);
					person = new SpecialStudent(name, age, gender, 
							department, endDate);
					break;
				default:
					throw new PersonException("Unknown personnel type: " + type);
			}
		} catch (ParseException pe) {
			throw new PersonException("Cannot parse date in data: " + pe.getMessage());
		}
		return person;
	}
	
	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		File f = new File("personnel.txt");
		
		String inString = null;
		/* create a loop to read the file line-by-line */
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			inString = br.readLine();
			while (inString != null) {
				Person person = null;
				try {
					person = createPerson(inString);
					
				} catch (PersonException pe ) {
					System.err.println("Cannot create Person: " + inString);
					inString = br.readLine();
					continue;
				}
				/* there are different ways of doing this */
				/* under normal circumstances, the optimal solution would be to
				 * have a dictionary that mapped names of people to their objects
				 * and use those as lookups when setting their manager or advisor
				 */
				if (person.getClass() == Staff.class) {
					String[] data = inString.split(",");
					String managerName = data[data.length-1];
					for (Person p : personList) {
						if (p.getName().equals(managerName)) {
							((Staff)person).setManager((Staff)p);
						}
					}
				} else if (person.getClass() == GraduateStudent.class) {
					String[] data = inString.split(",");
					String advisorName = data[data.length-1];
					for (Person p : personList) {
						if (p.getName().equals(advisorName)) {
							((GraduateStudent)person).setAdvisor((Faculty)p);
						}
					}
				}
				personList.add(person);
				inString = br.readLine();
				br.close();
			}
		
		} catch (IOException ioe) {
			System.err.println("IO Error");
		}
		for (Person p : personList) {
			System.out.println(p);
		}
		System.out.println("Number of people: " + personList.size());
		
	}
}
