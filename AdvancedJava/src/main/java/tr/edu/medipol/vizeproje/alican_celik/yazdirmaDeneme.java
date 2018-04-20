package tr.edu.medipol.vizeproje.alican_celik;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class yazdirmaDeneme {
    void yazdir(){
        ArrayList<String> deneme = new ArrayList<String>();

        File file = new File("C:\\Users\\alica\\Desktop\\deneme.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String satir = reader.readLine();

            while (satir != null) {
                int i = 0;
                String[] ar = satir.split("#");
                for (String var : ar) {
                    deneme.add(ar[i]);
                    i++;
                }
                satir = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        int sutun = 0;
        int satir = 0;
        String[][] urunlerDizisi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 7 == 0) {
                satir++;
            }
            urunlerDizisi[satir][sutun] = var;
            sutun++;
            if (sutun == 6) {
                sutun = 0;
            }
        }
    }
    public static void main(String[] args) {


        ArrayList<String> deneme = new ArrayList<String>();

        File file = new File("C:\\Users\\alica\\Desktop\\deneme.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String satir = reader.readLine();

            while (satir != null) {
                int i = 0;
                String[] ar = satir.split("#");
                for (String var : ar) {
                    deneme.add(ar[i]);
                    i++;
                }
                satir = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        int sutun = 0;
        int satir = 0;
        String[][] urunlerDizisi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 7 == 0) {
                satir++;
            }
            urunlerDizisi[satir][sutun] = var;
            sutun++;
            if (sutun == 6) {
                sutun = 0;
            }
        }
        int i,j;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print(urunlerDizisi[i][j] + " ");
            }
            System.out.println();
    }
        }}



