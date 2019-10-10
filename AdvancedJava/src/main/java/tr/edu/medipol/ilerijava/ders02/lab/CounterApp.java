package tr.edu.medipol.ilerijava.ders02.lab;

public class CounterApp {

	public static void main(String[] args) throws InterruptedException {
		
		Countdown t1 = new Countdown("T1",10000);
		t1.start();
		Countdown t2 = new Countdown("T2",5000);
		t2.start();
		Countdown t3 = new Countdown("T3",1453);
		t3.start();
		Countdown t4 = new Countdown("T4",40000);
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		// 56453
		System.out.println(Countdown.TOTAL_COUNT);
		
	}

}
