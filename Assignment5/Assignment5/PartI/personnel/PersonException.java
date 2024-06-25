package personnel;

public class PersonException extends RuntimeException {
	private String message;
	
	public PersonException(String message) {
		this.message = message;
//		System.err.println(message);
	}
	
	public String getMessage() {
		return message;
	}
	
}