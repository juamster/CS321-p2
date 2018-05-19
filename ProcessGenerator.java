import java.util.Random;

public class ProcessGenerator {

	public double probability;
	public Random randProcess;
	
	/**
	 * This will create a process with a given probability.  Based
	 * on the probability 
	 * @param probablity
	 */
	public ProcessGenerator(double probability) {
		
		this.probability = probability;
		
		randProcess = new Random();
		
	}
	/**
	 * This will create a process by creating a new instance of a Process object
	 * @param currentTime
	 * @param processTime
	 * @param priorityLevel
	 * @return the process
	 */
	
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		
//		System.out.println("making job: " + currentTime + " , " + maxProcessTime + ", " + maxLevel);
		int processTime = getProcessTime(maxProcessTime);
		int priorityLevel = getPriorityLevel(maxLevel) + 1;
		Process aProcess = new Process(currentTime, processTime, priorityLevel);
		return aProcess;
	}
	
	/**
	 * generates a random amount of processing time for a process
	 * based on maxProcessTime
	 * @param	 integer that is the maximum amount of time a job can run for.
	 * @return
	 */
	private int getProcessTime(int maxProcessTime) {
		Random randTime = new Random();
		int time =  randTime.nextInt(maxProcessTime) + 1;
//		System.out.println("Job processing time: " + time);
		return (time);
	}
	
	/**
	 * generates a random Priority level for a process
	 * based on maxLevel
	 * @param	 integer that is the priority level for the job.
	 * @return
	 */
	private int getPriorityLevel(int maxLevel) {
		Random randPriority = new Random();
		int priority = randPriority.nextInt(maxLevel);
//		System.out.println("Job priority " + priority);
		return (priority);
	}
	
	public boolean query() {
		
		double thisRand = randProcess.nextDouble() * 1.0;
	//	System.out.println("random number based on probablility " + thisRand);
		if (thisRand <= probability) {
			return true;
		} else {
			return false;
		}
		
		
	}
}
