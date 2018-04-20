
package tr.edu.medipol.vizeproje.baris_koksal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Kitap extends JFrame{
    
    public ArrayList<String> kitapAdi = new ArrayList<String>();
    public ArrayList<String> yazari = new ArrayList<String>();
    public ArrayList<String> turu = new ArrayList<String>();
    public int sayfaSayisi;
    
    
    
    
    public Kitap(){
        
        setLayout(new FlowLayout());
        
        
        JButton Listele = new JButton("Listele");
        Listele.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new YayinEviListele();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        JTextField Ad = new JTextField("Kitabin adi : ");
        JTextField Yazar = new JTextField("Yazari : ");
        JTextField Tur = new JTextField("Turu : ");
        JButton tamam = new JButton("Tamam");
        JButton geriDon = new JButton("Geri Don");
        geriDon.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                setVisible(false);
                
            }
        });
        tamam.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                kitapAdi.add(Ad.getText());
                yazari.add(Yazar.getText());
                turu.add(Tur.getText());
                
                File dosya1 = new File("Kitap Adi.txt");
                if(!dosya1.exists())
                    try {
                        dosya1.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileWriter f1 = null;
                try {
                    f1 = new FileWriter(dosya1);
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter b1 = new BufferedWriter(f1);
                
                try {
                    b1.write(Ad.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    b1.close();
                    // ---- Yazar dosyaya yazma kısmı
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                File dosya2 = new File("Kitabin Yazari.txt");
                if(!dosya2.exists())
                    try {
                        dosya2.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileWriter f2 = null;
                try {
                    f2 = new FileWriter(dosya2);
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter b2 = new BufferedWriter(f2);
                
                try {
                    b2.write(Yazar.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    b2.close();
                    // --- Turu dosya okuma bolgesi
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                File dosya3 = new File("Kitabin Turu.txt");
                if(!dosya3.exists())
                    try {
                        dosya3.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileWriter f3 = null;
                try {
                    f3 = new FileWriter(dosya3);
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedWriter b3 = new BufferedWriter(f3);
                
                try {
                    b3.write(Tur.getText());
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    b3.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kitap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tamam.setText("Tamam");
        geriDon.setText("Geri Don");
        
        add(Tur);
        add(Yazar);
        add(Ad);
        add(tamam);
        add(geriDon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
}
