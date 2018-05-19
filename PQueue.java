
public class PQueue {

	private MaxHeap queue;
	
	public PQueue() {
		
		queue = new MaxHeap();
	}
	
	/**
	 * See if the priority queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		
		return queue.isEmpty();
	}

	/** 
	 * This will return the highest priority element ( the root )
	 * It needs to update the status of this process
	 * @return
	 */
	public Process dePQueue() {
//		System.out.println("removing element from queue, size: " + queue.getHeapSize() );
		
		Process returnElement = queue.delete(0);

		returnElement.resetTimeNotProcessed();
		return returnElement;		
	}
	
	/**
	 * This needs to update each element in the queue by a time slice 
	 * @param timeToIncrementLevel
	 * @param maxLevel
	 */
	public void update(int timeToIncrementLevel, int maxLevel) {
		for (int i = 0; i < queue.getHeapSize(); i++) {
			Process p = queue.heap[i];
			p.increaseTimeNotProcessed();
			if (p.getTimeNotProcessed() >= timeToIncrementLevel)
			{
				p.resetTimeNotProcessed();
				if (p.getPriority() < maxLevel)
				{
					p.increasePriority();
					queue.heapifyUp(queue.heap, i);
				}
			}
			
		}
		
	}
	
	public void enPQueue(Process p) {
		// TODO:  put the process on the queue
		queue.insert(p);
	}
}
