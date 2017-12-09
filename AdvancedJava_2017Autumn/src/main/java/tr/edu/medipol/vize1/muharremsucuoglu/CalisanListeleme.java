package tr.edu.medipol.vize1.muharremsucuoglu;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

public class CalisanListeleme {

    CalisanListeleme() {

        JFrame frames = new JFrame("-- MAĞAZAM YÖNETİM SİSTEMİ --");
        JTextArea t1 = new JTextArea();
        JScrollPane s1 = new JScrollPane(t1);

        try {
            t1.read(new FileReader("calisanlar.txt"), null);
            frames.add(s1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        frames.setSize(1024, 768);
        frames.setVisible(true);
    }


}
