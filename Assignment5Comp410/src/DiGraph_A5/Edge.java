package DiGraph_A5;

public class Edge {
	
	private long id;
	private String sLabel;
	private String dLabel;
	private long weight;
	private String eLabel;
	
	public Edge(long id,String sLabel, String dLabel,long weight,String eLabel){
		
		this.id=id;
		this.sLabel=sLabel;
		this.dLabel=dLabel;
		this.weight=weight;
		this.eLabel=eLabel;
		
	}
	
	public long getId(){
		return id;
	}
	
	public String getSLabel(){
		
		return sLabel;
	}
	
	public String getDLabel(){
		return dLabel;
	}
	
	public long getWeight(){
		
		return weight;
	}
	
	public String getELabel(){
		return eLabel;
	}

}
