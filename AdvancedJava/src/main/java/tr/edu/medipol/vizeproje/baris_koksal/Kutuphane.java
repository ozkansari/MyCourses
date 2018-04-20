package tr.edu.medipol.vizeproje.baris_koksal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Kutuphane extends JFrame{
    
    public ArrayList<String> yayinAdi = new ArrayList<String>();
    public ArrayList<String> ep = new ArrayList<String>();
    
    public Kutuphane(){
        
        setLayout(new FlowLayout());
        JButton geriDon = new JButton("Geri Don");
        JTextField ye_adi = new JTextField("Yayin evi adi : ");
        JTextField ePosta = new JTextField("e-Posta : ");
        JButton OKEY = new JButton("Tamam");
        OKEY.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yayinAdi.add(ye_adi.getText());
                ep.add(ePosta.getText());
                
                
                File dosya = new File("Yayin Evi Adi.txt");
                    if(!dosya.exists())
                        try {
                            dosya.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(dosya, true);
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter bWriter = new BufferedWriter(fileWriter);
                try {
                    bWriter.write(ye_adi.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }
                // ---  E postanın dosya ksımına yazılması ---
                File ePosta2 = new File("E-Postalar.txt");
                if(!ePosta2.exists())
                    try {
                        ePosta2.createNewFile();
                        // dosya yazmanın devamı üstüne yazma ! 
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileWriter fw2 = null;
                try {
                    fw2 = new FileWriter(ePosta2, false);
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter bw2 = new BufferedWriter(fw2);              
                
                try {
                    bw2.write(ePosta.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    bw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kutuphane.class.getName()).log(Level.SEVERE, null, ex);
                } 
                System.out.println(ep);
            }
        });
        geriDon.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(geriDon);
        add(OKEY);
        add(ye_adi);
        add(ePosta);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
}
