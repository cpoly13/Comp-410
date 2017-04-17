package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    exTest2();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "f");
      d.addNode(3, "s");
      d.addNode(7, "t");
      d.addNode(0, "fo");
      d.addNode(4, "fi");
      d.addNode(6, "si");
      d.addEdge(0, "f", "s", 0, null);
      d.addEdge(1, "f", "si", 0, null);
      d.addEdge(2, "s", "t", 0, null);
      d.addEdge(3, "fo", "fi", 0, null);
      d.addEdge(4, "fi", "si", 0, null);
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
      printTOPO(d.topoSort());
      
    }
    
    public static void exTest2(){
    	DiGraph t=new DiGraph();
    	
    	String name = "case: ";
    	String name2 = "case: ";
    	int id=0;
    	
    	for(int i=0; i<1000000; i++ ){
    		
    		name=name.concat(Integer.toString(i));
    		t.addNode(i,name );
    		name="case: ";
    	}
    	
    	while(id<1000000){
    		name=name.concat(Integer.toString(id));
    		int toPass=id+1;
    		name2=name2.concat(Integer.toString(toPass));
    		t.addEdge(id, name , name2 , 0, null);
    		name="case: ";
    		name2="case: ";
    		id++;
    	}
    	
    	System.out.println("numEdges: "+t.numEdges());
        System.out.println("numNodes: "+t.numNodes());
        t.topoSort();
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }

}
