package tr.edu.medipol.hafta11;

public class ThreadOrnegi {
    public static void main(String args[]) {
        new ThreadTest("Thread-1", 1).start();
        new ThreadTest("Thread-2", 2).start();
        new ThreadTest("Thread-3", 3).start();
        new Thread(new RunnableTest("Thread-4", 4)).start();
    }
}
class ThreadTest extends Thread { // extends Thread  arkaplanda yeni akis acma ozelligi kazandiriyor
    int beklemeSuresi;
    public ThreadTest(String str, int beklemeSn) {
        super(str);
        this.beklemeSuresi = beklemeSn * 1000;
    }
    public void run() {
        while(true) {
            System.out.println(getName() + " calisiyor.");
            try {
                sleep(beklemeSuresi);
            } catch (InterruptedException e) {
            }
        }
    }
}
class RunnableTest implements Runnable {
    int beklemeSuresi;
    String isim;
    public RunnableTest(String isim, int beklemeSn) {
        this.isim = isim;
        this.beklemeSuresi = beklemeSn * 1000;
    }
    public void run() {
        while(true) {
            System.out.println(isim + " calisiyor.");
            try {
                Thread.sleep(beklemeSuresi);
            } catch (InterruptedException e) {
            }
        }
    }   
}
