package tr.edu.medipol.advancedjava.hafta01;

// >"C:\Program Files\Java\jdk1.8.0_66\bin\javac" MyFirstJavaProgram.java
// >"C:\Program Files\Java\jdk1.8.0_66\bin\java" MyFirstJavaProgram 100 200
public class MyFirstJavaProgram {

    private int x;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private static final double PI = 3.14;

    public static void main(String[] args) {
        
        int r = Integer.parseInt(args[3]);
        
        double dairecevre = 2*PI*r;
        int param1 = Integer.parseInt( args[0] );
        int param2 = Integer.parseInt( args[1] );
        
        int toplam = toplamHesapla(param1, param2);
        
        System.out.println(toplam);
    }

    /**
     * @param sayi1
     * @param sayi2
     * @return
     */
    private static int toplamHesapla(int sayi1, int sayi2) {
        int toplam = sayi1 + sayi2;
        return toplam;
    }
    
   
}
