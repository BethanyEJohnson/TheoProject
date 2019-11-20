import java.util.ArrayList;
import java.util.Scanner;

public class StringProcesser {
	
	public static void main(String[] args) {
		String startState = "a";
		String acceptState = "d";
		String alphabet = "01";
		String currentState = startState;
		String nextState = null;
		Scanner input = new Scanner(System.in);
		String testString;
		
		ArrayList<String> function = new ArrayList<>();
		function.add("(a,0)->b");
		function.add("(a,1)->a");
		function.add("(b,0)->c");
		function.add("(b,1)->a");
		function.add("(c,0)->c");
		function.add("(c,1)->d");
		function.add("(d,0)->d");
		function.add("(d,1)->d");
		
		// Take in and verify a string
				boolean isValid = true;
				do {
					System.out.println("Please enter a valid string along the alphabet " + alphabet.substring(0, 1) + " "
							+ alphabet.substring(1));
					testString = input.next();
					for (int i = 1; i <= testString.length(); i++) {
						String tempStr = testString.substring(i - 1, i);
						if (alphabet.toString().contains(tempStr)) {
							isValid = true;
						} else {
							isValid = false;
							System.out.println("The given string " + testString
									+ " is not accepted by the DFA, outside of alphabet range!");
							break;
						}
					}
				} while (isValid == false);
		
		while (testString.length() != 0) {	
			String currentInput = testString.substring(0, 1);
			for (int i = 0; i < function.size(); i++) {
				String tfStart = function.get(i).substring(1, 2);
				String tfInput = function.get(i).substring(3, 4);
				String tfNext = function.get(i).substring(7);
				
				if (currentState.equals(tfStart) && currentInput.equals(tfInput)) {
					nextState = tfNext;
					System.out.println("Current State is: " + currentState + " Input is: " + currentInput
							+ " Next State is: " + nextState);
					currentState = nextState;
					break;
				}
			}
			if (currentState.equals(acceptState)) {
				System.out.println("The given string is accepted by the DFA!");
				break;
			}
			testString = testString.substring(1);
		}
		// Checks to see if the final state reached by the input string matches the
		// accept state and prints result
		if (currentState.equals(acceptState)) {
		
		} else {
			System.out.println("The given string is not accepted by the DFA");
		}
	}
}
