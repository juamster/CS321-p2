
public class Process {

	private int arrivalTime;
	private int priorityLevel;
	private int remainingTime;
	private int timeNotProcessed;
	
	/**
	 * Constructor for a process.
	 * @param arrivalTime
	 * @param processTime
	 * @param priorityLevel
	 */
	public Process(int currentTime, int processTime, int priorityLevel) {
		
		this.arrivalTime = currentTime;
		this.remainingTime = processTime;
		this.priorityLevel = priorityLevel;
		this.timeNotProcessed = 0;
		
	}
	
	public int compareTo(Process p) {
//		System.out.println("priority: " + priorityLevel + " other one: " + p.priorityLevel);
		if (priorityLevel > p.priorityLevel) {	
			return 1;	
		} else if (priorityLevel < p.priorityLevel) {
			return -1;
		} else {
			return (p.arrivalTime - arrivalTime);
		}
		
	}
	
	public void resetTimeNotProcessed() {
		this.timeNotProcessed = 0;
		
	}
	
	public int getTimeNotProcessed() {
		return this.timeNotProcessed;
	}
	
	
	public void increaseTimeNotProcessed() {
		this.timeNotProcessed ++;
		
	}
	
	public boolean finish() {
		
		if (remainingTime == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void reduceTimeRemaining()
	{
		remainingTime--;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getTimeRemaining() {
		return remainingTime;
	}
	
	public int getPriority() {
		return priorityLevel;
	}
	
	public void increasePriority() {
		priorityLevel++;
	}
}
