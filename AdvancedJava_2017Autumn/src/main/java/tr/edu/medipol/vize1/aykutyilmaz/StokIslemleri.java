package tr.edu.medipol.vize1.aykutyilmaz;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StokIslemleri {


    private ArrayList<Stoklar> stokListesi;

    StokIslemleri() {


        stokListesi = new ArrayList<>();

        JFrame frames = new JFrame("PROGRAMIM");
        JTextField urun_adi, urun_no, urun_tipi, urunSilin;
        JButton ekleButton, silbutton, geriButton;
        JLabel baslik, l1, l2, l3, l5, baslik2;
        baslik = new JLabel("Urun Ekleyin");
        baslik.setBounds(50, 15, 250, 35);
        frames.add(baslik);


        l1 = new JLabel("Urun Adi");
        l1.setBounds(50, 35, 250, 35);
        frames.add(l1);
        urun_adi = new JTextField("");
        urun_adi.setBounds(50, 60, 250, 35);
        frames.add(urun_adi);

        l2 = new JLabel("Urun No");
        l2.setBounds(50, 155, 250, 35);
        frames.add(l2);
        urun_no = new JTextField("");
        urun_no.setBounds(50, 185, 250, 35);
        frames.add(urun_no);


        l3 = new JLabel("Urun Tipi");
        l3.setBounds(50, 225, 250, 35);
        frames.add(l3);
        urun_tipi = new JTextField("");
        urun_tipi.setBounds(50, 245, 250, 35);
        frames.add(urun_tipi);

        ekleButton = new JButton("Urun Ekle");
        ekleButton.setBounds(50, 295, 250, 35);
        frames.add(ekleButton);
        JTextField urunAdi = urun_adi;

        ekleButton.addActionListener(e -> {

            try {
                FileWriter fw = new FileWriter("urunler.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                String isim = urunAdi.getText();
                int numara = Integer.parseInt(urun_no.getText());
                String urunTipi = urun_tipi.getText();
                Stoklar stoklar = new Stoklar();
                stoklar.setAdi(isim);
                stoklar.setID(numara);
                stoklar.setTipi(urunTipi);
                stokListesi.add(stoklar);
                pw.println(stokListesi);
                pw.close();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        baslik2 = new JLabel("Urun Silin");
        baslik2.setBounds(400, 15, 250, 35);
        frames.add(baslik2);


        l5 = new JLabel("Urun ID");
        l5.setBounds(400, 35, 250, 35);

        urunSilin = new JTextField("");
        urunSilin.setBounds(400, 60, 250, 35);
        frames.add(urunSilin);

        silbutton = new JButton("Urunu Sil");
        silbutton.setBounds(400, 295, 250, 35);
        frames.add(silbutton);
        silbutton.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("urunler.txt", false);
                PrintWriter pw = new PrintWriter(fw);
                stokListesi.removeIf(user -> String.valueOf(user.getID()).equalsIgnoreCase(baslik2.getText()));
                pw.println(stokListesi);

                pw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        geriButton = new JButton("Anasayfaya Don");
        geriButton.setBounds(750, 295, 250, 35);
        frames.add(geriButton);
        geriButton.addActionListener(e -> {
            new MainMenu();
            frames.setVisible(false);
        });


        frames.setSize(1200, 800);
        frames.setLayout(null);
        frames.setVisible(true);

    }

}

