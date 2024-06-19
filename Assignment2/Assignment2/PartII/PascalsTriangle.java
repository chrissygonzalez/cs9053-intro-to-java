
public class PascalsTriangle {

	public static int[][] createPascalTriangle(int rows) {
		int[][] result = new int[rows][];
		for (int i = 0; i < rows; i++) {
			int rowLength = i + 1;
			result[i] = new int[rowLength];
			for(int j = 0; j < rowLength; j++) {
				if(j == 0 || j == rowLength - 1) result[i][j] = 1;
				else {
					result[i][j] = result[i-1][j] + result[i-1][j-1];
				}
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		
		int[][] triangle = createPascalTriangle(20);
		
    	// print result
    	for(int i = 0; i < triangle.length; i++) {
    		for(int j = 0; j < triangle[i].length; j++) {
    			System.out.print(triangle[i][j] + " ");
    		}
    		System.out.println("");
    	}
	}

}
