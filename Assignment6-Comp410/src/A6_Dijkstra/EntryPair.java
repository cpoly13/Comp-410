package A6_Dijkstra;

public class EntryPair implements EntryPair_Interface {
  public String value;
  public int priority;
  public long lPriority;

  public EntryPair(String aValue, int aPriority) {
    value = aValue;
    priority = aPriority;
  }
  
  public EntryPair(String aValue, long lPriority){
	  value=aValue;
	  this.lPriority=lPriority;
  }

  public String getValue() { return value; }
  public int getPriority() { return priority; }
  public long getLPriority() {return lPriority;}
	  
  }

