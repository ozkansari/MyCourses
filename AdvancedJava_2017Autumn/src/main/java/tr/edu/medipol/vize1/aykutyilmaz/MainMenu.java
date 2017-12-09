package tr.edu.medipol.vize1.aykutyilmaz;

import javax.swing.*;
public class MainMenu {

    public static void main(String[] args) {


        JLabel label1, label2;
        JRadioButton rb1, rb2, rb3, rb4, rb5;
        JButton butto1;

        JFrame frames = new JFrame("PROGRAMIM");

        label1 = new JLabel("Magazama HosGeldiniz");
        label1.setBounds(500, 25, 300, 40);
        frames.add(label1);

        label2 = new JLabel("Islem Seciniz");
        label2.setBounds(500, 70, 300, 30);
        frames.add(label2);

        rb1 = new JRadioButton(" Calısan Islemleri");
        rb1.setBounds(500, 110, 300, 30);
        frames.add(rb1);

        rb2 = new JRadioButton("Stok Islemleri");
        rb2.setBounds(500, 150, 300, 30);
        frames.add(rb2);
        rb3 = new JRadioButton("Calısan Listele");
        rb3.setBounds(500, 190, 300, 30);
        frames.add(rb3);
        rb4 = new JRadioButton("Urun Listele");
        rb4.setBounds(500, 230, 300, 30);
        frames.add(rb4);
        rb5 = new JRadioButton("Cıkıs");
        rb5.setBounds(500, 270, 300, 30);
        frames.add(rb5);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        bg.add(rb5);


        butto1 = new JButton("Git");
        butto1.setBounds(500, 310, 200, 50);
        frames.add(butto1);

        frames.setSize(1200, 800);
        frames.setLayout(null);
        frames.setVisible(true);

        JRadioButton finalRb = rb5;
        butto1.addActionListener(e -> {
            if (rb1.isSelected()) {
                new Calisanlar();
                frames.setVisible(true);

            } else if (rb2.isSelected()) {
                new StokIslemleri();
                frames.setVisible(true);

            } else if (rb3.isSelected()) {
                Listeleme listeleme = new Listeleme();
                listeleme.onListele("personel.txt");
                frames.setVisible(true);

            } else if (rb4.isSelected()) {
                Listeleme listeleme = new Listeleme();
                listeleme.onListele("urunler.txt");
                frames.setVisible(true);

            } else if (finalRb.isSelected()) {
                frames.setVisible(false);

            }
        });
    }
}

