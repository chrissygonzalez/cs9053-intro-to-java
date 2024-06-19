import java.util.Arrays;

class Permutations {
	
	public static int[][] getPermutations(int[] array) {
		int length = array.length;
		
		if (length == 1) {
			int[][] baseCase = { array };
			return baseCase;
		}
		
		int numberOfPermutations = factorial(length);
		int[][] result = new int[numberOfPermutations][length];
		int currentIndex = 0;
		
		// get number to include and smaller permutations
		int num = array[length-1];
		int[][] smallerPermutations = getPermutations(Arrays.copyOf(array, length-1));
		
		// for each smaller permutation:
		for (int[] s : smallerPermutations) {
			// for each position the number can occupy:
			for(int numIndex = 0; numIndex < length; numIndex++) {
				int[] newPermutation = new int[length];
				
				// sIndex is position in smaller permutation
				int sIndex = 0; 
				// i is position within newPermutation
				for(int i = 0; i < length; i++) {
					if(i != numIndex) {
						// copy from smaller permutation
						newPermutation[i] = s[sIndex];
						sIndex++;
					} else {
						// else put the number in position i
						newPermutation[i] = num;
					}
				}
				result[currentIndex] = newPermutation;
				currentIndex++;
			}
		}
		return result;
		
	}
	
	private static int factorial(int len) {
		int total = 1;
		for (int i = len; i > 1; i--) {
			total *= i;
		}
		return total;
	}	
    
    public static void main(String[] args) {
    	int[] startingArray =   {1, 2, 3, 4, 5};
    	int[][] result = getPermutations(startingArray);
    	
    	// print result
    	for(int i = 0; i < result.length; i++) {
    		System.out.print("[");
    		for(int j = 0; j < startingArray.length; j++) {
    			System.out.print(result[i][j]);
    			if(j < startingArray.length - 1) System.out.print(", ");
    		}
    		System.out.println("]");
    	}
    }
}
