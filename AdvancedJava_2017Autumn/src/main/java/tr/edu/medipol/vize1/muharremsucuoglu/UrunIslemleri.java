package tr.edu.medipol.vize1.muharremsucuoglu;

// import mainapp.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UrunIslemleri extends Urun {


    private JFrame frames;
    private JTextField urunAdi, urunKategori, urunID, urunFiyat, urunSil;
    private JRadioButton rb3;

    private ArrayList<Urun> urunListesi;

    public UrunIslemleri() {

        JLabel ekleBaslik, urunAdiBasligi, urunIDBasligi, urunFiyatBasligi, urunKategoriBasligi, silBaslik, urunSilBasligi;
        urunListesi = new ArrayList<>();

        frames = new JFrame("-- MAĞAZA STOK YÖNETİM SİSTEMİ --");


        ekleBaslik = new JLabel("Urun Ekleyin");
        ekleBaslik.setBounds(50, 15, 250, 35);
        frames.add(ekleBaslik);


        urunAdiBasligi = new JLabel("Urun Adı");
        urunAdiBasligi.setBounds(50, 35, 250, 35);

        urunAdi = new JTextField("");
        urunAdi.setBounds(50, 60, 250, 35);
        frames.add(urunAdi);

        urunKategoriBasligi = new JLabel("Ürünün Kategorisini Girin");
        urunKategoriBasligi.setBounds(50, 95, 250, 35);

        urunKategori = new JTextField("");
        urunKategori.setBounds(50, 120, 250, 35);
        frames.add(urunKategori);

        urunIDBasligi = new JLabel("Ürün İd");
        urunIDBasligi.setBounds(50, 155, 250, 35);

        urunID = new JTextField("");
        urunID.setBounds(50, 185, 250, 35);
        frames.add(urunID);


        urunFiyatBasligi = new JLabel("Ürün Fiyatı");
        urunFiyatBasligi.setBounds(50, 225, 250, 35);

        urunFiyat = new JTextField("");
        urunFiyat.setBounds(50, 255, 250, 35);
        frames.add(urunFiyat);

        silBaslik = new JLabel("Ürün Silin");
        silBaslik.setBounds(400, 15, 250, 35);
        frames.add(silBaslik);

        urunSilBasligi = new JLabel("Ürün ID Silin");
        urunSilBasligi.setBounds(400, 95, 250, 35);

        urunSil = new JTextField("");
        urunSil.setBounds(400, 120, 250, 35);
        frames.add(urunSil);

        rb3 = new JRadioButton(" Listele");
        rb3.setBounds(750, 190, 300, 30);
        frames.add(rb3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb3);

        JButton listeleButton = new JButton("Uygula");
        listeleButton.setBounds(750, 295, 250, 35);
        frames.add(listeleButton);

        listeleButton.addActionListener((ActionEvent e) -> {

            if (bg.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Lütfen Seçim Yapınız");

            } else if (rb3.isSelected()) {
                new UrunListeleme();
            }
        });

        frames.add(urunAdiBasligi);
        frames.add(urunIDBasligi);
        frames.add(urunFiyatBasligi);
        frames.add(urunKategoriBasligi);
        frames.add(urunSilBasligi);

        JButton geriButton = new JButton("<--");
        geriButton.setBounds(50, 500, 250, 35);
        frames.add(geriButton);
        geriButton.addActionListener(e -> {

            MainMenu.createFrame();
            frames.setVisible(false);
        });

        JButton silButton = new JButton("Ürünı Sil");
        silButton.setBounds(400, 295, 250, 35);
        frames.add(silButton);
        silButton.addActionListener((ActionEvent e) -> {
            try {


                FileWriter fw = new FileWriter("urunler.txt", false);
                PrintWriter pw = new PrintWriter(fw);

                urunListesi.removeIf(user -> String.valueOf(user.getUrunID()).equalsIgnoreCase(urunSil.getText()));

                pw.println(urunListesi);

                JOptionPane.showMessageDialog(null, "Ürün Listeye Kayıt Edildi...");

                pw.close();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        JButton ekleButton = new
                JButton("Ürünı Ekle");
        ekleButton.setBounds(50, 295, 250, 35);
        frames.add(ekleButton);
        ekleButton.addActionListener(e ->

        {
            try {
                FileWriter fw = new FileWriter("urunler.txt", true);
                PrintWriter pw = new PrintWriter(fw);


                String adiText = urunAdi.getText();
                String kategoriText = urunKategori.getText();
                int idText = Integer.parseInt(urunID.getText());
                String urunFiyatText = urunFiyat.getText();

                Urun urun = new Urun();
                urun.setUrunAdi(adiText);
                urun.setUrunKategori(kategoriText);
                urun.setUrunID(idText);
                urun.setUrunFiyat(urunFiyatText);


                urunListesi.add(urun);
                pw.println(urunListesi);

                JOptionPane.showMessageDialog(null, "Ürün Listeye Kayıt Edildi...");

                pw.close();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        frames.setSize(1024, 768);
        frames.setLayout(null);
        frames.setVisible(true);


    }
}