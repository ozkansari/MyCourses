package tr.edu.medipol.vize1.aykutyilmaz;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

class Listeleme {


    private JTextArea t1 = new JTextArea();
    private JScrollPane s1 = new JScrollPane(t1);

    public void onListele(String txtName) {

        JFrame frames = new JFrame("PROGRAMIM");

        try {
            t1.read(new FileReader(txtName), null);
            frames.add(s1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        frames.setSize(1200, 800);
        frames.setVisible(true);
    }
}