package tr.edu.medipol.vize1.caglaoz;

/**
 * Created by Çağla on 29.11.2017.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;



public class Ekran extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Ekran();
    }

    private JFrame Ekran = new JFrame("Proje Ödevi - Çağla Öz");


    private JButton Calisaneklebutonu = new JButton("Çalışan Ekle");
    private JButton Calisanguncellebutonu = new JButton("Çalışanı Güncelle");
    private JButton CalisansilButonu = new JButton("Çalışanı Sil");
    private JButton CalisanListesiacbutonu = new JButton("Çalışan Listesini Aç");
    private JButton CalisanListesikptbutonu = new JButton("Çalışan Listesini Kapat");
    private JButton CalisandsyKaydetbutonu = new JButton("Çalışan Dosyasını Kaydet");
    private JTextArea mesajAlaniCalisan = new JTextArea();
    private JTextField CalisanGirdi = new JTextField();
    private String Calisansorgu = "";

    private JButton Stokeklebutonu = new JButton("Stok Ekle");
    private JButton Stokguncellebutonu = new JButton("Stok Güncelle");
    private JButton StoksilButonu = new JButton("Stok Sil");
    private JButton StokListesiacbutonu = new JButton("Stok Listesini Aç");
    private JButton StokListesikptbutonu = new JButton("Stok Listesini Kapat");
    private JButton StokdsyKaydetbutonu = new JButton("Stok Dosyasını Kaydet");
    private JTextField StokGirdi = new JTextField();
    private JTextArea mesajAlaniStok = new JTextArea();
    private String Stoksorgu = "";

    private JTextField Calisanadi = new JTextField();
    private JTextField CalisanUnvani = new JTextField();
    private JTextField CalisanMaasi = new JTextField();

    private JTextField StokUrunu = new JTextField();
    private JTextField StokAdedi = new JTextField();
    private JTextField CalisanTexti = new JTextField();
    private JTextField StokTexti = new JTextField();


    private final JPanel Calisanpanel = new JPanel();
    private JList list = new JList();
    private JTextField Calisanconsole;
    private JTextField CalisanAdi;
    private JTextField CalisanMaas;
    private JTextField CalisanU;


    private final JPanel stokpanel = new JPanel();
    private JList listele= new JList();
    private JTextField Stokconsole;
    private JTextField StokAdet;
    private JTextField StokUrun;

    DefaultListModel DLM = new DefaultListModel();
    private JTextField txtCalisanDosya;
    private JTextField txtCalisanpanelx;
    private JTextField Calisantxttip;

    private JTextField txtStokDosya;
    private JTextField txtStokpanelx;
    private JTextField Stoktxttip;

    public void addse(String name){

        DLM.addElement(name);
        list.setModel(DLM);
        listele.setModel(DLM);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mesajAlaniCalisan.setText(CalisanGirdi.getText());
        mesajAlaniStok.setText(StokGirdi.getText());

    }


    public Ekran() {
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("Çıkış");

        JMenuItem eMenuItem = new JMenuItem("Çıkış");
        eMenuItem.addActionListener(event -> System.exit(0));
        filemenu.add(eMenuItem);
        menubar.add(filemenu);
        Ekran.setJMenuBar(menubar);
        Ekran.setLocationRelativeTo(null);
        Ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String Ctitle = "Çalışan Ekle Penceresi";
        JLabel CtitleLbl = new JLabel(Ctitle);
        CtitleLbl.setFont(new Font("Arial", Font.PLAIN, 15));
        CtitleLbl.setForeground(new Color(50, 50, 25));
        CtitleLbl.setBounds(20, 5, 250, 55);

        String Stitle = "Stok Ekle Penceresi";
        JLabel StitleLbl = new JLabel(Stitle);
        StitleLbl.setFont(new Font("Arial", Font.PLAIN, 15));
        StitleLbl.setForeground(new Color(50, 50, 25));
        StitleLbl.setBounds(550, 5, 250, 55);

        String CDtitle = "Çalışan Kayıt Dosya Adı: ";
        JLabel CDtitleLbl = new JLabel(CDtitle);
        CDtitleLbl.setFont(new Font("Arial", Font.PLAIN, 11));
        CDtitleLbl.setForeground(new Color(50, 50, 25));
        CDtitleLbl.setBounds(350, 300, 280, 55);
        CalisanTexti =new JTextField(250);
        CalisanTexti.setBounds(350,342,180,25);


        String Cgunceltitle = "Çalışanı Güncelle:";
        JLabel CgunceltitleLbl = new JLabel(Cgunceltitle);
        CgunceltitleLbl.setFont(new Font("Arial", Font.PLAIN, 11));
        CgunceltitleLbl.setForeground(new Color(50, 50, 25));
        CgunceltitleLbl.setBounds(350, 450, 280, 55);

        String SDtitle = "Stok Kayıt Dosya Adı: ";
        JLabel SDtitleLbl = new JLabel(SDtitle);
        SDtitleLbl.setFont(new Font("Arial", Font.PLAIN, 11));
        SDtitleLbl.setForeground(new Color(50, 50, 25));
        SDtitleLbl.setBounds(885, 300, 280, 55);
        StokTexti =new JTextField(250);
        StokTexti.setBounds(885,342,180,25);

        String Sgunceltitle = "Stok Güncelle:";
        JLabel SgunceltitleLbl = new JLabel(Sgunceltitle);
        SgunceltitleLbl.setFont(new Font("Arial", Font.PLAIN, 11));
        SgunceltitleLbl.setForeground(new Color(50, 50, 25));
        SgunceltitleLbl.setBounds(950, 450, 310, 50);






        Calisaneklebutonu.setBounds(20, 225, 510, 25);
        CalisandsyKaydetbutonu.setBounds(350, 380, 180, 25);
        CalisanListesiacbutonu.setBounds(350, 410, 180, 25);
        CalisanListesikptbutonu.setBounds(350, 440, 180, 25);
        CalisansilButonu.setBounds(350, 500, 180, 25);
        Calisanguncellebutonu.setBounds(350, 530, 180, 25);




        Stokeklebutonu.setBounds(550, 225, 510, 25);
        StokdsyKaydetbutonu.setBounds(885, 380, 180, 25);
        StokListesiacbutonu.setBounds(885, 410, 180, 25);
        StokListesikptbutonu.setBounds(885, 440, 180, 25);
        StoksilButonu.setBounds(885, 500, 180, 25);
        Stokguncellebutonu.setBounds(885, 530, 180, 25);


        Ekran.getContentPane().add(CtitleLbl);
        Ekran.getContentPane().add(StitleLbl);
        Ekran.getContentPane().add(CalisanListesiacbutonu);
        Ekran.getContentPane().add(CalisanListesikptbutonu);
        Ekran.getContentPane().add(CalisandsyKaydetbutonu);
        Ekran.getContentPane().add(Calisaneklebutonu);
        Ekran.getContentPane().add(CalisansilButonu);
        Ekran.getContentPane().add(Calisanguncellebutonu);
        Ekran.getContentPane().add(CDtitleLbl);
        Ekran.getContentPane().add(CgunceltitleLbl);
        Ekran.getContentPane().add(StokListesiacbutonu);
        Ekran.getContentPane().add(StokListesikptbutonu);
        Ekran.getContentPane().add(StokdsyKaydetbutonu);
        Ekran.getContentPane().add(Stokeklebutonu);
        Ekran.getContentPane().add(StoksilButonu);
        Ekran.getContentPane().add(Stokguncellebutonu);
        Ekran.getContentPane().add(SDtitleLbl);
        Ekran.getContentPane().add(SgunceltitleLbl);
        Ekran.getContentPane().add(CalisanTexti);
        Ekran.getContentPane().add(StokTexti);


        Ekran.setLayout(null);
        Ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ekran.setSize(1100, 700);
        Ekran.setLocationRelativeTo(null);
        Ekran.setVisible(true);




        Calisaneklebutonu.addActionListener(this);
        mesajAlaniCalisan.setEditable(false);
        mesajAlaniCalisan.setBounds(20,310,300,250);
        add(Calisanpanel);
        add(mesajAlaniCalisan);



        Stokeklebutonu.addActionListener(this);
        mesajAlaniStok.setEditable(true);
        mesajAlaniStok.setBounds(550,310,300,250);
        add(stokpanel);
        add(mesajAlaniStok);


        String calisanadi="Çalışan Adı/Soyadı                                           :";
        JLabel CAdi = new JLabel(calisanadi);
        CAdi.setForeground(new Color(50, 50, 25));
        CAdi.setBounds(20, 20, 250, 100);
        Calisanadi =new JTextField(250);
        Calisanadi.setBounds(265,55,250,25);

        String calisanunvanı="Çalışan Mevkisi (Müdür/Personel/Stajer)  :";
        JLabel CUnvan = new JLabel(calisanunvanı);
        CUnvan.setForeground(new Color(50, 50, 25));
        CUnvan.setBounds(20, 50, 250, 100);
        CalisanUnvani =new JTextField(250);
        CalisanUnvani.setBounds(265,85,250,25);

        String calisanMaasi="Çalışanın Maaşı                                                :";
        JLabel CMaas = new JLabel(calisanMaasi);
        CMaas.setForeground(new Color(50, 50, 25));
        CMaas.setBounds(20, 80, 250, 100);
        CalisanMaasi =new JTextField(250);
        CalisanMaasi.setBounds(265,115,250,25);

        String Urunadi="Ürün Adı                      :";
        JLabel UAdi = new JLabel(Urunadi);
        UAdi.setForeground(new Color(50, 50, 25));
        UAdi.setBounds(550, 20, 250, 100);
        StokUrunu =new JTextField(250);
        StokUrunu.setBounds(680,55,250,25);

        String UrunStok="Ürün Stok Durumu    :";
        JLabel UStok = new JLabel(UrunStok);
        UStok.setForeground(new Color(50, 50, 25));
        UStok.setBounds(550, 50, 250, 100);
        StokAdedi =new JTextField(250);
        StokAdedi.setBounds(680,85,250,25);



        Ekran.getContentPane().add(CAdi);
        Ekran.getContentPane().add(Calisanadi);
        Ekran.getContentPane().add(CUnvan);
        Ekran.getContentPane().add(CalisanUnvani);
        Ekran.getContentPane().add(UAdi);
        Ekran.getContentPane().add(StokUrunu);
        Ekran.getContentPane().add(UStok);
        Ekran.getContentPane().add(StokAdedi);
        Ekran.getContentPane().add(CMaas);
        Ekran.getContentPane().add(CalisanMaasi);





        Calisaneklebutonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(!Calisanadi.getText().equals("")) {
                    if(!CalisanUnvani.getText().equals("")) {
                        if(!CalisanMaasi.getText().equals("")){
                            


                                mesajAlaniCalisan.setText("Son Eklenen Kişi : " + "' " + Calisanadi.getText() + " '" + " - " + "' " + CalisanUnvani.getText() + " '" + " - " + "' " + CalisanMaasi.getText() + " '" + " - " + "' " + Calisantxttip.getText() + " '");


                                if (e.getSource() == Calisaneklebutonu){
                                    Calisansorgu = Calisanadi.getText();

                                    JOptionPane.showMessageDialog(null, Calisansorgu + " Kişisi Eklendi.");

                                }
                                Calisantxttip.setText("");
                                Calisanadi.setText("");
                                CalisanUnvani.setText("");
                                CalisanMaasi.setText("");


                            
                        }else{JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}
                    }else {JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}
                }else {JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}

            }
        });

        Calisanguncellebutonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index=list.getSelectedIndex();

                DLM.setElementAt(txtCalisanpanelx.getText(), index);

            }
        });
        CalisansilButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index=list.getSelectedIndex();

                DLM.removeElementAt(index);

                txtCalisanpanelx.setText("");
            }
        });

        Stokeklebutonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(!StokUrunu.getText().equals("")) {
                    if(!StokAdedi.getText().equals("")) {
                        if(!Stoktxttip.getText().equals("")) {

                            mesajAlaniStok.setText("Son Eklenen Urun : " + "' " +StokUrunu.getText() + " '" + " - " + "' " + StokAdedi.getText() + " '" + " - " + "' " +Stoktxttip.getText() + " '");


                            if (e.getSource() == Stokeklebutonu){
                                Stoksorgu = StokUrunu.getText();

                                JOptionPane.showMessageDialog(null, Stoksorgu + "Urunu Eklendi.");
                                addse("' " + StokUrunu.getText() + " '" +  " - " + "' " + StokAdedi.getText() + " '" +Stoktxttip.getText() + " '");

                            }

                            Calisantxttip.setText("");
                            StokUrunu.setText("");
                            StokAdedi.setText("");



                        }else{JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}
                    }else{JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}
                }else {JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}

            }
        });
        Stokguncellebutonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index=listele.getSelectedIndex();

                DLM.setElementAt(txtStokpanelx.getText(), index);

            }
        });
        StoksilButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index=listele.getSelectedIndex();

                DLM.removeElementAt(index);

                txtStokpanelx.setText("");
            }
        });


        Ekran.getContentPane().add(mesajAlaniStok);
        Ekran.getContentPane().add(mesajAlaniCalisan);
    }

}


