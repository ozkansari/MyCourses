package tr.edu.medipol.hafta6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EkranOrnegi2 extends JFrame {
    
    private JTextField adSoyadGirdi = new JTextField();
    private JButton formButonu = new JButton("Ekle");
    private JTextArea ciktiTextArea = new JTextArea();
    
    public static void main(String [] args) {
        EkranOrnegi2 ekran = new EkranOrnegi2();
    }
    
    public EkranOrnegi2() {
        // Ekran genel ozellikleri
        setTitle("Medipol");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Ekrana yayilim - izgara halinde
        setLayout(new GridLayout(3,1));
        
        JPanel formPaneli = new JPanel();
        formPaneli.setLayout(new GridLayout(1,2));
        formPaneli.add(new JLabel("Ad Soyad:"));
        formPaneli.add(adSoyadGirdi);
        
        add(formPaneli);
        
        JPanel butonPaneli = new JPanel();
        butonPaneli.setLayout(new GridLayout(1,1));
        butonPaneli.add(formButonu);
        add(butonPaneli);
        
        JPanel ciktiPaneli = new JPanel();
        ciktiPaneli.setLayout( new GridLayout(1,1) );
        ciktiPaneli.add(ciktiTextArea);
        ciktiTextArea.setEditable(false);
        add(ciktiPaneli);
        
        // Yontem 1
        // formButonu.addActionListener(new ButonAksiyonu());
        // Yontem 2: Anonim class
        /*
        formButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Butona basildi" + e.getSource());
            }
        });
        */
        // Yontem 3 : Lambda
        formButonu.addActionListener(e -> {
            System.out.println("Ad soyad: " + adSoyadGirdi.getText());
            String mevcutDeger = ciktiTextArea.getText();
            ciktiTextArea.setText( mevcutDeger + "\n" + adSoyadGirdi.getText() );
            adSoyadGirdi.setText("");
        });
        
        // Ekrani ac
        setVisible(true);
    }
    /*
    // Yontem 1 icin
    private class ButonAksiyonu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Butona basildi");
        }
    }
    */
}
