package tr.edu.medipol.vize1.recepsezeraydogan_atakantalay_cemhanoglu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonelTab extends JFrame implements DosyaIslemleri {
    JTable personelTablosu = new JTable();
    JButton ekle = new JButton("Ekle");
    JButton sil = new JButton("Sil");
    JLabel hata = new JLabel("onay vermeden tıklayamazsınız");
    JButton stok_buton = new JButton("StokTakip");
    JTextField id_text = new JTextField();
    JTextField isim_text = new JTextField();
    JTextField soyisim_text = new JTextField();
    JTextField konumu_text = new JTextField();
    JTextField telno_text = new JTextField();
    JTextField vardiya_text = new JTextField();
    JCheckBox onay = new JCheckBox();

    JLabel isimlabel = new JLabel("İsim");
    JLabel idlabel = new JLabel("ID");
    JLabel soyisimlabel = new JLabel("Soyisim");
    JLabel konumlabel = new JLabel("Konumu");
    JLabel telnolabel = new JLabel("TelNo");
    JLabel vardiyalabel = new JLabel("Vardiya");

    //ID#ISIM#SOYISIM#KONUMU#TELNO#VARDIYA
    public PersonelTab() {
        this.setLayout(null);
        this.setTitle("Mağaza2");
        this.setSize(800, 700);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(hata);
        this.add(personelTablosu);
        this.add(ekle);
        this.add(sil);
        this.add(id_text);
        this.add(isim_text);
        this.add(soyisim_text);
        this.add(konumu_text);
        this.add(telno_text);
        this.add(vardiya_text);
        this.add(personelTablosu);
        this.add(onay);
        this.add(idlabel);
        this.add(isimlabel);
        this.add(soyisimlabel);
        this.add(konumlabel);
        this.add(telnolabel);
        this.add(vardiyalabel);
        this.add(stok_buton);


        id_text.setBounds(470, 50, 150, 50);
        isim_text.setBounds(470, 110, 150, 50);
        soyisim_text.setBounds(470, 170, 150, 50);
        konumu_text.setBounds(470, 230, 150, 50);
        telno_text.setBounds(470, 290, 150, 50);
        vardiya_text.setBounds(470, 350, 150, 50);
        ekle.setBounds(470, 500, 150, 50);
        hata.setBounds(470, 50, 40, 100);
        onay.setBounds(450, 500, 50, 50);
        sil.setBounds(470,550,150,50);
        personelTablosu.setBounds(0, 50, 400, 600);

        personelTablosu.setVisible(true);
        onay.setVisible(true);
        hata.setVisible(false);
        idlabel.setVisible(true);
        isimlabel.setVisible(true);
        soyisimlabel.setVisible(true);
        konumlabel.setVisible(true);
        telnolabel.setVisible(true);
        vardiyalabel.setVisible(true);

        idlabel.setBounds(420, 50, 150, 50);
        isimlabel.setBounds(420, 110, 150, 50);
        soyisimlabel.setBounds(420, 170, 150, 50);
        konumlabel.setBounds(420, 230, 150, 50);
        telnolabel.setBounds(420, 290, 150, 50);
        vardiyalabel.setBounds(420, 350, 150, 50);
         stok_buton.setBounds(650, 0, 150, 50);

        stok_buton.addActionListener((ActionEvent sezer1) -> {
            ListelemeSayfasi ls = new ListelemeSayfasi();
            Oku("C:\\Users\\SEZER\\Desktop\\Stok.txt");
            this.dispose();


        });
        sil.addActionListener((ActionEvent sezer1) -> {
            ListelemeSayfasi ls = new ListelemeSayfasi();
            TabloSil("C:\\Users\\SEZER\\Desktop\\Personel.txt");



        });

        ekle.addActionListener((ActionEvent sezer) -> {

            hata.setVisible(true);
            while (onay.isSelected()) {
                hata.setVisible(false);
                try {
                    TabloEkle("C:\\Users\\SEZER\\Desktop\\Personel.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Oku("C:\\Users\\SEZER\\Desktop\\Personel.txt");
                System.out.println("bana bastın");

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
        String[][] PersonelDizisi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 7 == 0) {
                satir++;
            }
            PersonelDizisi[satir][sutun] = var;
            sutun++;
            if (sutun == 6) {
                sutun = 0;
            }
        }
        int i, j;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print(PersonelDizisi[i][j] + " ");
            }

            System.out.println();
            String[] PersonelBasliklari = {"ID", "İSİM", "SOYİSİM", "srg", "Fiyat", "Stok"};
            TableModel tablemodel = new DefaultTableModel(PersonelDizisi, PersonelBasliklari);
            personelTablosu.setModel(tablemodel);
        }
    }

    @Override
    public void TabloEkle(String ds) throws IOException {

        File dosya = new File(ds); // yazimda kullanilacak File nesnesi

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(dosya, true));


            printWriter.format(id_text.getText() + "#" + isim_text.getText() + "#" + soyisim_text.getText() + "#" + konumu_text.getText() + "#" + telno_text.getText() + "#" + vardiya_text.getText()).println();
            vardiya_text.setText("");
            telno_text.setText("");
            konumu_text.setText("");
            soyisim_text.setText("");
            isim_text.setText("");
            id_text.setText("");

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
        joinArray.add(isim_text.getText());
        joinArray.add(soyisim_text.getText());
        joinArray.add(konumu_text.getText());
        joinArray.add(telno_text.getText());
        joinArray.add(vardiya_text.getText());
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
        int sutun = 0;
        int satir = 0;
        String[][] PersonelDizisi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 7 == 0) {
                satir++;
            }
            PersonelDizisi[satir][sutun] = var;
            sutun++;
            if (sutun == 6) {
                sutun = 0;
            }
        }
        int i, j;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print(PersonelDizisi[i][j] + " ");
            }
        }
    }


    public static void main(String[] args) {
        PersonelTab ps = new PersonelTab();
        ps.Oku("C:\\Users\\SEZER\\Desktop\\Personel.txt");
    }
}


