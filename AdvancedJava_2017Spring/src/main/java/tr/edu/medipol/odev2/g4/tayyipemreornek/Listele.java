package tr.edu.medipol.odev2.g4.tayyipemreornek;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by teornek on 13/04/2017.
 */
public class Listele extends Ekle {

    public static JFrame f;

    Listele() {

        f = new JFrame("OgrenciYonetimSistemi");
        JTextArea t1 = new JTextArea();
        JScrollPane s1 = new JScrollPane(t1);

        try {
            t1.read(new FileReader("ogrenciler.txt"),null);
            f.add(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        f.setSize(500, 350);
        f.setVisible(true);

    }
}