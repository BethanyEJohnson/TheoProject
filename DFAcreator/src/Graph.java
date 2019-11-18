//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class Graph {
//	
//	//String of Edges
//	//private Map<Vertex, List<Vertex>> adjVertices;
//	
//	class Edge{
//		String v,w;
//		
//		public Edge(String v, String w) {
//			this.v=v;
//			this.w=w;
//		}
//		@Override
//		public String toString() {
//			return "("+v+","+w+")";
//		}
//		
//	}
//	
//	List<Edge>G[];
//	public Graph(String n) {
//		G = new LinkedList[n];
//		for(int i=0; i<G.length;i++) {
//			G[i]=new LinkedList<Edge>();
//		}
//		
//	}
//	
//	boolean isConnected(String u, String v) {
//		for (Edge i : G[u]) {
//			if(i.v==v) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	void addEdge(String u,String v,String w) {
//		G[u].add(0,new Edge(v,w));
//	}
//	
//	@Override
//	public String toString() {
//		String result = " ";
//		for (int i=0; i<G.length;i++) {
//			result+=i+"=>"+G[i]+"\n";
//		}
//		return result;
//	}
//	
//}
