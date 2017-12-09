package tr.edu.medipol.vize1.aykutyilmaz;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Calisanlar extends Personel {

    private ArrayList<Personel> personelListesi;

    Calisanlar() {


        personelListesi = new ArrayList<>();

        JFrame frames = new JFrame("PROGRAMIM");
        JTextField calisan_adi, calisan_no, calisan_pozisyonu, calisanSilin;
        JButton ekleButton, silbutton, geriButton;
        JLabel baslik, l1, l2, l3, l5, baslik2;
        baslik = new JLabel("Calısan Ekleyin");
        baslik.setBounds(50, 15, 250, 35);
        frames.add(baslik);


        l1 = new JLabel("Calısan Adi");
        l1.setBounds(50, 35, 250, 35);
        frames.add(l1);
        calisan_adi = new JTextField("");
        calisan_adi.setBounds(50, 60, 250, 35);
        frames.add(calisan_adi);

        l2 = new JLabel("Calısan No");
        l2.setBounds(50, 155, 250, 35);
        frames.add(l2);
        calisan_no = new JTextField("");
        calisan_no.setBounds(50, 185, 250, 35);
        frames.add(calisan_no);


        l3 = new JLabel("Calısan Pozisyonu");
        l3.setBounds(50, 225, 250, 35);
        frames.add(l3);
        calisan_pozisyonu = new JTextField("");
        calisan_pozisyonu.setBounds(50, 245, 250, 35);
        frames.add(calisan_pozisyonu);

        ekleButton = new JButton("Calısanı Ekle");
        ekleButton.setBounds(50, 295, 250, 35);
        frames.add(ekleButton);
        JTextField calisanAdi = calisan_adi;

        ekleButton.addActionListener(e -> {

            try {
                FileWriter fw = new FileWriter("calisanlar.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                String isim = calisanAdi.getText();
                int numara = Integer.parseInt(calisan_no.getText());
                String calisanPozisyonu = calisan_pozisyonu.getText();
                Personel personel = new Personel();
                personel.setAdi(isim);
                personel.setCalisanNo(numara);
                personel.setCalisanTipi(calisanPozisyonu);
                personelListesi.add(personel);
                pw.println(personelListesi);
                pw.close();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        baslik2 = new JLabel("Calısanı Silin");
        baslik2.setBounds(400, 15, 250, 35);
        frames.add(baslik2);


        l5 = new JLabel("Calisan Numarasi");
        l5.setBounds(400, 35, 250, 35);

        calisanSilin = new JTextField("");
        calisanSilin.setBounds(400, 60, 250, 35);
        frames.add(calisanSilin);

        silbutton = new JButton("Calısani Sil");
        silbutton.setBounds(400, 295, 250, 35);
        frames.add(silbutton);
        silbutton.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("calisanlar.txt", false);
                PrintWriter pw = new PrintWriter(fw);
                personelListesi.removeIf(user -> String.valueOf(user.getCalisanNo()).equalsIgnoreCase(baslik2.getText()));
                pw.println(personelListesi);

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
