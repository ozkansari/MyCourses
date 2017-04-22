package tr.edu.medipol.odev2.g4.tayyipemreornek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by teornek on 13/04/2017.
 */
public class Ekle {

    public ArrayList<String> ogrenciListesi;

    public static JFrame f;

    Ekle() {

        ogrenciListesi = new ArrayList<String>();

        f = new JFrame("OgrenciYonetimSistemi");
        JTextField text1, text2, text3, text4;
        JButton buton1, buton2;
        JLabel baslik;

        baslik = new JLabel("! - - - Ogrenci Ekleme Alanı - - - !");
        baslik.setBounds(40, 25, 300, 20);
        f.add(baslik);

        text1 = new JTextField("Ögrenci Adını Giriniz");
        text1.setBounds(25, 60, 250, 30);
        f.add(text1);

        text2 = new JTextField("Ögrenci Numarasını Giriniz");
        text2.setBounds(25, 110, 250, 30);
        f.add(text2);

        text3 = new JTextField("Ögrenci Bölümünü Giriniz");
        text3.setBounds(25, 160, 250, 30);
        f.add(text3);

        text4 = new JTextField("Ögrenci Düzeyini Giriniz");
        text4.setBounds(25, 210, 250, 30);
        f.add(text4);

        buton1 = new JButton("Geri");
        buton1.setBounds(25, 270, 100, 30);
        f.add(buton1);
        buton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gizle();
            }
        });


        buton2 = new JButton("Öğrenci Ekle");
        buton2.setBounds(125, 270, 150, 30);
        f.add(buton2);
        buton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    FileWriter fw = new FileWriter("ogrenciler.txt",true);
                    PrintWriter pw = new PrintWriter(fw);

                    String ad = text1.getText();
                    String numara = text2.getText();
                    String bolum = text3.getText();
                    String duzey = text4.getText();

                    ogrenciListesi.add(ad + " - " + numara + " - " + bolum + " - " + duzey);
                    pw.println(ogrenciListesi);

                    JOptionPane.showMessageDialog(null,"Öğrenci Listeye Kayıt Edildi..." + "\n" + " Anasayfaya Dönülüyor...");

                    pw.close();

                    gizle();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        f.setSize(300, 350);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void gizle() {
        f.setVisible(false);
    }

    public void goster() {
        f.setVisible(true);
    }
}