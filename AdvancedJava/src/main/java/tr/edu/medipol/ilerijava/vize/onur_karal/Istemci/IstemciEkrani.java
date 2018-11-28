package tr.edu.medipol.ilerijava.vize.onur_karal.Istemci;
import tr.edu.medipol.ilerijava.vize.onur_karal.Sunucu.SunucuEkrani;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class IstemciEkrani extends SunucuEkrani   {

    private  JTextField SayiAlani;
    private  JTextField SayiAlani2;
    private final JButton SayiGondericiButonu2;
    private final JComboBox işlemler;

    public IstemciEkrani(String title) {
        super(title);
        super.setSize(750,500);

        //SAYI
        JPanel sayigonderimpaneli = new JPanel();
        SayiAlani = new JTextField(10);
        sayigonderimpaneli.add(SayiAlani);
        add(sayigonderimpaneli);

        //Choice
        JPanel işlempaneli = new JPanel();
        işlemler = new JComboBox();
        işlemler.addItem("Toplama '+' ");
        işlemler.addItem("Çıkarma '-' ");
        işlemler.addItem("Çarpma '*' ");
        işlemler.addItem("Bölme '/' ");
        add(işlempaneli);
        işlempaneli.add(işlemler);

        //SAYI
        JPanel SayiGonderimPaneli2 = new JPanel();
        SayiAlani2 = new JTextField(10);
        SayiGonderimPaneli2.add(SayiAlani2);
        SayiGondericiButonu2 = new JButton("Gönder");
        SayiGonderimPaneli2.add(SayiGondericiButonu2);

        //İşlemler
        SayiGondericiButonu2.addActionListener(event -> {
            int sayialani1 = Integer.valueOf(this.SayiAlani.getText());
            int sayialani2 = Integer.valueOf(this.SayiAlani2.getText());
            int sonuc;

            if(işlemler.getSelectedItem().equals("Toplama '+' ")){
               sonuc= Integer.valueOf(sayialani1 + sayialani2);
               getMesajKuyruğu().offer(String.valueOf(sonuc));
            }else if(işlemler.getSelectedItem().equals("Çıkarma '-' ")){
                sonuc= Integer.valueOf(sayialani1 - sayialani2);
                getMesajKuyruğu().offer(String.valueOf(sonuc));
            }else if(işlemler.getSelectedItem().equals("Çarpma '*' ")){
                sonuc= Integer.valueOf(sayialani1 * sayialani2);
                getMesajKuyruğu().offer(String.valueOf(sonuc));
            }else if (işlemler.getSelectedItem().equals("Bölme '/' ")){
                sonuc= Integer.valueOf(sayialani1 / sayialani2);
                getMesajKuyruğu().offer(String.valueOf(sonuc));
            }

            SayiAlani2.setText("");
            SayiAlani.setText("");
        });
        add(SayiGonderimPaneli2);
    }
}

