package tr.edu.medipol.vize1.emineaycicek;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class DinamikForum  extends JFrame  implements ActionListener,  ListSelectionListener{


    private  JPanel    anaPanlemizi;
    private  JList    listBox;
    private  Vector    vek;
    private  JButton    eklemeButtonu;
    private  JButton    silButtonu;
    private  JTextField  textAlani;
    private  JScrollPane dinamikPanel;
    private  JButton   guncelButtonu;



    public DinamikForum(){



        setTitle( "Emine Ayçiçek" );
        setBounds(400, 200, 600, 500);
        anaPanlemizi = new JPanel();
        getContentPane().add( anaPanlemizi );
        vek = new Vector();


        listBox = new JList( vek );
        listBox.addListSelectionListener( this );



        dinamikPanel = new JScrollPane();
        dinamikPanel.getViewport().add( listBox );
        anaPanlemizi.add( dinamikPanel, BorderLayout.CENTER );



        panelOlustur();
    }

    public void panelOlustur(){



        JOptionPane.showMessageDialog(null, "Mağaza Çalışan Ekle");
        JPanel veriPaneli = new JPanel();
        veriPaneli.setLayout( new BorderLayout() );
        anaPanlemizi.add(veriPaneli);



        String baslik="Çalışan Ekle Menüsü";
        JLabel texti=new JLabel(baslik);
        texti.setFont(new Font("Arial", Font.PLAIN,25));
        texti.setBounds(10,20,100,25);
        veriPaneli.add(texti, BorderLayout.LINE_END);

        eklemeButtonu = new JButton( "Ekle" );
        veriPaneli.add( eklemeButtonu, BorderLayout.BEFORE_LINE_BEGINS);
        eklemeButtonu.addActionListener( this );
        eklemeButtonu.setBounds(60,50,50,20);

        guncelButtonu=new JButton("Guncelle");
        guncelButtonu.addActionListener(this);
        veriPaneli.add(guncelButtonu, BorderLayout.CENTER);
        guncelButtonu.setBounds(60,60,50,20);



        silButtonu = new JButton( "Sil" );
        veriPaneli.add( silButtonu, BorderLayout.AFTER_LINE_ENDS );
        silButtonu.addActionListener( this );
        silButtonu.setBounds(60,70,50,20);


        textAlani = new JTextField();
        textAlani.setBounds(10,25,200,150);
        veriPaneli.add( textAlani, BorderLayout.BEFORE_FIRST_LINE );

    }


    public void valueChanged( ListSelectionEvent olay ){
        if( olay.getSource() == listBox && !olay.getValueIsAdjusting()){
            String secilenDeger = (String)listBox.getSelectedValue();
            if( secilenDeger != null )
                textAlani.setText( secilenDeger );

        }

    }


    public void actionPerformed( ActionEvent olay ){
        if( olay.getSource() == eklemeButtonu ){
            String textDegerEkle= textAlani.getText();
            if( textDegerEkle != null ){
                vek.addElement(textDegerEkle);
                textAlani.setText(null);
                listBox.setListData( vek );
                dinamikPanel.revalidate();
                dinamikPanel.repaint();

            }

            if(textDegerEkle.equals("")){
                JOptionPane.showMessageDialog(null,"Eklenecek Deger yok hata!");

            }

        }

        if(olay.getSource()==guncelButtonu){
            String listBoxDeger=textAlani.getText();
            int guncKonum=listBox.getSelectedIndex();
            if(listBoxDeger!=null){
                if(guncKonum>=0){
                    vek.removeElementAt(guncKonum);
                    listBox.setListData(vek);
                    dinamikPanel.repaint();

                    String girilenDeger=textAlani.getText();
                    vek.add(guncKonum, girilenDeger);
                    listBox.setListData(vek);
                    textAlani.setText(null);
                    dinamikPanel.revalidate();
                    dinamikPanel.repaint();

                }else{
                    JOptionPane.showMessageDialog(null,"Listboxtan deger secin hata!");

                }

            }

        }

        if( olay.getSource() == silButtonu ){
            int silinecekKonum = listBox.getSelectedIndex();
            if( silinecekKonum >= 0 ){
                vek.removeElementAt( silinecekKonum );
                textAlani.setText(null);
                listBox.setListData( vek );
                dinamikPanel.revalidate();
                dinamikPanel.repaint();

            }else{
                JOptionPane.showMessageDialog(null,"Listboxtan deger secin hata!");

            }

        }

    }


    public static void main( String[]  args){


        DinamikForum formNesnesi  = new DinamikForum();
        formNesnesi.setVisible( true );

    }

}

