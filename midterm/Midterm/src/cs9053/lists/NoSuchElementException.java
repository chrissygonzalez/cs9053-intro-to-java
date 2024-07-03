package cs9053.lists;

public class NoSuchElementException extends RuntimeException {
	private String message;
	
	public NoSuchElementException() {
		this.message = "No such element: this element does not exist.";
	}
	
	public String getMessage() {
		return message;
	}
	
}