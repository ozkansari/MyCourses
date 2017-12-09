package tr.edu.medipol.vize1.neslihandalkilic;
import javax.swing.*;


public class MainMenu {

    public static void main(String[] args) {

        JRadioButton rb1, rb2, rb3, rb4, rb5;
        JButton buton;

        JFrame frames = new JFrame("Neslihanın Mağazası");

        rb1 = new JRadioButton(" İşcileri Ekle/Sil");
        rb1.setBounds(50, 110, 300, 30);
        frames.add(rb1);

        rb2 = new JRadioButton("Malzeme Ekle/Sil");
        rb2.setBounds(50, 150, 300, 30);
        frames.add(rb2);
        rb3 = new JRadioButton("İşçileri Listele");
        rb3.setBounds(50, 190, 300, 30);
        frames.add(rb3);
        rb4 = new JRadioButton("Malzeme Listele");
        rb4.setBounds(50, 230, 300, 30);
        frames.add(rb4);
        rb5 = new JRadioButton("QUİT");
        rb5.setBounds(50, 270, 300, 30);
        frames.add(rb5);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        bg.add(rb5);


        buton = new JButton("Geç");
        buton.setBounds(50, 310, 200, 50);
        frames.add(buton);

        frames.setSize(1000, 1000);
        frames.setLayout(null);
        frames.setVisible(true);

        JRadioButton finalRb = rb5;
        buton.addActionListener(e -> {
            if (rb1.isSelected()) {
                new Isciler();
                frames.setVisible(true);

            } else if (rb2.isSelected()) {
                new StokIslemleri();
                frames.setVisible(true);

            } else if (rb3.isSelected()) {
                new TxtIsci();
                frames.setVisible(true);

            } else if (rb4.isSelected()) {
                new TxtIsci();
                frames.setVisible(true);

            } else if (finalRb.isSelected()) {
                frames.setVisible(false);

            }
        });
    }
}

