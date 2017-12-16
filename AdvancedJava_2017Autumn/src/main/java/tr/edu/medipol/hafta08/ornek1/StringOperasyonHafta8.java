package tr.edu.medipol.hafta08.ornek1;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author bprlab
 * @version 8.0.0
 */
public class StringOperasyonHafta8 {

    public static void main(String[] args) {
        StringOperasyonHafta8 doc = new StringOperasyonHafta8();
        String buyukHarf = doc.buyukHarfYap("Merhaba");
    }

    /**
     * Verilen parametreyi buyuk harf olarak dondurecek metod
     *
     * @param mesaj parametre string, null olamaz
     * @return mesaj stringindeki karakterleri buyuk harfe cevirir
     */
    public String buyukHarfYap(String mesaj) {
        return mesaj.toUpperCase(new Locale("TR", "TR"));
    }

    /**
     * This method returns the square of num. This is a multiline description.
     * You can use as many lines as you like.
     *
     * @param num The value to be squared.
     * @return num squared.
     */
    public double square(double num) {
        return num * num;
    }

    /**
     * This method inputs a number from the user.
     *
     * @return The value input as a double. 
     * @see IOException
     */
    public double getNumber() {
        Scanner inData = new Scanner(System.in);
        String str = inData.nextLine();
        return Double.parseDouble(str);
    }

}
    