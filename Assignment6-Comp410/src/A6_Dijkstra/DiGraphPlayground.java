package A6_Dijkstra;



public class DiGraphPlayground {

  public static void main (String[] args) {
	  
	  DiGraph test=new DiGraph();
	  
	  test.addNode(0, "a");
	  test.addNode(1, "b");
	  test.addNode(2, "c");
	  test.addEdge(0, "a", "b", 3, null);
	  test.addEdge(1, "b", "c", 4, null);
	  test.addEdge(2, "a", "c", 5, null);
	  test.shortestPath("a");
  }
  
}
  
