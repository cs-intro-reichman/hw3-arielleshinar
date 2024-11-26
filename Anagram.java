/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
/* 
An anagram is a word or a phrase formed by rearranging the letters of a different
word or phrase, using every original letter exactly once. For example, the word “listen” can be
rearranged into “silent”. As we did with palindromes, we disregard spaces, punctuation marks,
and upper/lower case letters. For example, “anagram” and “Nag a Ram” are anagrams.
Inspect the given Anagram.java class, and implement all its functions.

Implementation notes:
1. Start by reading the main function. Make sure that you understand all the tests.
2. Implement the preProcess function, and test it. You can add testing code to the main function,
as you see fit.
3. Implement the isAnagram function. Start by pre-processing the two strings. Then check if the
two resulting strings form an anagram. Tip: Use a nested loop for iterating over all the characters
of both strings.
4. Implement randomAnagram. Note that this function is not supposed to return a word or phrase
in the English language. Rather, it should return some random permutation of the characters in
the given string. For example, a random anagram of the string “java” may be, say, “ajva”.
Tip: One way to implement this function is to use a loop that draws a random character from the
string and then deletes the selected character from the string (so that we will not select it again).
*/
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
		// Replace the following statement with your code
		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		return "";
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		return "";
	}
}
