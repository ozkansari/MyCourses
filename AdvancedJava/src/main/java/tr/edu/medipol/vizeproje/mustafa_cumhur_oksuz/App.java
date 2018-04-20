package tr.edu.medipol.vizeproje.mustafa_cumhur_oksuz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kent Kütüphanesi");

        JPanel GUI = new JPanel();
        GUI.setLayout(null);

        JPanel dugmeler = new JPanel();
        dugmeler.setLayout(null);
        dugmeler.setLocation(10,10);
        dugmeler.setSize(250,270);
        GUI.add(dugmeler);

        JButton button = new JButton();
        button.setText("Kitaplar");
        button.setSize(120,20);
        button.setLocation(70,20);
        button.setHorizontalAlignment(0);
        dugmeler.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane but1 = new JOptionPane();
                but1.showMessageDialog(null,"Mevcut kitaplarimiz: x, y, z, t, ü,..." );
                }
        });

        JButton button2 = new JButton();
        button2.setText("Yazarlar");
        button2.setSize(120,20);
        button2.setLocation(70,45);
        button2.setHorizontalAlignment(0);
        dugmeler.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane but2 = new JOptionPane();
                but2.showMessageDialog(null,"Kitabi bulunan yazarlar: xxx, yyyy, zzz, ttt, üüüü,..." );
            }
        });

        JButton button3 = new JButton();
        button3.setText("Yayin Evleri");
        button3.setSize(120,20);
        button3.setLocation(70,70);
        button3.setHorizontalAlignment(0);
        dugmeler.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane but3 = new JOptionPane();
                but3.showMessageDialog(null,"Yayin Evleri: x, y, z, t, ü,..." );
            }
        });

        JButton button4 = new JButton();
        button4.setText("Cikis");
        button4.setSize(120,20);
        button4.setLocation(70,95);
        button4.setHorizontalAlignment(0);
        dugmeler.add(button4);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane but4 = new JOptionPane();
                but4.showMessageDialog(null,"Iyi gunler.");
            }
        });


        frame.setSize(300,300);
        frame.setContentPane(GUI);
        frame.setResizable(false);
        frame.setVisible(true);



    }

}
