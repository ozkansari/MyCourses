package tr.edu.medipol.odev2.g4.tayyipemreornek;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/** ozkans Degerlendirme

Bugra Emin Burunguz ile benzer

Ekran: 20/20
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 20/20
Dosyaya Yazma:  20/20
Genel Program: 10/10
Bonus:25/25
--------------------------
SONUC: 125/125
 */

/**
 * Created by teornek on 13/04/2017.
 */
public class Anasayfa {


    public static void main(String[] args) {

        JFrame f;
        JLabel l1, l2;
        JRadioButton r1, r2, r3;
        JButton b1;

        f = new JFrame("OgrenciYonetimSistemi");

        l1 = new JLabel("Ögrenci Yönetim Sistemine Hoş Geldiniz");
        l1.setBounds(25, 25, 300, 40);
        f.add(l1);

        l2 = new JLabel("Yapmak İstediginiz İşlemi Seçiniz.");
        l2.setBounds(35, 70, 300, 30);
        f.add(l2);

        r1 = new JRadioButton("Ögrenci Ekle");
        r1.setBounds(70, 110, 300, 30);
        f.add(r1);

        r2 = new JRadioButton("Ögrenci Sil");
        r2.setBounds(70, 150, 300, 30);
        f.add(r2);

        r3 = new JRadioButton("Ögrenci Listele");
        r3.setBounds(70, 190, 300, 30);
        f.add(r3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        b1 = new JButton("Uygula");
        b1.setBounds(35, 230, 200, 50);
        f.add(b1);

        f.setSize(300, 350);
        f.setLayout(null);
        f.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (bg.isSelected(null)) {
                    JOptionPane.showMessageDialog(null, "Lütfen Seçim Yapınız");

                } else if (r1.isSelected()) {
                    Ekle ekle = new Ekle();

                } else if (r2.isSelected()) {
                    Sil sil = new Sil();

                } else if (r3.isSelected()) {
                    Listele listele = new Listele();
                }
            }
        });
    }
}