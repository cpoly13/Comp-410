package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private int hole; //CP tracks current hole location
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                            //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

@Override
public void insert(EntryPair entry) {
	// TODO Auto-generated method stub
	hole=size+1;
	if(size==0){
		array[1]=entry;
	}
	
	else{
		if(array[hole-1].getPriority()<=entry.getPriority()){
			array[hole]=entry;
		}
		
		else{
			while(array[hole].getPriority()>entry.getPriority()){
				hole=hole/2;
			}
			
			array[hole]=entry;
			
		}
	}
	
	
}

@Override
public void delMin() {
	// TODO Auto-generated method stub
	
}

@Override
public EntryPair getMin() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public void build(EntryPair[] entries) {
	// TODO Auto-generated method stub
	
}
}
