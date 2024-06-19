
public class DumbPasswords {

	public static void printDumbPasswords(int m, int n) {
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < m; j++) {
				char limit = (char)('a' + n);
				for(char x = 'a'; x < limit; x++) {
					for(char y = 'a'; y < limit; y++) {
						for(int k = Math.max(i, j) + 1; k < m+1; k++) {
							System.out.print(i);
							System.out.print(j);
							System.out.print(x);
							System.out.print(y);
							System.out.print(k);
							System.out.print(" ");
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		printDumbPasswords(4,2);
		
	}
}
