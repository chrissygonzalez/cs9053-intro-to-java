package personnel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			dt = sdf.parse("01-05-2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
