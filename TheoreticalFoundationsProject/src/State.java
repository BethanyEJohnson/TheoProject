/* 
* State class to make nodes
* The nodes will represent states within the DFA
* Node links will be based on the arrows of the
* DFA diagram being used
*/
	
	class State{
		/*
		 * For the DFA, each state has a state to go to when
		 * the input is 0 and a state to go to when the input 
		 * is 1. So each State node will have a reference to the 
		 * respective next-State objects. These references will be
		 * named input0 and input1
		 */
		State input0;
		State input1;
		
		String name;//name of state

		State(){
			this.name = "State";
		}
		
		State(State in0, State in1){
			this.input0 = in0;
			this.input1 = in1;
		}
		
		State(String name, State in0, State in1){
			this.name = name;
			this.input0 = in0;
			this.input1 = in1;
		}
		
		//Getters and Setters for state names
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		//Getters and Setters for input0 and input1
		public State getInput0() {
			return input0;
		}
		
		public State getInput1() {
			return input1;
		}
		
		public void setInput0(State in0) {
			this.input0 = in0;
		}
		
		public void setInput1(State in1) {
			this.input1 = in1;
		}

	}