package tr.edu.medipol.vizeproje.alican_celik;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListelemeSayfasi extends JFrame implements DosyaIslemleri {
    JTable KitapTablosu = new JTable();
    JButton ekle = new JButton("Ekle");
    JButton sil = new JButton();
    JLabel hata = new JLabel("onay vermeden tıklayamazsınız");
    JTextField id_text = new JTextField();
    JTextField yayinevi_text = new JTextField();
    JTextField yazaradi_text = new JTextField();
    JTextField kitapadi_text = new JTextField();
    JTextField kitapturu_text = new JTextField();
    JTextField sayfasayisi_text = new JTextField();
    JCheckBox onay = new JCheckBox();
    JComboBox yayinevleri_combobox = new JComboBox();

    JLabel yayinevi_label = new JLabel("Yayınevi");
    JLabel idlabel = new JLabel("ID");
    JLabel yazaradi_label = new JLabel("YazarAdı");
    JLabel kitapadi_label = new JLabel("KitapAdı");
    JLabel kitapturu_label = new JLabel("KitapTürü");
    JLabel sayfasayisi_label = new JLabel("SayfaSayısı");

JButton yayinevi_buton = new JButton("Yayinevi");

    public ListelemeSayfasi() {


        this.setLayout(null);
        this.setTitle("Kitaplık");
        this.setSize(800, 700);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(KitapTablosu);

        KitapTablosu.setBounds(0, 50, 400, 600);
        KitapTablosu.setVisible(true);
        this.add(yayinevleri_combobox);
        this.add(ekle);
        this.add(sil);
        this.add(id_text);
        //this.add(yayinevi_text);
        this.add(yazaradi_text);
        this.add(kitapadi_text);
        this.add(kitapturu_text);
        this.add(sayfasayisi_text);
        this.add(onay);
        this.add(idlabel);
        this.add(yayinevi_label);
        this.add(yazaradi_label);
        this.add(kitapadi_label);
        this.add(kitapturu_label);
        this.add(sayfasayisi_label);
        this.add(yayinevi_buton);

        id_text.setBounds(470, 50, 150, 50);
        //yayinevi_text.setBounds(470, 110, 150, 50);
        yazaradi_text.setBounds(470, 170, 150, 50);
        kitapadi_text.setBounds(470, 230, 150, 50);
        kitapturu_text.setBounds(470, 290, 150, 50);
        sayfasayisi_text.setBounds(470, 350, 150, 50);
        ekle.setBounds(470, 500,150, 50);
        hata.setBounds(470, 50, 40, 100);
        onay.setBounds(450, 500, 50, 50);
        yayinevleri_combobox.setBounds(470, 110, 150, 50);

        String denemecombobox[] = {"can yayınevi","asdasd yayınevi"};
        ComboBoxModel model = new DefaultComboBoxModel(denemecombobox);
        yayinevleri_combobox.setModel(model);

        onay.setVisible(true);
        hata.setVisible(false);
        idlabel.setVisible(true);
        yayinevi_label.setVisible(true);
        yazaradi_label.setVisible(true);
        kitapadi_label.setVisible(true);
        kitapturu_label.setVisible(true);
        sayfasayisi_label.setVisible(true);

        idlabel.setBounds(420,50,150,50);
        yayinevi_label.setBounds(420,110,150,50);
        yazaradi_label.setBounds(420,170,150,50);
        kitapadi_label.setBounds(420,230,150,50);
        kitapturu_label.setBounds(420,290,150,50);
        sayfasayisi_label.setBounds(420,350,150,50);

        yayinevi_buton.setBounds(650,0,150,50);
        yayinevi_buton.addActionListener((ActionEvent s1) -> {
          YayineviTablo ps = new YayineviTablo();
            Oku( "C:\\Users\\alica\\Desktop\\Yayinevi.txt");
            this.dispose();


        });


        ekle.addActionListener((ActionEvent s) -> {

            hata.setVisible(true);
            while (onay.isSelected()) {
                hata.setVisible(false);
                try {
                    // OZKANS DUZELTME TabloEkle("C:\\Users\\alica\\Desktop\\kitap.txt");
                	/* OZKANS DUZELTME */ TabloEkle(".\\config\\kitap.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                // OZKANS DUZELTME Oku("C:\\Users\\alica\\Desktop\\kitap.txt");
            	/* OZKANS DUZELTME */ Oku(".\\config\\kitap.txt");
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
        String[][] kitaplarDizisi = new String[100][7];
        for (String var : deneme) {
            if (sutun % 7 == 0) {
                satir++;
            }
            kitaplarDizisi[satir][sutun] = var;
            sutun++;
            if (sutun == 6) {
                sutun = 0;
            }
        }
        int i, j;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print(kitaplarDizisi[i][j] + " ");
            }

            System.out.println();
            String[] kitaplarinBasliklari = {"ID", "Yayinevi", "YazarAdi", "KitapAdi", "KitapTuru", "SayfaSayisi"};
            TableModel tablemodel = new DefaultTableModel(kitaplarDizisi, kitaplarinBasliklari);
            KitapTablosu.setModel(tablemodel);

        }
    }

    @Override
    public void TabloEkle(String dosyaYolu) throws IOException {

        File dosya = new File(dosyaYolu); // yazimda kullanilacak File nesnesi

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(dosya, true));


            System.out.println("Kayıt oluşturuldu!!!");
            printWriter.format(id_text.getText()+"#"+yayinevleri_combobox.getSelectedItem()+"#"+yazaradi_text.getText()+"#"+kitapadi_text.getText()+"#"+kitapturu_text.getText()+"#"+sayfasayisi_text.getText()).println();
            sayfasayisi_text.setText("");
            kitapturu_text.setText("");
            kitapadi_text.setText("");
            yazaradi_text.setText("");
            yayinevi_text.setText("");
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
        Kitap kitap = new Kitap();
            ListelemeSayfasi ls = new ListelemeSayfasi();
            
            // OZKANS DUZELTME ls.Oku("C:\\Users\\alica\\Desktop\\kitap.txt");
        	/* OZKANS DUZELTME */ ls.Oku(".\\config\\kitap.txt");
        }


    }


