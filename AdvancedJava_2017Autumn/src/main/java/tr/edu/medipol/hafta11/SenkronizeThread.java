package tr.edu.medipol.hafta11;

public class SenkronizeThread {
    private static Object kilit = new Object();
    public static void main(String[] args) {
        new ThreadTest2("Thread-1").start();
        new ThreadTest2("Thread-2").start();
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
class ThreadTest2 extends Thread {
    private String threadIsmi;
    public ThreadTest2(String threadsmi) {
        super(threadsmi);
        this.threadIsmi = threadsmi;
    }

    public void run() {
        while(true) {
            SenkronizeThread.islemYap(threadIsmi);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

