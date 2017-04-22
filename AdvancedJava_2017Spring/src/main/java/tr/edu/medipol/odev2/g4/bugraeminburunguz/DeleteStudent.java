package tr.edu.medipol.odev2.g4.bugraeminburunguz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by user on 13.04.2017.
 */
public class DeleteStudent {

    public ArrayList<String> ogrenciListesi;

    public static JFrame f;

    DeleteStudent() {

        ogrenciListesi = new ArrayList<String>();

        f = new JFrame("OgrenciYonetimSistemi");
        JTextField text1, text2, text3, text4;
        JButton buton1, buton2;
        JLabel baslik;

        baslik = new JLabel("Silmek İstediğiniz Öğrencinin Numarasını Giriniz");
        baslik.setBounds(500, 25, 350, 50);
        f.add(baslik);

        text1 = new JTextField();
        text1.setBounds(500, 60, 350, 35);
        f.add(text1);


        buton2 = new JButton("Öğrenci Sil");
        buton2.setBounds(500, 120, 350, 35);
        f.add(buton2);
        buton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    FileWriter fw = new FileWriter("ogrenciler.txt",true);
                    PrintWriter pw = new PrintWriter(fw);



                    ogrenciListesi.remove(text1.getText());

                    pw.println(ogrenciListesi);

                    JOptionPane.showMessageDialog(null,"Öğrenci Listeden Silindi...");

                    pw.close();


                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        f.setSize(1200, 800);
        f.setLayout(null);
        f.setVisible(true);

    }


}

