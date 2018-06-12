package tr.edu.medipol.vizeproje.alican_celik;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YayineviTablo extends JFrame implements DosyaIslemleri {
    JTable yayineviTablosu = new JTable();
    JButton ekle = new JButton("Ekle");
    JButton sil = new JButton("Sil");
    JLabel hata = new JLabel("onay vermeden tiklayamazsiniz");
    JButton Kitap_buton = new JButton("Kitaplar");
    JTextField id_text = new JTextField();
    JTextField yayineviadi_text = new JTextField();
    JTextField email_text = new JTextField();
    JCheckBox onay = new JCheckBox();

    JLabel yayinevi_label = new JLabel("Yayinevi");
    JLabel idlabel = new JLabel("ID");
    JLabel email_label = new JLabel("Email");


    public YayineviTablo() {
        this.setLayout(null);
        this.setTitle("Yayinevi");
        this.setSize(800, 700);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(hata);
        this.add(yayineviTablosu);
        this.add(ekle);
        this.add(sil);
        this.add(id_text);
        this.add(yayineviadi_text);
        this.add(email_text);
        this.add(yayineviTablosu);
        this.add(onay);
        this.add(idlabel);
        this.add(yayinevi_label);
        this.add(email_label);
        this.add(Kitap_buton);

        id_text.setBounds(470, 50, 150, 50);
        yayineviadi_text.setBounds(470, 110, 150, 50);
        email_text.setBounds(470, 170, 150, 50);
        ekle.setBounds(470, 500, 150, 50);
        hata.setBounds(470, 50, 40, 100);
        onay.setBounds(450, 500, 50, 50);
        sil.setBounds(470,550,150,50);
        yayineviTablosu.setBounds(0, 50, 400, 600);

        yayineviTablosu.setVisible(true);
        onay.setVisible(true);
        hata.setVisible(false);
        idlabel.setVisible(true);
        yayinevi_label.setVisible(true);
        email_label.setVisible(true);

        idlabel.setBounds(420, 50, 150, 50);
        yayinevi_label.setBounds(420, 110, 150, 50);
        email_label.setBounds(420, 170, 150, 50);
         Kitap_buton.setBounds(650, 0, 150, 50);

        Kitap_buton.addActionListener((ActionEvent sezer1) -> {
            ListelemeSayfasi ls = new ListelemeSayfasi();
            // OZKANS DUZELTME --> Oku("C:\\Users\\SEZER\\Desktop\\Stok.txt");
            /* OZKANS DUZELTME */ Oku(".\\config\\Stok.txt");
            this.dispose();


        });
        sil.addActionListener((ActionEvent sezer1) -> {
            ListelemeSayfasi ls = new ListelemeSayfasi();
            // OZKANS DUZELTME --> TabloSil("C:\\Users\\SEZER\\Desktop\\Yayinevi.txt");
            /* OZKANS DUZELTME */ TabloSil(".\\config\\Yayinevi.txt");


        });

        ekle.addActionListener((ActionEvent sezer) -> {

            hata.setVisible(true);
            while (onay.isSelected()) {
                hata.setVisible(false);
                try {
                	// OZKANS DUZELTME --> TabloEkle("C:\\Users\\SEZER\\Desktop\\Yayinevi.txt");
                	/* OZKANS DUZELTME */ TabloEkle(".\\config\\Yayinevi.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // OZKANS DUZELTME --> Oku("C:\\Users\\SEZER\\Desktop\\Yayinevi.txt");
                /* OZKANS DUZELTME */  Oku(".\\config\\Yayinevi.txt");
                System.out.println("bana bastin");

                break;
            }
        });

    }

    @Override
    public void Oku(String dosyaYolu) {
        ArrayList<String> deneme = new ArrayList<String>();

        File file = new File(dosyaYolu);
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
        String[][] YayineviDizi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 7 == 0) {
                satir++;
            }
            YayineviDizi[satir][sutun] = var;
            sutun++;
            if (sutun == 6) {
                sutun = 0;
            }
        }
        int i, j;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print(YayineviDizi[i][j] + " ");
            }

            System.out.println();
            String[] YayinEviBasliklari = {"ID", "YayineviAdi", "Email"};
            TableModel tablemodel = new DefaultTableModel(YayineviDizi, YayinEviBasliklari);
            yayineviTablosu.setModel(tablemodel);
        }
    }

    @Override
    public void TabloEkle(String ds) throws IOException {

        File dosya = new File(ds); // yazimda kullanilacak File nesnesi

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(dosya, true));

            String mailSablonu = "^[a-zA-Z[ocgisu]]+@medipol.edu.tr$";
            Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE);
            String girilen_email = email_text.getText();
            Matcher eslestirici = sablonNesnesi.matcher(girilen_email);
            boolean eslestiMi = eslestirici.find();
            System.out.println("EslestiMi? " + eslestiMi);

            if (eslestiMi) {
                System.out.println("Found:" + eslestirici.group());

                printWriter.format(id_text.getText() + "#" + yayineviadi_text.getText() + "#" + email_text.getText()).println();
                email_text.setText("");
                yayineviadi_text.setText("");
                id_text.setText("");
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) { // eger bir hata ile karsilasilmamissa ve printWriter nesnesi null degilse
                printWriter.close(); // isimiz bittikten sonra nesneyi close() fonksiyonu ile kapatiyoruz
            }
        }

        Scanner scanner = null; // yazdigimiz dosyayi okumak icin Scanner nesnesi olusturacagiz
        try {
            scanner = new Scanner(dosya); // Scanner nesnesini dosyadan okumak icin ayarliyoruz
            while (scanner.hasNext()) { // Okunacak satir oldugu surece
                String satir = scanner.nextLine(); // satiri oku
                System.out.println(satir); // ekrana yaz
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) { // eger bir hata ile karsilasilmamissa ve scanner nesnesi null degilse
                scanner.close(); // isimiz bittikten sonra nesneyi close() fonksiyonu ile kapatiyoruz
            }
        }
    }


    @Override
    public void TabloSil(String ds) {
        ArrayList<String> deneme = new ArrayList<String>();
        ArrayList<String> joinArray = new ArrayList<String>();
        joinArray.add(id_text.getText());
        joinArray.add(yayineviadi_text.getText());
        joinArray.add(email_text.getText());
        String metinkarsilastirma = null;

        File file = new File(ds);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String satir = reader.readLine();
            int satir_sayac = 1;
            while (satir != null) {
                for (String var : joinArray) {
                    metinkarsilastirma = String.join("#", var);
                }
                if (satir == metinkarsilastirma) {
                    satir_sayac++;
                    satir.equals("");
                }
                satir = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListelemeSayfasi listelemeSayfasi = new ListelemeSayfasi();

        int sutun = 0;
        int satir = 0;
        int yayinevisayac = 0;
        String yayinevleri[] = new String[100];
        String[][] yayinevi_dizisi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 5 == 0) {
                satir++;

            }
            yayinevi_dizisi[satir][sutun] = var;
            sutun++;
            if (sutun == 3) {
                sutun = 0;
            }
        }

    }


    public static void main(String[] args) {
        YayineviTablo yayineviTablo = new YayineviTablo();
        // OZKANS DUZELTME --> yayineviTablo.Oku("C:\\Users\\alica\\Desktop\\Yayinevi.txt");
        /* OZKANS DUZELTME */ yayineviTablo.Oku(".\\config\\Yayinevi.txt");
    }
}


