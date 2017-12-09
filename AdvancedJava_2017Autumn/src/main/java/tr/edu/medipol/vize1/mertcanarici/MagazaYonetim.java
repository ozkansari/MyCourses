package tr.edu.medipol.vize1.mertcanarici;

// package tr.edu.medipol.vize1.mertcanarici;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MagazaYonetim {
    public static void main(String[] args) {
        new AnaMenu();
    }
}

class AnaMenu{
    private JFrame AnaMenu = new JFrame("MAĞAZA YÖNETİM");
    private JButton CalısanBtn = new JButton("Mağaza Çalışan");
    private JButton StokBtn = new JButton("Mağaza Stok");
    private JButton CıkısButon = new JButton("Çıkış");

    public AnaMenu() {

        String Store ="Mağaza Yönetim";
        JLabel Slabel = new JLabel(Store);
        Slabel.setFont(new Font("Georgia", Font.BOLD, 50));
        Slabel.setForeground(Color.WHITE);
        Slabel.setBounds(750, 300, 500, 100);

        CalısanBtn.setBounds(760, 450, 200, 80);
        CalısanBtn.setFont(new Font("Georgia", Font.BOLD, 20));
        CalısanBtn.addActionListener(eeee -> {
                    CalisanOpen();
                }
        );

        StokBtn.setBounds(960, 450, 200, 80);
        StokBtn.setFont(new Font("Georgia", Font.BOLD, 20));
        StokBtn.addActionListener(eeee -> {
            StokOpen();
                }
        );

        CıkısButon.setBounds(860, 600, 200, 80);
        CıkısButon.setFont(new Font("Georgia", Font.BOLD, 20));
        CıkısButon.addActionListener(eeee -> {
                    System.exit(0);
                }
        );

        AnaMenu.getContentPane().add(Slabel);
        AnaMenu.getContentPane().add(CalısanBtn);
        AnaMenu.getContentPane().add(StokBtn);
        AnaMenu.getContentPane().add(CıkısButon);

        AnaMenu.setLayout(null);
        AnaMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        AnaMenu.setSize(1920, 1080);
        AnaMenu.setLocationRelativeTo(null);
        AnaMenu.setVisible(true);
        AnaMenu.getContentPane().setBackground(Color.BLACK);

    }

    private void CalisanOpen() {
        AnaMenu.dispose();
        new Calisan();
    }

    private void StokOpen(){
        AnaMenu.dispose();
        new Stok();
    }
}

class Calisan{
    private JFrame Calisan = new JFrame("MAĞAZA YÖNETİM");
    JTable Tablo = new JTable();
    private JButton AnaButon = new JButton("Menü");
    JTextField CAdTxt, CSoyadTxt, CDepartmanTxt;
    private JButton btnEkle = new JButton("Ekle");
    private JButton btnSil = new JButton("Sil");
    private JButton btnGuncelle = new JButton("Güncelle");


