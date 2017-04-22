package tr.edu.medipol.odev2.g4.bugraeminburunguz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** ozkans Degerlendirme

Tayyip Emre Ornek ile benzer.

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
 * Created by user on 13.04.2017.
 */
public class MainMenu {
    public static void main(String[] args) {

    JFrame frames;
    JLabel label1, label2;
    JRadioButton rb1, rb2, rb3;
    JButton butto1;

        frames = new JFrame("OgrenciYonetimSistemi");

    label1 = new JLabel("Mebis'e Hoş Geldiniz");
    label1.setBounds(500, 25, 300, 40);
        frames.add(label1);

    label2 = new JLabel("İşlem Seçiniz");
    label2.setBounds(500, 70, 300, 30);
        frames.add(label2);

    rb1 = new JRadioButton(" Ekle");
    rb1.setBounds(500, 110, 300, 30);
        frames.add(rb1);

    rb2 = new JRadioButton("Sil");
    rb2.setBounds(500, 150, 300, 30);
        frames.add(rb2);

    rb3 = new JRadioButton(" Listele");
    rb3.setBounds(500, 190, 300, 30);
        frames.add(rb3);

    ButtonGroup bg = new ButtonGroup();
    bg.add(rb1);
    bg.add(rb2);
    bg.add(rb3);

    butto1 = new JButton("Uygula");
    butto1.setBounds(500, 230, 200, 50);
        frames.add(butto1);

        frames.setSize(1200,  800);
    frames.setLayout(null);
    frames.setVisible(true);

    butto1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            if (bg.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Lütfen Seçim Yapınız");

            } else if (rb1.isSelected()) {
                AddStudent ekle = new AddStudent();

            } else if (rb2.isSelected()) {
                DeleteStudent sil = new DeleteStudent();

            } else if (rb3.isSelected()) {
                ListStudent listele = new ListStudent();
            }
        }
    });
}
}

