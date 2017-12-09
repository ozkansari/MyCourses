package tr.edu.medipol.vize1.recepsezeraydogan_atakantalay_cemhanoglu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListelemeSayfasi extends JFrame implements DosyaIslemleri {
    JTable urunlerTablosu = new JTable();
    JButton ekle = new JButton("Ekle");
    JButton sil = new JButton();
    JLabel hata = new JLabel("onay vermeden tıklayamazsınız");
    JTextField id_text = new JTextField();
    JTextField marka_text = new JTextField();
    JTextField model_text = new JTextField();
    JTextField urunadi_text = new JTextField();
    JTextField fiyat_text = new JTextField();
    JTextField stok_text = new JTextField();
    JCheckBox onay = new JCheckBox();

    JLabel isimlabel = new JLabel("Marka");
    JLabel idlabel = new JLabel("ID");
    JLabel soyisimlabel = new JLabel("Model");
    JLabel konumlabel = new JLabel("Ürün Adı");
    JLabel telnolabel = new JLabel("Fiyat");
    JLabel vardiyalabel = new JLabel("Stok");

JButton personel_buton = new JButton("Personel");

    public ListelemeSayfasi() {


        this.setLayout(null);
        this.setTitle("Mağaza2");
        this.setSize(800, 700);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(urunlerTablosu);

        urunlerTablosu.setBounds(0, 50, 400, 600);
        urunlerTablosu.setVisible(true);

        this.add(ekle);
        this.add(sil);
        this.add(id_text);
        this.add(marka_text);
        this.add(model_text);
        this.add(urunadi_text);
        this.add(fiyat_text);
        this.add(stok_text);
        this.add(onay);
        this.add(idlabel);
        this.add(isimlabel);
        this.add(soyisimlabel);
        this.add(konumlabel);
        this.add(telnolabel);
        this.add(vardiyalabel);
        this.add(personel_buton);

        id_text.setBounds(470, 50, 150, 50);
        marka_text.setBounds(470, 110, 150, 50);
        model_text.setBounds(470, 170, 150, 50);
        urunadi_text.setBounds(470, 230, 150, 50);
        fiyat_text.setBounds(470, 290, 150, 50);
        stok_text.setBounds(470, 350, 150, 50);
        ekle.setBounds(470, 500,150, 50);
        hata.setBounds(470, 50, 40, 100);
        onay.setBounds(450, 500, 50, 50);

        onay.setVisible(true);
        hata.setVisible(false);
        idlabel.setVisible(true);
        isimlabel.setVisible(true);
        soyisimlabel.setVisible(true);
        konumlabel.setVisible(true);
        telnolabel.setVisible(true);
        vardiyalabel.setVisible(true);

        idlabel.setBounds(420,50,150,50);
        isimlabel.setBounds(420,110,150,50);
        soyisimlabel.setBounds(420,170,150,50);
        konumlabel.setBounds(420,230,150,50);
        telnolabel.setBounds(420,290,150,50);
        vardiyalabel.setBounds(420,350,150,50);

        personel_buton.setBounds(650,0,150,50);
        personel_buton.addActionListener((ActionEvent sezer1) -> {
          PersonelTab ps = new PersonelTab();
            Oku( "Personel.txt");
            this.dispose();


        });


        ekle.addActionListener((ActionEvent sezer) -> {

            hata.setVisible(true);
            while (onay.isSelected()) {
                hata.setVisible(false);
                try {
                    TabloEkle("Stok.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Oku("Stok.txt");
                System.out.println("bana bastın");

                break;
            }
        });

    }


    @Override
    public void Oku(String ds) {
        ArrayList<String> deneme = new ArrayList<String>();

        File file = new File(ds);
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
        int i, j;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print(urunlerDizisi[i][j] + " ");
            }

            System.out.println();
            String[] urunlerinBasliklari = {"ID", "Marka", "Model", "Urunadi", "Fiyat", "Stok"};
            TableModel tablemodel = new DefaultTableModel(urunlerDizisi, urunlerinBasliklari);
            urunlerTablosu.setModel(tablemodel);

        }
    }

    @Override
    public void TabloEkle(String dosyaYolu) throws IOException {

        File dosya = new File(dosyaYolu); // yazimda kullanilacak File nesnesi

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(dosya, true));
//ID#Marka#Model#Urun Adi#Fiyat#Stok

            printWriter.format(id_text.getText()+"#"+marka_text.getText()+"#"+model_text.getText()+"#"+urunadi_text.getText()+"#"+fiyat_text.getText()+"#"+stok_text.getText()).println();
            stok_text.setText("");
            fiyat_text.setText("");
            urunadi_text.setText("");
            model_text.setText("");
            marka_text.setText("");
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
    } {

    }

    @Override
    public void TabloSil(String ds) {

    }


    public static void main(String[] args) {
//        ListelemeSayfasi sayfa2 = new ListelemeSayfasi();
        Urun urun = new Urun();
        try {
            urun.setFiyat(-1);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Fiyat 0 veya daha düşük olamaz");
            ListelemeSayfasi ls = new ListelemeSayfasi();
            ls.Oku("Stok.txt");
        }


    }

}