    public Calisan() {

        String Store ="Mağaza Yönetim";
        JLabel Slabel = new JLabel(Store);
        Slabel.setFont(new Font("Georgia", Font.BOLD, 40));
        Slabel.setForeground(Color.WHITE);
        Slabel.setBounds(750, 0, 500, 100);

        String calisan ="Mağaza Çalışan";
        JLabel Mcalisan = new JLabel(calisan);
        Mcalisan.setFont(new Font("Georgia", Font.BOLD, 30));
        Mcalisan.setForeground(Color.WHITE);
        Mcalisan.setBounds(800, 55, 250, 100);

        String cad ="Adı";
        JLabel CAd = new JLabel(cad);
        CAd.setFont(new Font("Georgia", Font.BOLD, 20));
        CAd.setForeground(Color.WHITE);
        CAd.setBounds(540, 280, 250, 100);

        CAdTxt = new JTextField(250);
        CAdTxt.setBounds(350,350,400,35);
        CAdTxt.setFont (new Font("Georgia", Font.BOLD, 25));

        String csoyad ="Soyadı";
        JLabel CSoyad = new JLabel(csoyad);
        CSoyad.setFont(new Font("Georgia", Font.BOLD, 20));
        CSoyad.setForeground(Color.WHITE);
        CSoyad.setBounds(525, 380, 250, 100);

        CSoyadTxt =new JTextField(250);
        CSoyadTxt.setBounds(350,450,400,35);
        CSoyadTxt.setFont (new Font("Georgia", Font.BOLD, 25));

        String cdepartman ="Departmanı";
        JLabel CDepartman = new JLabel(cdepartman);
        CDepartman.setFont(new Font("Georgia", Font.BOLD, 20));
        CDepartman.setForeground(Color.WHITE);
        CDepartman.setBounds(500, 480, 250, 100);

        CDepartmanTxt =new JTextField(250);
        CDepartmanTxt.setBounds(350,550,400,35);
        CDepartmanTxt.setFont (new Font("Georgia", Font.BOLD, 25));

        Object[] columns = {"AD", "SOYAD", "DEPARTMAN"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        Tablo.setModel(model);

        Tablo.setBackground(Color.LIGHT_GRAY);
        Tablo.setForeground(Color.black);
        Font font = new Font("",1,25);
        Tablo.setFont(font);
        Tablo.setRowHeight(35);
        Tablo.getTableHeader().setBackground(Color.WHITE);
        Tablo.getTableHeader().setFont(new Font("", Font.BOLD, 20));

        btnEkle.setBounds(800, 350, 150, 40);
        btnEkle.setFont(new Font("Georgia", Font.BOLD, 18));
        btnGuncelle.setBounds(800, 450, 150, 40);
        btnGuncelle.setFont(new Font("Georgia", Font.BOLD, 18));
        btnSil.setBounds(800, 550, 150, 40);
        btnSil.setFont(new Font("Georgia", Font.BOLD, 18));

        JScrollPane pane = new JScrollPane(Tablo);
        pane.setBounds(1000, 250, 800, 450);

        Calisan.setLayout(null);

        Calisan.add(pane);

        Calisan.add(CAdTxt);
        Calisan.add(CSoyadTxt);
        Calisan.add(CDepartmanTxt);

        Calisan.add(btnEkle);
        Calisan.add(btnSil);
        Calisan.add(btnGuncelle);

        Object[] row = new Object[3];

        btnEkle.addActionListener(eeee ->  {

                row[0] = CAdTxt.getText();
                row[1] = CSoyadTxt.getText();
                row[2] = CDepartmanTxt.getText();

                model.addRow(row);

        });

        btnSil.addActionListener(eeee -> {

                int i = Tablo.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tabloda veri bulunmamaktadır", "SİL",JOptionPane.ERROR_MESSAGE);
                }

        });

        Tablo.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e){

                int i = Tablo.getSelectedRow();

                CAdTxt.setText(model.getValueAt(i, 0).toString());
                CSoyadTxt.setText(model.getValueAt(i, 1).toString());
                CDepartmanTxt.setText(model.getValueAt(i, 2).toString());
            };
        });

        btnGuncelle.addActionListener(eeee -> {

                int i = Tablo.getSelectedRow();

                if(i >= 0)
                {
                    model.setValueAt(CAdTxt.getText(), i, 0);
                    model.setValueAt(CSoyadTxt.getText(), i, 1);
                    model.setValueAt(CDepartmanTxt.getText(), i, 2);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tabloda veri bulunmamaktadır", "SİL",JOptionPane.ERROR_MESSAGE);
                }

        });

        AnaButon.setBounds(1700, 50, 100, 50);
        AnaButon.addActionListener(eeee -> {
                    AnaMenuOpen();
                }
        );

        Calisan.getContentPane().add(Slabel);
        Calisan.getContentPane().add(Mcalisan);
        Calisan.getContentPane().add(CAd);
        Calisan.getContentPane().add(CAdTxt);
        Calisan.getContentPane().add(CSoyad);
        Calisan.getContentPane().add(CSoyadTxt);
        Calisan.getContentPane().add(CDepartman);
        Calisan.getContentPane().add(CDepartmanTxt);
        Calisan.getContentPane().add(AnaButon);

        Calisan.setLayout(null);
        Calisan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Calisan.setSize(1920, 1080);
        Calisan.setLocationRelativeTo(null);
        Calisan.setVisible(true);
        Calisan.getContentPane().setBackground(Color.BLACK);
    }
    private void AnaMenuOpen() {
        Calisan.dispose();
        new AnaMenu();
    }

}

class Stok{
    private JFrame Stok = new JFrame("MAĞAZA YÖNETİM");
    JTable Tablo = new JTable();
    private JButton AnaButon = new JButton("Menü");
    JTextField SAdTxt, SKategoriTxt;
    private JButton btnEkle = new JButton("Ekle");
    private JButton btnSil = new JButton("Sil");
    private JButton btnGuncelle = new JButton("Güncelle");


