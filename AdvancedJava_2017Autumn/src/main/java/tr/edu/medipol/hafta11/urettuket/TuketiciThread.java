package tr.edu.medipol.hafta11.urettuket;

public class TuketiciThread implements Runnable {
    private UrunStokKutusu stok = null;
    private int count;
    public TuketiciThread(UrunStokKutusu aQueue, int aCount) {
        count = aCount;
        stok = aQueue;
    }
    public void run() {
        for (int i = 0; i < count; i++) {
            while(stok.isEmpty()) {
                try {
                    synchronized (stok) {
                        System.out.println("Tuketici bekliyor.... Stok bos.");
                        stok.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (stok) {
                stok.notifyAll();
                String item = stok.poll();
                System.out.println("Tuketiyor : " + item);
            }

        }
        System.out.println("Tuketici Thread tamamlandi...");
    }
}
