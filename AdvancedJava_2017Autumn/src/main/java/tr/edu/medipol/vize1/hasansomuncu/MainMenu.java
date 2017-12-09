package tr.edu.medipol.vize1.hasansomuncu;

import javax.swing.*;

///Hasan Somuncu////
public class MainMenu {

    public static void main(String[] args) {

        JRadioButton rb1, rb2, rb3, rb4;
        JButton buton;

        JFrame frames = new JFrame("/*/*/*/*/*");

        rb1 = new JRadioButton("Ekle/Sil(Urunler)");
        rb1.setBounds(550, 110, 300, 30);
        frames.add(rb1);

        rb2 = new JRadioButton("Ekle/Sil(Calisanlar)");
        rb2.setBounds(550, 150, 300, 30);
        frames.add(rb2);
        rb3 = new JRadioButton("Listele");
        rb3.setBounds(550, 190, 300, 30);
        frames.add(rb3);
        rb4 = new JRadioButton("Kapat");
        rb4.setBounds(50, 230, 300, 30);
        frames.add(rb4);


        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);


        buton = new JButton("Geç");
        buton.setBounds(50, 310, 200, 50);
        frames.add(buton);

        frames.setSize(1000, 1000);
        frames.setLayout(null);
        frames.setVisible(true);

        buton.addActionListener(e -> {
            if (rb1.isSelected()) {
                new StokIslemleri();
                frames.setVisible(true);

            } else if (rb2.isSelected()) {
                new Isciler();
                frames.setVisible(true);

            } else if (rb3.isSelected()) {
                new TxtIsci();
                frames.setVisible(true);

            } else if (rb4.isSelected()) {
                frames.setVisible(true);
            }
        });
    }
}