    public Stok() {

        String Store ="Mağaza Yönetim";
        JLabel Slabel = new JLabel(Store);
        Slabel.setFont(new Font("Georgia", Font.BOLD, 40));
        Slabel.setForeground(Color.WHITE);
        Slabel.setBounds(750, 0, 500, 100);

        String stok ="Mağaza Stok";
        JLabel Mstok = new JLabel(stok);
        Mstok.setFont(new Font("Georgia", Font.BOLD, 30));
        Mstok.setForeground(Color.WHITE);
        Mstok.setBounds(820, 55, 250, 100);

        String sad ="Ad:";
        JLabel SAd = new JLabel(sad);
        SAd.setFont(new Font("Georgia", Font.BOLD, 20));
        SAd.setForeground(Color.WHITE);
        SAd.setBounds(550, 280, 250, 100);

        SAdTxt = new JTextField(250);
        SAdTxt.setBounds(350,350,400,35);
        SAdTxt.setFont(new Font("Georgia", Font.BOLD, 25));

        String skategori ="Kategori";
        JLabel SKategori = new JLabel(skategori);
        SKategori.setFont(new Font("Georgia", Font.BOLD, 20));
        SKategori.setForeground(Color.WHITE);
        SKategori.setBounds(525, 380, 250, 100);

        SKategoriTxt =new JTextField(250);
        SKategoriTxt.setBounds(350,450,400,35);
        SKategoriTxt.setFont(new Font("Georgia", Font.BOLD, 25));

        Object[] columns = {"AD", "KATEGORİ"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        Tablo.setModel(model);

        Tablo.setBackground(Color.LIGHT_GRAY);
        Tablo.setForeground(Color.black);
        Font font = new Font("",1,25);
        Tablo.setFont(font);
        Tablo.setRowHeight(35);
        Tablo.getTableHeader().setBackground(Color.WHITE);
        Tablo.getTableHeader().setFont(new Font("", Font.BOLD, 20));

        btnEkle.setBounds(800, 350, 150, 40);
        btnEkle.setFont(new Font("Georgia", Font.BOLD, 18));
        btnGuncelle.setBounds(800, 450, 150, 40);
        btnGuncelle.setFont(new Font("Georgia", Font.BOLD, 18));
        btnSil.setBounds(800, 550, 150, 40);
        btnSil.setFont(new Font("Georgia", Font.BOLD, 18));

        JScrollPane pane = new JScrollPane(Tablo);
        pane.setBounds(1000, 250, 800, 450);

        Stok.setLayout(null);

        Stok.add(pane);

        Stok.add(SAdTxt);
        Stok.add(SKategoriTxt);

        Stok.add(btnEkle);
        Stok.add(btnSil);
        Stok.add(btnGuncelle);

        Object[] row = new Object[2];

        btnEkle.addActionListener(eeee -> {

                row[0] = SAdTxt.getText();
                row[1] = SKategoriTxt.getText();

                model.addRow(row);

        });

        btnSil.addActionListener(eeee ->  {

                int i = Tablo.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tabloda veri bulunmamaktadır", "SİL",JOptionPane.ERROR_MESSAGE);
                }

        });

        Tablo.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e){

                int i = Tablo.getSelectedRow();

                SAdTxt.setText(model.getValueAt(i, 0).toString());
                SKategoriTxt.setText(model.getValueAt(i, 1).toString());
            }
        });

        btnGuncelle.addActionListener(eeee ->  {

                int i = Tablo.getSelectedRow();

                if(i >= 0)
                {
                    model.setValueAt(SAdTxt.getText(), i, 0);
                    model.setValueAt(SKategoriTxt.getText(), i, 1);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tabloda veri bulunmamaktadır", "SİL",JOptionPane.ERROR_MESSAGE);
                }

        });



        AnaButon.setBounds(1700, 50, 100, 50);
        AnaButon.addActionListener(eeee -> {
                    AnaMenuOpen();
                }
        );

        Stok.getContentPane().add(Slabel);
        Stok.getContentPane().add(Mstok);
        Stok.getContentPane().add(SAd);
        Stok.getContentPane().add(SAdTxt);
        Stok.getContentPane().add(SKategori);
        Stok.getContentPane().add(SKategoriTxt);
        Stok.getContentPane().add(AnaButon);

        Stok.setLayout(null);
        Stok.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Stok.setSize(1920, 1080);
        Stok.setLocationRelativeTo(null);
        Stok.setVisible(true);
        Stok.getContentPane().setBackground(Color.BLACK);
    }
    private void AnaMenuOpen() {
        Stok.dispose();
        new AnaMenu();
    }

}