import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
	
	private final int HEAPMAXSIZE = 100;
	private final int NUMBRANCHES = 2; // each node has left and right child
	public Process[] heap;
	private int heapSize;
	
	/**
	 * Creates the MaxHeap data structure
	 */
	public MaxHeap() {
		
		heap = new Process[HEAPMAXSIZE];	
		heapSize = 0;	
	}
	
	public boolean isEmpty(){
        return (heapSize==0);
    }
	
	 public boolean isFull(){
	    return (heapSize == heap.length);
	 }
	
	 public int getHeapSize() {
		 return heapSize;
	 }
	 
	 public void insert(Process aProcess){
        if(isFull())
            throw new NoSuchElementException("Heap is full, No space to insert new element");
       
        heap[heapSize] = aProcess;
        heapSize++;
        if (heapSize > 1) { // don't need to heapify up if there is only one node
        		heapifyUp(heap, heapSize-1);
        }
	  }
	 
	 /**
	  *  This will delete element at index x
	  *  
	  */
	 public Process delete(int x){
        if(isEmpty())
            throw new NoSuchElementException("Heap is empty, No element to delete");
        Process aProcess = heap[x];
        
        heap[x] = heap[heapSize -1];
        heapSize--;
        heapifyDown(x);
        return aProcess;
    }
	 
	  
	 /**
	  * This will recursively heapify going up
	  * @param heap
	  * @param i - the current node (a parent)
	  */
	  public void heapifyUp(Process heap[], int i) {
		  if (i > 0) {
			  int p = parent(i);
			  if ((heap[i].compareTo(heap[p]) >= 1)) {
				  // swap the data at i and p
				  Process temp = heap[i];
				  heap[i] = heap[p];
				  heap[p] = temp;
				  heapifyUp(heap, p);
			  }
		  }
	  }

	      
    /**
     *  This method used to maintain the heap property while deleting an element.
     * 
     */
    public void heapifyDown(int i){
        int child;

        while(leftChild(i) < heapSize){
            child = maxChild(i);
            if(heap[i].compareTo(heap[child]) <= -1){
            	 Process temp = heap[i];
            	 heap[i] = heap[child];
                heap[child] = temp;
            }else 
                break;       
            i = child;
        }
    }
	  
//	  // This doesn't work
//	  public void heapifyDown(Process heap[], int i){
//		  int size = heap.length;
//		  int child = 0;
//		  if ( NUMBRANCHES*i > size || i == 0)
//		  {
//			  return;
//		  } else if ( NUMBRANCHES*i < size) {
//			  child = maxChild(i);
//		  } 
////		  else if (NUMBRANCHES*i == size) {
////			  
////			  child = NUMBRANCHES*i;
////		  }
//		 
//		  if(heap[i].compareTo(heap[child]) <= -1) {
//			  // need to swap
//			  Process temp = heap[i];
//			  heap[i] = heap[child];
//			  heap[child] = temp;		  
//		  }	
//		  heapifyDown(heap, child);
//	  }
	    
    /**
     * 
     * @param i - a parent index 
     * @return the index of the largest child
     */
    private int maxChild(int i) {

        if (heap[leftChild(i)].compareTo(heap[rightChild(i)]) >= 1)
			return leftChild(i);
		else
			return rightChild(i);
    }
    
    private int parent(int i){
	    return (i-1)/NUMBRANCHES;
	 }
	 
     private int leftChild(int i)
     {
    	 	return NUMBRANCHES*i + 1;
     }
     
     private int rightChild(int i) {
    	 	return NUMBRANCHES*i + 2;
     }
	 
	    
    /**
     *  This method returns the max element of the heap.
     *  complexity: O(1)
     */
     public Process findMax(){
         if(isEmpty())
             throw new NoSuchElementException("Heap is empty.");
         return heap[0];
     }
	     
     /**
      *  This method used to print all element of the heap
      * 
      */
     public void printHeap() {
         System.out.print("\nHeap = ");
         for (int i = 0; i < heapSize; i++)
                 System.out.print(heap[i].getArrivalTime() +" " + heap[i].getArrivalTime());
         System.out.println();
     }

}
