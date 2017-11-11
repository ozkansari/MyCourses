package tr.edu.medipol.hafta4;

import java.util.Scanner;

/**
 *
 * @author bprlab
 */
public class Hafta4 {

    public static void main(String[] args) {
        System.out.println("YYYY-MM-DD formatında tarih giriniz:");
        Scanner scn = new Scanner(System.in);
        String tarihGirdi = scn.nextLine();
        System.out.println(tarihGirdi);
    }

}
