package tr.edu.medipol.ilerijava.ders03.thread;

public class TestSimpleThreadSample {
	public static void main(String[] args) throws Exception {
		
		SimpleThreadSample thread1 = new SimpleThreadSample("Thread 1", 3*1000);
		SimpleThreadSample thread2 = new SimpleThreadSample("Thread 2", 2*1000);
		SimpleThreadSample thread3 = new SimpleThreadSample("Thread 3", 1*1000);
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		
		System.out.println(" COUNTER FINAL VALUE : " + SimpleThreadSample.counter );
	}
}
