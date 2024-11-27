import java.util.Arrays;
import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {

		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		
        // Convert the string into a character array
        char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		int[] count1 = new int[27];
		int[] count2 = new int[27];

		String abc = "abcdefghijklmnopqrstuvwxyz ";
		//goes over the array and checks whats the index of the letter in the alphabet and adds to counter
		for(int i = 0; i<charArray1.length; i++){
			
			count1[abc.indexOf(charArray1[i])]++;
		}
		for (int j = 0; j < charArray2.length; j++){
				
			count2[abc.indexOf(charArray2[j])]++;
		}
        
		for(int n = 0; n < 26; n++){
			if (count1[n] != count2[n]){
				return false;
			}

		}

		return true;
	}  
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		//turn the string into lower case letters
		str = str.toLowerCase();
		String cleanStr = "";
		String lowerabc = "abcdefghijklmnopqrstuvwxyz ";
		for (int i = 0; i<str.length(); i++){
			char c = str.charAt(i);
			//make sure char at i is not a number
			if ( lowerabc.indexOf(c) != -1){
				cleanStr += c;
			}	
		
		}
		return cleanStr;
	} 
	 
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		char[] charArray1 = str.toCharArray();
		String newStr = "";
		//char[] newArray = new char [str.length()];
		//int[] count1 = new int[26];
		//int[] count2 = new int[26];
		
		while(isAnagram(str, newStr) == false) {
			
			Random rand = new Random();
			// Generate a random index between 0 and array.length - 1
       		int randomIndex = rand.nextInt(charArray1.length);
			
			if (Character.isDigit(charArray1[randomIndex]) == false){
				newStr += charArray1[randomIndex];
				charArray1[randomIndex] = 0;

			}
		
		}

		return newStr;
	} 
		 
}
