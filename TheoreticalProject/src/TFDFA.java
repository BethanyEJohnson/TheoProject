import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TFDFA {
		
	
	public static void main(String[] args) throws FileNotFoundException {
	//Allow file to be read from command line 	
		if(args.length>0) {
			File opfile = new File(args[0]);
		
		Scanner input = new Scanner(System.in);
		Scanner file = new Scanner(opfile);

		String alphabet = setAlphabet(file.nextLine());
		String allStates = setAlphabet(file.nextLine());
		String startState = setStart(file.nextLine());
		String acceptState = setAccept(file.nextLine());
		
		String currentState = startState;
		String nextState = null;
		String testString;
		
		ArrayList<String> function = new ArrayList<>();
		while(file.hasNext()) {
			function.add(file.nextLine());
		}
		
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
	}else {
		System.out.println("File not found. Please enter a valid file");
		System.exit(0);
	}
}	
	public static String setAlphabet(String line) {
		String alphabet = "";
		for(int i = 0; i < line.length(); i++) {
			if(!(line.charAt(i) == '{' || line.charAt(i) == '}' || line.charAt(i) == ',')) {
				alphabet = alphabet + line.charAt(i);
			}
		}
		return alphabet;
	}
	
	public static String setStart(String line) {
		String start = "";
		for(int i = 0; i < line.length(); i++) {
			if(!(line.charAt(i) == '{' || line.charAt(i) == '}' || line.charAt(i) == ',')) {
				start = start + line.charAt(i);
			}
		}
		return start;
	}
	
	public static String setAccept(String line) {
		String accept = "";
		for(int i = 0; i < line.length(); i++) {
			if(!(line.charAt(i) == '{' || line.charAt(i) == '}' || line.charAt(i) == ',')) {
				accept = accept + line.charAt(i);
			}
		}
		return accept;
	}
}