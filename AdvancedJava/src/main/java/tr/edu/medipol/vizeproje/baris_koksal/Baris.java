package tr.edu.medipol.vizeproje.baris_koksal;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Baris extends JFrame{
    public Baris(){

        GridBagLayout gbl = new GridBagLayout();
        
        setLayout(gbl);
        
        JButton kutupEkle = new JButton("Yayin evi ekle");
        JButton kitapEkle = new JButton("Kitap Ekle");
        JButton kitapListe = new JButton("Kitaplari Listele ");
        JButton cikis = new JButton("Cikis");
        cikis.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        kitapEkle.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Kitap();
            }
        });
        kutupEkle.setAction(new AbstractAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new Kutuphane();
            }
        });
        cikis.setText("cikis");
        kompEkle(this,gbl,kutupEkle,0,0,2,2);
        kompEkle(this,gbl,kitapEkle,0,2,2,2);
        kompEkle(this,gbl,kitapListe,0,4,2,2);
        kompEkle(this,gbl,cikis,4,3,2,2);
        kutupEkle.setText("Kutuphane Ekle");
        kitapEkle.setText("Kitap Ekle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        Baris B1 = new Baris();
        ArrayList<String> al = new ArrayList<String>();
        
    }
    public static void kompEkle(Container Con, GridBagLayout gbl, Component Kom, int x, int y, int genislik, int yukseklik){
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = genislik;
        gbc.gridheight = yukseklik;
        gbl.setConstraints(Kom, gbc);
        Con.add(Kom);
        
    }
}
