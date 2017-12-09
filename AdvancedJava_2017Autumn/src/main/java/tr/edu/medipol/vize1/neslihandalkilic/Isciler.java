package tr.edu.medipol.vize1.neslihandalkilic;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Isciler extends IsciBilgi {

    private ArrayList<IsciBilgi> isciBilgiListesi;

    Isciler() {


        isciBilgiListesi = new ArrayList<>();

        JFrame frames = new JFrame("Neslihanın Mağazası");
        JTextField calisan_adi, calisan_no, calisan_pozisyonu, calisanSilin;
        JButton ekleButton, silbutton, geriButton;
        JLabel baslik, l1, l2, l3, l5, baslik2;
        baslik = new JLabel("Çalışan Ekleyin");
        baslik.setBounds(500, 110, 300, 30);
        frames.add(baslik);


        l1 = new JLabel("Çalışan Adı");
        l1.setBounds(500, 150, 300, 30);
        frames.add(l1);
        calisan_adi = new JTextField("");
        calisan_adi.setBounds(500, 190, 300, 30);
        frames.add(calisan_adi);

        l2 = new JLabel("Çalışan No");
        l2.setBounds(500, 230, 300, 30);
        frames.add(l2);
        calisan_no = new JTextField("");
        calisan_no.setBounds(500, 270, 300, 30);
        frames.add(calisan_no);


        l3 = new JLabel("Çalışan Pozisyonu");
        l3.setBounds(500, 310, 210, 35);
        frames.add(l3);
        calisan_pozisyonu = new JTextField("");
        calisan_pozisyonu.setBounds(500, 350, 250, 35);
        frames.add(calisan_pozisyonu);

        ekleButton = new JButton("Çalışanı Ekle");
        ekleButton.setBounds(500, 390, 250, 35);
        frames.add(ekleButton);
        JTextField calisanAdi = calisan_adi;

        baslik2 = new JLabel("Çalışanı Silin");
        baslik2.setBounds(500, 430, 250, 35);
        frames.add(baslik2);

        l5 = new JLabel("Çalışan Numarası");
        l5.setBounds(500, 470, 250, 35);

        calisanSilin = new JTextField("");
        calisanSilin.setBounds(500, 510, 250, 35);
        frames.add(calisanSilin);






        ekleButton.addActionListener(e -> {

            try {
                FileWriter fw = new FileWriter("isciler.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                String isim = calisanAdi.getText();
                int numara = Integer.parseInt(calisan_no.getText());
                String calisanPozisyonu = calisan_pozisyonu.getText();
                IsciBilgi isciBilgi = new IsciBilgi();
                isciBilgi.setAdi(isim);
                isciBilgi.setCalisanNo(numara);
                isciBilgi.setCalisanTipi(calisanPozisyonu);
                isciBilgiListesi.add(isciBilgi);
                pw.println(isciBilgiListesi);
                pw.close();


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });




        silbutton = new JButton("Çalışanı Sil");
        silbutton.setBounds(500, 550, 250, 35);
        frames.add(silbutton);
        silbutton.addActionListener(e -> {
            try {
                FileWriter fw = new FileWriter("isciler.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                isciBilgiListesi.removeIf(user -> String.valueOf(user.getCalisanNo()).equalsIgnoreCase(baslik2.getText()));
                pw.println(isciBilgiListesi);

                pw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        geriButton = new JButton("Anasayfaya Dön");
        geriButton.setBounds(750, 590, 250, 35);
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
