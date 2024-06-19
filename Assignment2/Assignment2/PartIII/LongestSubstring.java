public class LongestSubstring {

	public static String longestSubstring(String s) {
		int startIndex = 0;
		int maxLength = 0;
		int currentLength = 0;
		String longest = "";
		
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			int firstOccurrence = s.indexOf(letter, startIndex);
			
			if(firstOccurrence == i) {
				// no repeat, keep going
				currentLength++;
				if(currentLength > maxLength) {
					maxLength = currentLength;
					longest = s.substring(startIndex, i+1);
				}
			} else {
				// start over right after the first occurrence
				startIndex = firstOccurrence+1;
				i = startIndex;
				currentLength = 1;
			}
		}
		return longest;
	}
	
	public static void main(String[] args) {
		String str = "bananagramtastico";
		String longest = longestSubstring(str);
		System.out.println("The longest substring of " + str + " is " + longest);
	}

}
