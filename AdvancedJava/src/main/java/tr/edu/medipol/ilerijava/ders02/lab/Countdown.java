package tr.edu.medipol.ilerijava.ders02.lab;

public class Countdown extends Thread {

	public static int TOTAL_COUNT = 0;

	private int limit;
	
	public Countdown(String threadName, 
			int limit) {
		super(threadName);
		this.limit = limit;
	}
	
	public void run() {
		for(int i=0;i<limit;i++) {
			operation();
		}
	}

	static synchronized void operation() {
		TOTAL_COUNT++;
	}
}
