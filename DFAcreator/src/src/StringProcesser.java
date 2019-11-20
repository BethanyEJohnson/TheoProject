import java.util.ArrayList;
import java.util.Scanner;

public class StringProcesser {
	public static void main(String[] args) {
		//this class assumes that the .txt file is already parsed and the start state, accept states and transition functions are already assigned to variables
		//no need to format the transition function, this class just pulls out a substring, assuming the format of the file matches the sample.
		//the alphabet and states are not needed
		String startState = "a";
		String acceptState = "d";
		String currentState = startState;
		String nextState = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a string");
		String testString = input.next();
		
		ArrayList<String> function = new ArrayList<>();
		function.add("(a,0)->b");
		function.add("(a,1)->a");
		function.add("(b,0)->c");
		function.add("(b,1)->a");
		function.add("(c,0)->c");
		function.add("(c,1)->d");
		function.add("(d,0)->d");
		function.add("(d,1)->d");		
		
		//takes the current state and the first char of the input string and compares it to the transition function for a match
		//once a match is found, the "next state" becomes the current state and the input string is reduced by one char until the entire string has been read
		while (testString.length() != 0) {
			String currentInput = testString.substring(0, 1);
			for (int i = 0; i < function.size(); i++) {
				if (currentState.equals(function.get(i).substring(1,2)) && currentInput.equals(function.get(i).substring(3,4))) {
					nextState = function.get(i).substring(7);
					System.out.println("Current State is: " + currentState + " Input is: " + currentInput + " Next State is: " + nextState);
					currentState = nextState;
				}
			}
			testString = testString.substring(1);
		}
		
		//Checks to see if the final state reached by the input string matches the accept state and prints result
		if(currentState.equals(acceptState)) {
			System.out.println("The given string "+ testString + " is accepted by the DFA!");
		}else {
			System.out.println("The given string "+ testString + " is not accepted by the DFA");
		}
	}
}
