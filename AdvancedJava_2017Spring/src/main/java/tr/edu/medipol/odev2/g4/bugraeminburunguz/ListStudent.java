package tr.edu.medipol.odev2.g4.bugraeminburunguz;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by user on 13.04.2017.
 */
public class ListStudent {
    public static JFrame frames;

    ListStudent() {

        frames = new JFrame("-- MEBİS ÖĞRENCİ EKLEME SİSTEMİ --");
        JTextArea t1 = new JTextArea();
        JScrollPane s1 = new JScrollPane(t1);

        try {
            t1.read(new FileReader("ogrenciler.txt"),null);
            frames.add(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frames.setSize(500, 350);
        frames.setVisible(true);

    }
}