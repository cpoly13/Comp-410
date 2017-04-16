package DiGraph_A5;

import java.util.HashMap;

public class DiGraph implements DiGraph_Interface {

	// in here go all your data and methods for the graph
	// and the topo sort operation

	private HashMap<String, Node> nodeTable;
	private HashMap<String, Edge> edgeTable;
	private HashMap<Long, Node> nodeNumList;
	private HashMap<Long, Edge> edgeNumList;
	private long numNodes;
	private long numEdges;

	public DiGraph() { // default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there

		nodeTable = new HashMap<String, Node>();
		edgeTable = new HashMap<String, Edge>();
		nodeNumList = new HashMap<Long, Node>();
		edgeNumList = new HashMap<Long, Edge>();

		numNodes = 0;
		numEdges = 0;
	}

	@Override
	public boolean addNode(long idNum, String label) {
		if (idNum < 0) {
			return false;
		}

		if (nodeNumList.containsKey(idNum)) {

			return false;
		}

		if (label == null) {
			return false;
		}

		if (nodeTable.containsKey(label)) {
			return false;
		}

		Node newNode = new Node(idNum, label);
		nodeTable.put(label, newNode);
		nodeNumList.put(idNum, newNode);
		numNodes++;
		return true;

	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {

		if (idNum < 0) {
			return false;
		}

		if (edgeNumList.containsKey(idNum)) {
			return false;
		}

		if (!nodeTable.containsKey(sLabel) || !nodeTable.containsKey(dLabel)) {
			return false;
		}

		if (nodeTable.get(sLabel).containsEdgeOut(dLabel) && nodeTable.get(dLabel).containsEdgeIn(sLabel)) {
			return false;
		}

		Edge newEdge = new Edge(idNum, sLabel, dLabel, 1, eLabel);
		edgeTable.put(sLabel + dLabel, newEdge);
		edgeNumList.put(idNum, newEdge);

		nodeTable.get(sLabel).addEdgeOut(newEdge);
		nodeTable.get(dLabel).addEdgeIn(newEdge);

		numEdges++;

		return true;
	}

	@Override
	public boolean delNode(String label) {

		if (!nodeTable.containsKey(label)) {
			return false;
		}

		HashMap<String, Edge> edgesIn = nodeTable.get(label).getEdgesIn();
		HashMap<String, Edge> edgesOut = nodeTable.get(label).getEdgesOut();
		for (String key : edgesIn.keySet()) {
			nodeTable.get(key).delEdgeOut(label);
		}

		for (String key : edgesOut.keySet()) {

			nodeTable.get(key).delEdgeIn(label);
		}

		nodeNumList.remove(nodeTable.get(label).getId());
		nodeTable.remove(label);
		numNodes--;
		return true;

	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {

		if (!edgeTable.containsKey(sLabel + dLabel)) {
			return false;
		}

		nodeTable.get(sLabel).delEdgeOut(dLabel);
		nodeTable.get(dLabel).delEdgeIn(sLabel);
		edgeNumList.remove(edgeTable.get(sLabel + dLabel).getId());
		edgeTable.remove(sLabel + dLabel);
		numEdges--;
		return true;
	}

	@Override
	public long numNodes() {

		return numNodes;
	}

	@Override
	public long numEdges() {

		return numEdges;
	}

	@Override
	public String[] topoSort() {

		String[] toReturn = new String[(int) numNodes];
		Node toHold;
		int count=0;
		
		while (numNodes!=0){
			toHold=findNodeIndegree0();
			if(toHold==null){
				return null;
			}
			toReturn[count]=toHold.getName();
			delNode(toHold.getName());
			count++;
		}
		
	
		return toReturn;
	}

	// rest of your code to implement the various operations
	
	private Node findNodeIndegree0(){
		
		Node toReturn=null;
		for(Node value : nodeTable.values()){
			if(value.getInDegree()==0){
				toReturn=value;
			}
		}
		
		return toReturn;
	}
}
