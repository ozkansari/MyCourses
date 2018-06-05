package tr.edu.medipol.odevler3.emre_yesilyuz;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PrivateKey;

// OZKANS DUZELTME: Eklendi
class Ogrenci {
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ilkframe frame = new ilkframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
// <---

class ilkframe extends JFrame {

    private JPanel contentPane;
    private JTextField txtIsim;
    private JTextField txtSoyisim;
    private JTextField txtDyeri;
    private int ogrno;

    public ilkframe() {
        setTitle("Ogrenciler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 314, 205);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("İsim " ); ;
        lblNewLabel.setBounds(51, 41, 46, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Soyisim");
        lblNewLabel_1.setBounds(51, 78, 46, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("DogmYeri");
        lblNewLabel_3.setBounds(51, 100, 90, 14);
        contentPane.add(lblNewLabel_3);


        txtIsim = new JTextField();
        txtIsim.setBounds(107, 38, 117, 20);
        contentPane.add(txtIsim);
        txtIsim.setColumns(10);

        txtSoyisim = new JTextField();
        txtSoyisim.setBounds(107, 75, 117, 20);
        contentPane.add(txtSoyisim);
        txtSoyisim.setColumns(10);

        txtDyeri = new JTextField();
        txtDyeri.setBounds(107, 100, 117, 20);
        contentPane.add(txtDyeri);
        txtDyeri.setColumns(20);


        //Button Olayı
        JButton btnGonder = new JButton("Ekle");
        btnGonder.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                //ikinci frame i çagırıyoruz.
                ikinciframe ikifrm=new ikinciframe();
                //İsim ve soyismi ikinci framedeki metoda gönderiyoruz.
                //her ne kadar bir JFrame olarak kullansakta bunun bir sınıf olduğunu
                //unutmamak lazım.
                ikifrm.gelenlerVeriler(txtIsim.getText(), txtSoyisim.getText(),txtDyeri.getText());
                //İkinci Jframe görünür hale getiriyor.
                ikifrm.setVisible(true);
            }
        });
        btnGonder.setBounds(135, 125, 89, 23);
        contentPane.add(btnGonder);
    }
}



class ikinciframe extends JFrame {

    private JPanel contentPane;
    //TextField i global olarak tanımlamak önemli çünkü her yerden
    //erişebiliriz buna.
    private JTextField txtGelenler;

/* OZKANS DUZELTME
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    ikinciframe frame = new ikinciframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
*/
    public ikinciframe() {
        setTitle("ÖğrenciBilgileri");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 120);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ÖğrenciBilgileri :");
        lblNewLabel.setBounds(10, 30, 91, 14);
        lblNewLabel.setSize(100,11);
        contentPane.add(lblNewLabel);

        txtGelenler = new JTextField();
        txtGelenler.setBounds(111, 27, 269, 20);
        contentPane.add(txtGelenler);
        txtGelenler.setColumns(10);

    }

    public void gelenlerVeriler(String isim,String soyisim,String dyeri){
        //Gelen verileri txtGelenlere Aktarıyoruz.
        txtGelenler.setText(isim+"//"+soyisim+"//"+dyeri);
    }
}
