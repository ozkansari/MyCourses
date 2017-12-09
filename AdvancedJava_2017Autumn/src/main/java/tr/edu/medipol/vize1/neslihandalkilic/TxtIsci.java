package tr.edu.medipol.vize1.neslihandalkilic;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

class TxtIsci {

    TxtIsci() {

        JFrame frames = new JFrame("Neslihan Mağazası Çalışanları");

        try {
            JTextArea t1 = new JTextArea();
            t1.read(new FileReader("isciler.txt"), null);
            JScrollPane s1 = new JScrollPane(t1);
            frames.add(s1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        frames.setSize(1200, 800);
        frames.setVisible(true);
    }
}