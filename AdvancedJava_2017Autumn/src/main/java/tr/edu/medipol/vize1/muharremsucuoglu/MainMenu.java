package tr.edu.medipol.vize1.muharremsucuoglu;

// import personal.CalisanIslemleri;
//import stok.UrunIslemleri;

import javax.swing.*;

public class MainMenu {

    public MainMenu() {

    }

    public static void main(String[] args) {

        createFrame();
    }

    public static void createFrame() {

        JFrame frames;
        JLabel label1, label2;
        JRadioButton rb1, rb2, rb3;
        JButton button1;

        frames = new JFrame("Mağazam Yönetim Sistemi");

        label1 = new JLabel("Mağazama HoşGeldiniz");
        label1.setBounds(500, 25, 300, 40);
        frames.add(label1);

        label2 = new JLabel("İşlem Seçiniz");
        label2.setBounds(500, 70, 300, 30);
        frames.add(label2);

        rb1 = new JRadioButton(" Çalışan İşlemleri");
        rb1.setBounds(500, 110, 300, 30);
        frames.add(rb1);

        rb2 = new JRadioButton("Stok İşlemleri");
        rb2.setBounds(500, 150, 300, 30);
        frames.add(rb2);

        rb3 = new JRadioButton("Çıkış");
        rb3.setBounds(500, 190, 300, 30);
        frames.add(rb3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        button1 = new JButton("Git");
        button1.setBounds(500, 230, 200, 50);
        frames.add(button1);

        frames.setSize(1024, 768);
        frames.setLayout(null);
        frames.setVisible(true);

        button1.addActionListener(e -> {

            if (bg.isSelected(null)) {
                JOptionPane.showMessageDialog(null, "Lütfen Seçim Yapınız");

            } else if (rb1.isSelected()) {
                new CalisanIslemleri();
                frames.setVisible(false);

            } else if (rb2.isSelected()) {
                new UrunIslemleri();
                frames.setVisible(false);

            } else if (rb3.isSelected()) {
                frames.setVisible(false);

            }
        });
    }
}
