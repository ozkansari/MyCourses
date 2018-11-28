package tr.edu.medipol.ilerijava.vize.onur_karal.Sunucu;
import tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.EkranSinifi;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketUstSinif;




public class SunucuEkrani extends EkranSinifi {

    private static final long serialVersionUID = 1L;
    private JTextArea MesajlarJTA;
    private JScrollPane MesajlarJTAScroll;
    private java.util.List<String> MesajList;

    private JTextArea istemciListJTA;
    private JScrollPane istemciListJTAScroll;

    public Queue<String> MesajKuyruğu = new LinkedList<>();


    public SunucuEkrani(String title) {
        setTitle(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 500);
        setLocation(100, 50);

        setLayout(new GridLayout(1, 1));

        MesajlarJTA = new JTextArea();
        MesajlarJTA.setEditable(false);
        MesajlarJTA.getScrollableTracksViewportHeight();
        MesajlarJTAScroll = new JScrollPane(MesajlarJTA);
        add(MesajlarJTAScroll);
        MesajList = new java.util.ArrayList<>();

        istemciListJTA = new JTextArea();
        istemciListJTA.setEditable(false);
        istemciListJTA.getScrollableTracksViewportHeight();
        istemciListJTAScroll = new JScrollPane(istemciListJTA);

    }

    @Override
    public synchronized void mesajEkle(String mesaj) {
        MesajList.add(mesaj);
        MesajlarJTA.setText(MesajlarJTA.getText() + mesaj + "\n");
        MesajlarJTA.setCaretPosition(MesajlarJTA.getDocument().getLength());
        repaint();
    }

    @Override
    public Queue<String> getMesajKuyruğu() {
        return MesajKuyruğu;
    }
}
