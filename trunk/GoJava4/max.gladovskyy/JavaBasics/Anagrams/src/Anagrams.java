import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagrams {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String userString = reader.readLine();
		String[] userStringSplited = userString.split(" ");
		
		for (String word: userStringSplited) {
			System.out.print(reverse(word)+" ");
		}
		
	}

	private static String reverse(String s) {
		char[] wordChars = s.toCharArray();
		char[] reversedWordChars = new char[wordChars.length];
		
		for (int i=0; i<wordChars.length; i++) {
			reversedWordChars[wordChars.length-1-i] = wordChars[i];
		}
		return new String(reversedWordChars);
	}

}
