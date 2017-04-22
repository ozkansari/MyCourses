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
public class AddStudent {
    public ArrayList<String> ogrenciler;

    public static JFrame frames;

    AddStudent() {

        ogrenciler = new ArrayList<String>();

        frames = new JFrame("-- MEBİS ÖĞRENCİ EKLEME SİSTEMİ --");

        JTextField text1, text2, text3;
        JButton buton2;
        JLabel baslik, l1,l2,l3;
        baslik = new JLabel("Öğrenci Ekleyin");
        baslik.setBounds(500,15, 250,35);
        frames.add(baslik);


        l1=new JLabel("Öğrencinin Adı");
        l1.setBounds(500,35, 250,35);

        text1 = new JTextField("");
        text1.setBounds(500,65,250,35);
        frames.add(text1);

        l2=new JLabel("Öğrencinin Numarasını Girin");
        l2.setBounds(500,87, 250,35);

        text2 = new JTextField("");
        text2.setBounds(500,117,250,35);
        frames.add(text2);

        l3=new JLabel("Öğrencinin Bölümü");
        l3.setBounds(500,140, 250,35);

        text3 = new JTextField("");
        text3.setBounds(500,167,250,35);
        frames.add(text3);

        frames.add(l1); frames.add(l2);frames.add(l3);


        buton2 = new JButton("Öğrenci Ekle");
        buton2.setBounds(500, 270, 250, 35);
        frames.add(buton2);
        buton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    FileWriter fw = new FileWriter("ogrenciler.txt",true);
                    PrintWriter pw = new PrintWriter(fw);

                    String name = text1.getText();
                    String number = text2.getText();
                    String section = text3.getText();

                    ogrenciler.add(name + " * " + number + " * " + section );
                    pw.println(ogrenciler);

                    JOptionPane.showMessageDialog(null,"Öğrenci Listeye Kayıt Edildi...");

                    pw.close();


                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frames.setSize(1200, 800);
        frames.setLayout(null);
        frames.setVisible(true);

    }




}

