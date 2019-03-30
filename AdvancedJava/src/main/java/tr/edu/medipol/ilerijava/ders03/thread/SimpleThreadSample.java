package tr.edu.medipol.ilerijava.ders03.thread;

public class SimpleThreadSample extends Thread {

	static int counter = 0;

	long sleepTime;

	public SimpleThreadSample(String threadName, long sleepTime) {
		super(threadName);
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		try {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(this.getName() + " running...");

				//synchronized (SimpleThreadSample.class) {
					atomicOperation();
				//}

				Thread.sleep(sleepTime);
			}
			System.out.println(this.getName() + " FINISHED >>>>>");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static synchronized void atomicOperation() throws Exception {
		int tempValue = counter;
		tempValue = tempValue + 1;
		Thread.sleep(1000);
		counter = tempValue;
	}
}
