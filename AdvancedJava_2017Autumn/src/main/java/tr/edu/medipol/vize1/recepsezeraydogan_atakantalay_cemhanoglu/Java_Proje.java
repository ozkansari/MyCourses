package tr.edu.medipol.vize1.recepsezeraydogan_atakantalay_cemhanoglu;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Java_Proje extends JFrame {
    public Java_Proje() {

        this.setLayout(null);
        this.setTitle("Mağaza Otomasyon - Personel Girişi");
        this.setSize(400, 400);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField personel_isim_text = new JTextField();
        JTextField personel_sifre_text = new JTextField();
        JButton personel_giris_button = new JButton("Giriş");
        JLabel personel_giris_hata = new JLabel("Personel ID'niz yada şifreniz eşleşmiyor.Tekrar deneyin!");
        JLabel giris_text = new JLabel("ID");
        JLabel sifre_text = new JLabel("Şifre");

        this.add(giris_text);
        this.add(sifre_text);
        this.add(personel_giris_button);
        this.add(personel_isim_text);
        this.add(personel_sifre_text);
        this.add(personel_giris_hata);

        personel_giris_hata.setBounds(120, 150, 200, 100);
        giris_text.setBounds(100, 160, 50, 50);
        personel_isim_text.setBounds(120, 170, 150, 30);
        personel_sifre_text.setBounds(120, 210, 150, 30);
        personel_giris_button.setBounds(145, 250, 100, 50);

        personel_giris_hata.setVisible(false);


        personel_giris_button.addActionListener((ActionEvent sezer) -> {
            ListelemeSayfasi sayfa2 = new ListelemeSayfasi();
        });
    }


    public static void main(String[] args) {
        Java_Proje j = new Java_Proje();
    }
}

