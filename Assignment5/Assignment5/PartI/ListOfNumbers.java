import java.io.*;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    private String fileName;
    public ArrayList<RDFTriple<Integer, Integer, Integer>> getRdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);

    		RDFTriple<Integer, Integer, Integer> triple = new RDFTriple<Integer, Integer, Integer>(number1, number2, number3);
    		rdfTripleList.add(triple);
    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this.fileName = fileName;	
    }
    
    public void readList() {
    	// create an ArrayList of RDFTriples 
    	rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	
    	try(FileReader f = new FileReader("numberfile.txt");
    		BufferedReader in = new BufferedReader(f)) {
			String ln = in.readLine();
			
			while (ln != null) {
				String[] nums = ln.split(" ");
				if(nums.length == 3) {
					int num1 = Integer.parseInt(nums[0]);
					int num2 = Integer.parseInt(nums[1]);
					int num3 = Integer.parseInt(nums[2]);
					
					System.out.println(num1 + " " + num2 + " " + num3);
					
		    		RDFTriple<Integer, Integer, Integer> triple = new RDFTriple<Integer, Integer, Integer>(num1, num2, num3);
		    		rdfTripleList.add(triple);
				}
				ln = in.readLine();
			}
    	} catch(IOException e) {
    		System.out.println("Encountered an error reading from the file.");
    	} catch(NumberFormatException e) {
    		System.out.println("Unable to parse numbers from the file.");
    	} catch (Exception e) {
    		System.out.println("An unknown error has occurred.");
    	}
    }
    
    public void writeList(String outfile) {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < rdfTripleList.size(); i++)
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred() + " " + rdfTripleList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.createList();
    	listOfNumbers.writeList("rdfoutput.txt");
    }

}
