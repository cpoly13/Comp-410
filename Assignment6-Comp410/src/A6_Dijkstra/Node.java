package A6_Dijkstra;


import java.util.HashMap;

public class Node {
	
	private long id;
	private String name;
	private HashMap <String,Edge>  edgeIn;
	private HashMap <String,Edge> edgeOut;
	private long inDegree;
	private boolean known;
	private long distance;
	
	public Node(long id, String name){
		this.id=id;
		this.name=name;
		edgeIn= new HashMap <String, Edge>();
		edgeOut= new HashMap <String, Edge>();
		inDegree=0;
		known=false;
		distance=Long.MAX_VALUE;
		
	}
	
	public Node (long id, int name){
		
		this.id=id;
		this.name= Integer.toString(name);
		edgeIn= new HashMap <String, Edge>();
		edgeOut= new HashMap <String, Edge>();
		inDegree=0;
		known=false;
		distance=Long.MAX_VALUE;
		
	}
	
	public long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isKnown(){
		return known;
	}
	
	public void setKnown(boolean k){
		known=k;
	}
	
	public long getDistance(){
		return distance;
	}
	
	public void setDistance(long d){
		distance=d;
	}
	
	public void addEdgeIn(Edge in){
			
		edgeIn.put(in.getSLabel(), in);
		inDegree++;
			
		
	}
	
	public void addEdgeOut(Edge out){
		
		edgeOut.put(out.getDLabel(),out);
	}
	
	public void delEdgeIn(Edge in){
		
		 edgeIn.remove(in.getSLabel());
		 inDegree--;
	}
	
	public void delEdgeIn(String sLabel){
		edgeIn.remove(sLabel);
		inDegree--;
	}
	
	public void delEdgeOut(Edge out){
		
		edgeOut.remove(out.getDLabel());
	}
	
	public void delEdgeOut(String dLabel){
		edgeOut.remove(dLabel);
	}
	
	public boolean containsEdgeIn(String in){
		if(edgeIn.containsKey(in)){
			return true;
		}
		
		return false;
	}
	
	public boolean containsEdgeOut(String out){
		if(edgeOut.containsKey(out)){
			return true;
		}
		
		return false;
	}
	
	public HashMap <String, Edge> getEdgesIn(){
		return edgeIn;
	}
	
	public HashMap <String,Edge> getEdgesOut(){
		return edgeOut;
	}
	
	public long getInDegree(){
		return inDegree;
	}
	

}
