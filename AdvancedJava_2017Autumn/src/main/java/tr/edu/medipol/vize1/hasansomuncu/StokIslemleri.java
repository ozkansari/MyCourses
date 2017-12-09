package tr.edu.medipol.vize1.hasansomuncu;

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
        baslik = new JLabel("STOKKK Ekleyin");
        baslik.setBounds(500, 110, 300, 30);
        frames.add(baslik);


        l1 = new JLabel("STOKKK Adı");
        l1.setBounds(500, 150, 300, 30);
        frames.add(l1);
        urun_adi = new JTextField("");
        urun_adi.setBounds(500, 190, 300, 30);
        frames.add(urun_adi);

        l2 = new JLabel("STOKKK No");
        l2.setBounds(500, 230, 300, 30);
        frames.add(l2);
        urun_no = new JTextField("");
        urun_no.setBounds(500, 270, 300, 30);
        frames.add(urun_no);


        l3 = new JLabel("STOKKK Tipi");
        l3.setBounds(500, 310, 300, 30);
        frames.add(l3);
        urun_tipi = new JTextField("");
        urun_tipi.setBounds(500, 350, 210, 35);
        frames.add(urun_tipi);

        ekleButton = new JButton("STOKKK Ekle");
        ekleButton.setBounds(500, 390, 250, 35);
        frames.add(ekleButton);
        JTextField urunAdi = urun_adi;

        ekleButton.addActionListener(e -> {

            try {
                FileWriter fw = new FileWriter("STOKKK.txt", true);
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


        baslik2 = new JLabel("STOKKK Silin");
        baslik2.setBounds(500, 430, 250, 35);
        frames.add(baslik2);


        l5 = new JLabel("STOKKK ID");
        l5.setBounds(500, 470, 250, 35);

        urunSilin = new JTextField("");
        urunSilin.setBounds(500, 510, 250, 35);
        frames.add(urunSilin);

        silbutton = new JButton("STOKKK Sil");
        silbutton.setBounds(500, 550, 250, 35);
        frames.add(silbutton);
        silbutton.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("STOKKK.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                stokListesi.removeIf(user -> String.valueOf(user.getID()).equalsIgnoreCase(baslik2.getText()));
                pw.println(stokListesi);

                pw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        geriButton = new JButton("<<<<--DÖN-->>>>");
        geriButton.setBounds(50, 50, 250, 35);
        frames.add(geriButton);
        geriButton.addActionListener(e -> {
            new MainMenu();
            frames.setVisible(false);
        });


        frames.setSize(1000, 1000);
        frames.setLayout(null);
        frames.setVisible(true);

    }

}

