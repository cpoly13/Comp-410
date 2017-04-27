package A6_Dijkstra;



public class DiGraphPlayground {

  public static void main (String[] args) {
	  
	  String a="a";
	  String b="b";
	  String c="c";
	  
	  DiGraph test=new DiGraph();
	  
	  test.addNode(0, "a");
	  test.addNode(1, "b");
	  test.addNode(2, "c");
	  test.addEdge(0, "a", "b", 3, null);
	  test.addEdge(1, "b", "c", 4, null);
	  test.addEdge(2, "a", "c", 5, null);
	  test.shortestPath("a");
	  
DiGraph test3=new DiGraph();
	  
	  test3.addNode(1, "p");
	  test3.addNode(4, "a");
	  test3.addNode(3, "g");
	  test3.addNode(2, "e");
	  test3.addEdge(0, "p", "a", 10, null);
	  test3.addEdge(1, "a", "g", 12, null);
	  test3.addEdge(2, "g", "e", 1, null);
	  test3.addEdge(3, "e", "p", 6, null);
	  test3.addEdge(4, "p", "g",4, null);
	  test3.addEdge(5, "a", "e", 100, null);
	  test3.addEdge(6, "a", "p", 9, null);
	  test3.addEdge(7, "e", "a", 3, null);
	  test3.addEdge(8, "g", "a", 15, null);
	  test3.addEdge(9, "p", "e", 8, null);
	  test3.addEdge(10, "g", "p", 2, null);
	  test3.shortestPath("p");
	  
	  DiGraph test1=new DiGraph();
	  
	  test1.addNode(0, a);
	  test1.addNode(1, b);
	  test1.addNode(2, c);
	  test1.addEdge(0, a, b, 3, null);
	  test1.addEdge(1, b, c, 4, null);
	  test1.addEdge(2, a, c, 10, null);
	  test1.shortestPath(a);
	  
	  DiGraph test4=new DiGraph();
	  
	  //test4.addNode(0, 0);
	  
	  
  }
  
}
  
