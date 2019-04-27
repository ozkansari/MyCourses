package tr.edu.medipol.ilerijava.ders03.thread;

class SimpleThreadSample1 extends Thread {
    private long millisec;
	public SimpleThreadSample1(String str, long ms) {
        super(str);
        this.millisec = ms;
    }
    public void run() {
		try {
			sleep(millisec);
			System.out.println(getName());
		} catch (InterruptedException e) { }
    }
    public static void main (String[] args) {
        new SimpleThreadSample1("FB", 3000).start();
        new SimpleThreadSample1("GS", 2000).start();
    }
}


