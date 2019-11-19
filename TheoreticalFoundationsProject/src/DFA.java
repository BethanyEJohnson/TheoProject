
public class DFA {
	/*
	int numOfStates;//number of states in DFA
	State[] dfa;
	
	public DFA(int numOfStaes){
		this.numOfStates = numOfStates;
		dfa = new State[numOfStates];
	}
	*/
	public static void main(String[] args) {
		//Create State objects for DFA
		State a = new State();
		State b = new State();
		State c = new State();
		State d = new State();
		State e = new State();
		
		//Name each state
		a.setName("a");
		b.setName("b");
		c.setName("c");
		d.setName("d");
		e.setName("e");
		
		//Link the States
		a.setInput0(a);
		a.setInput1(b);
		b.setInput0(a);
		b.setInput1(c);
		c.setInput0(d);
		c.setInput1(c);
		d.setInput0(e);
		d.setInput1(c);
		e.setInput0(e);
		e.setInput1(e);
		
		//Store States in Array
		State[] dfa = new State[5];
		dfa[0] = a;
		dfa[1] = b;
		dfa[2] = c;
		dfa[3] = d;
		dfa[4] = e;
		
		//Print links for each state in DFA
		printDFA(dfa);
		
	}
	
	/*
	 * Print method for DFA
	 * Maybe make static so it can be called with class name
	 */
	public static void printDFA(State[] states) {
		for(int i = 0; i< states.length; i++) {
			System.out.println("State " + states[i].getName() + " links to "
					+ states[i].getInput0().getName() + " with input 0"
					+ " and links to " + states[i].getInput1().getName() + 
					" with input 1");
		}
	}
	
}
