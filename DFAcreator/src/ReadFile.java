import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ReadFile {
	public static BufferedReader br;

	public static BufferedReader openFile(String file) {
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			System.out.println("Could not find file");
		}
		return br;
	}

	public static void readFile() {
		// Split by line into string variable array
		ArrayList<String> eachLine = new ArrayList<>();	//Arraylist for each line of text
		ArrayList<String> alphabetline = new ArrayList<>(); //Arraylist for each value needed 
		ArrayList<String> stateline = new ArrayList<>(); //ArrayList for states 
		ArrayList<String> startStatelist = new ArrayList<>();
		ArrayList<String> acceptStateslist = new ArrayList<>();//ArrayList for accept state
		
		String alphabet;
		String states, startState, acceptStates;
		try {
			
			
			while (br.ready()) {
				eachLine.add(br.readLine());
			}
			
//			for (int i=0; i<eachLine.size();i++) {
//				System.out.println(eachLine.get(0)+ " ");
//			}
//			
			alphabet = eachLine.get(0);

			
//////////////////////////////////////////////////////////////			
//			CODE TO BREAK UP ELEMENTS BY COMMA
			String alp = alphabet.replaceAll("[\\{ \\}]", " ");
			String[] newAlphabet = alp.split(",");
			for (int i=0; i<newAlphabet.length;i++) {
				alphabetline.add(newAlphabet[i]);
			}
			for (int i=0; i<newAlphabet.length;i++) {
				System.out.println(alphabetline.get(i)+ " ");
			}
//////////////////////////////////////////////////////////////
//			
			states = eachLine.get(1);
			String st = states.replaceAll("[\\{ \\}]", " ");
			String[] newStates = st.split(",");
			for (int i=0; i<newStates.length;i++) {
				stateline.add(newStates[i]);
			}
			for (int i=0; i<newStates.length;i++) {
				System.out.println(stateline.get(i)+ " ");
			}
			
	//////////////////////////////////////////////////////////		
			
			startState = eachLine.get(2);
			String ss = startState.replaceAll("[\\{ \\}]", " ");
			String[] newStartState = ss.split(",");
			for (int i=0; i<newStartState.length;i++) {
				startStatelist.add(newStartState[i]);
			}
			for (int i=0; i<newStartState.length;i++) {
				System.out.println(startStatelist.get(i)+ " ");
			}

	//////////////////////////////////////////////////////////
			
			acceptStates = eachLine.get(3);
			String as = acceptStates.replaceAll("[\\{ \\}]", " ");
			String[] newAcceptState = as.split(",");
			for (int i=0; i<newAcceptState.length;i++) {
				acceptStateslist.add(newAcceptState[i]);
			}
			for (int i=0; i<newAcceptState.length;i++) {
				System.out.println(acceptStateslist.get(i)+ " ");
			}
			


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeFile() throws IOException {
		br.close();
	}

}
