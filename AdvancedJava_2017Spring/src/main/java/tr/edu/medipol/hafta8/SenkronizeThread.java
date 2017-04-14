package tr.edu.medipol.hafta8;
public class SenkronizeThread {
	private static Object kilit = new Object();
	public static void main(String[] args) {
		new ThreadTest("Thread-1").start();
		new ThreadTest("Thread-2").start();
	}
	public static void islemYap(String threadIsmi) {
		try {
			synchronized (kilit) {
				System.out.println(threadIsmi + "Islem basladi... ");
				Thread.sleep(5000); // 1 sn bekle
				System.out.println(threadIsmi + "Islem tamamlandi... ");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class ThreadTest extends Thread {
	String threadIsmi;
	public ThreadTest(String str) {
		super(str);
		threadIsmi = str;
	}

	public void run() {
		while(true) {
			SenkronizeThread.islemYap(threadIsmi);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}














