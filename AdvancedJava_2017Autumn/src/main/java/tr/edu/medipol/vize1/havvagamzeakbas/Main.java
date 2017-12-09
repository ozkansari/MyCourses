package tr.edu.medipol.vize1.havvagamzeakbas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        new anaMenu();

        File f = new File("stajyer.txt");
        File f2 = new File("personel.txt");
        File f3 = new File("mudur.txt");
        File f4 = new File("kiyafet.txt");
        File f5 = new File("yiyecek.txt");
        File f6 = new File("aksesuar.txt");
        try {
            f.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
            f4.createNewFile();
            f5.createNewFile();
            f6.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class anaMenu {

    private JFrame menu = new JFrame("Ma�aza Menusu");
    private JButton calisanButonu = new JButton("CALISAN VER�LER�");
    private JButton stokButonu = new JButton("STOK VER�LER�");
    private JButton cikisButonu = new JButton("CIKIS");

    public anaMenu() {

    	
        menu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        menu.getContentPane().setBackground(Color.blue);
        
      
        menu.getContentPane().add(calisanButonu);
        menu.getContentPane().add(stokButonu);
        menu.getContentPane().add(cikisButonu);

 
        calisanButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calisanButonu.setSize(300, 0);
                menu.dispose();
                new calisanMenusu();
            }
        });

        stokButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                new stokMenusu();
            }
        });

    
        cikisButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
            }
        });


        menu.setSize(800, 700);
        menu.setLayout(new GridLayout(3, 0));
        menu.setVisible(true);
    }
}

class menu2 {

    protected JFrame secimMenusu;
    protected JButton ekleButonu;
    protected JButton geriDonButonu;
    protected JButton listelemeButonu;
    protected JButton geriDonButon = new JButton("Geri Don");

}

class calisanMenusu extends menu2 {

    public calisanMenusu() {
        secimMenusu = new JFrame("Calisan Menusu");
        ekleButonu = new JButton("Calisan Bilgisi Gir");
        geriDonButonu = new JButton("�nceki Sayfaya D�n");
        listelemeButonu = new JButton("Calisanlari Goruntuleme & Silme");

        secimMenusu.setLayout(new GridLayout(3,3));
        secimMenusu.add(ekleButonu);
        secimMenusu.add(listelemeButonu);
        secimMenusu.add(geriDonButonu);
        secimMenusu.setSize(600,600);
        secimMenusu.setVisible(true);


        ekleButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secimMenusu.dispose();
                new calisanEkleme();
            }
        });
        geriDonButonu.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		secimMenusu.dispose();
        		new anaMenu();
        	}
        });

   
        listelemeButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secimMenusu.dispose();
                new Goruntuleme("Calisan");
            }
        });


        geriDonButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secimMenusu.dispose();
                new anaMenu();
            }
        });
    }
}

class stokMenusu extends menu2 {

    public stokMenusu() {
        secimMenusu = new JFrame("Stok Menusu");
        ekleButonu = new JButton("Stok Ekle");
        JButton silButonu = new JButton("Stok Sil");
        listelemeButonu = new JButton("Stok Goruntule & Silme");

        secimMenusu.setLayout(new GridLayout(3,3));
        secimMenusu.add(ekleButonu);
        secimMenusu.add(listelemeButonu);
        secimMenusu.add(silButonu);
        secimMenusu.setSize(600,600);
        secimMenusu.setVisible(true);


        ekleButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secimMenusu.dispose();
                new StokEklemeSecenekleri();
            }
        });

     
        listelemeButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secimMenusu.dispose();
                new Goruntuleme("Stok");
            }
        });

        geriDonButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secimMenusu.dispose();
                new anaMenu();
            }
        });
    }
}

class EklemeSecenkleri {
    protected JFrame eklemeSecenekleriMenusu;
    protected JButton eklenecekButton1;
    protected JButton eklenecekButton2;
    protected JButton eklenecekButton3;
    protected JButton geriButon = new JButton("Geri Don");

}

class calisanEkleme extends EklemeSecenkleri{

    public calisanEkleme() {

        eklemeSecenekleriMenusu = new JFrame("Calisan Ekleme Secenekleri");
        eklenecekButton1 = new JButton("Stajyer Ekle");
        eklenecekButton2 = new JButton("Personel Ekle");
        eklenecekButton3 = new JButton("Mudur Ekle");

        eklemeSecenekleriMenusu.setLayout(new GridLayout(3,3));
        eklemeSecenekleriMenusu.add(eklenecekButton1);
        eklemeSecenekleriMenusu.add(eklenecekButton2);
        eklemeSecenekleriMenusu.add(eklenecekButton3);
        eklemeSecenekleriMenusu.setSize(600,600);
        eklemeSecenekleriMenusu.setVisible(true);

        this.eklenecekButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new StajyerEklemeIslemleri();
            }
        });

        this.eklenecekButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new PersonelEklemeIslemleri();
            }
        });

        this.eklenecekButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new MudurEklemeIslemleri();
            }
        });

        this.geriButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new calisanMenusu();
            }
        });
    }
}

class StokEklemeSecenekleri extends EklemeSecenkleri{

    public StokEklemeSecenekleri() {

        eklemeSecenekleriMenusu = new JFrame("Stok Ekleme Secenekleri");
        eklenecekButton1 = new JButton("Giyecek Ekle");
        eklenecekButton2 = new JButton("Yiyecek Ekle");
        eklenecekButton3 = new JButton("Aksesuar Ekle");

        eklemeSecenekleriMenusu.setLayout(new GridLayout(3,3));
        eklemeSecenekleriMenusu.add(eklenecekButton1);
        eklemeSecenekleriMenusu.add(eklenecekButton2);
        eklemeSecenekleriMenusu.add(eklenecekButton3);
        eklemeSecenekleriMenusu.setSize(400,400);
        eklemeSecenekleriMenusu.setVisible(true);

        this.eklenecekButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new StokEklemeIslemleri("Giyecek");
            }
        });

        this.eklenecekButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new StokEklemeIslemleri("Yiyecek");
            }
        });

        this.eklenecekButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eklemeSecenekleriMenusu.dispose();
                new StokEklemeIslemleri("Aksesuar");
            }
        });
    }
}

class Goruntuleme {

    private JFrame goruntulemeMenusu = new JFrame("Goruntuleme Menusu");
    private JButton geriButonu = new JButton("Geri Don");
    private JButton silButonu = new JButton("Sil");
    private String[][] tableData;
    private Stajyer stajyer = new Stajyer();
    private Personel personel = new Personel();
    private Mudur mudur = new Mudur();
    private Kiyafet kiyafet = new Kiyafet();
    private Yiyecek yiyecek = new Yiyecek();
    private Aksesuar aksesuar = new Aksesuar();

    public Goruntuleme(final String tabloTipi) {

        String[] basliklar;
        ArrayList data = new ArrayList<String[]>();
        if (tabloTipi.equals("Calisan")) {
            basliklar = new String[] {"Isim", "Soyisim", "TC Kimlik No", "Pozisyon"};

            data.addAll(stajyer.calisanListele());
            data.addAll(personel.calisanListele());
            data.addAll(mudur.calisanListele());

            int length = data.size();

            tableData = new String[length][3];

            for (int i = 0; i < data.size(); i++) {
                tableData[i] = (String[]) data.get(i);
            }
        } else {
            basliklar = new String[] {"Stok Ismi", "StokAdedi", "Stok Numarasi", "Stok Cinsi"};

            data.addAll(kiyafet.stokListele());
            data.addAll(yiyecek.stokListele());
            data.addAll(aksesuar.stokListele());

            int length = data.size();

            tableData = new String[length][4];

            for (int i = 0; i < data.size(); i++) {
                tableData[i] = (String[]) data.get(i);
            }
        }

        final JTable table = new JTable(tableData,basliklar);

        JScrollPane scrollPane = new JScrollPane(table);
        goruntulemeMenusu.add(scrollPane, BorderLayout.CENTER);
        goruntulemeMenusu.add(geriButonu, BorderLayout.LINE_END);
        goruntulemeMenusu.add(silButonu, BorderLayout.SOUTH);
        goruntulemeMenusu.setSize(500, 500);
        goruntulemeMenusu.setVisible(true);

        // Goruntuleme Menusunde Sil Butonun ne is yapacagi
        silButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goruntulemeMenusu.dispose();
                int silinecekIndex = table.getSelectedRow();
                String[] silinecek = tableData[silinecekIndex];

                if (tabloTipi.equals("Calisan")) {
                    if (silinecek[3].equals("Stajyer")) {
                        stajyer.calisanSilme(silinecek[2]);
                    } else if (silinecek[3].equals("Personel")) {
                        personel.calisanSilme(silinecek[2]);
                    } else if (silinecek[3].equals("Mudur")) {
                        mudur.calisanSilme(silinecek[2]);
                    }
                    new anaMenu();
                } else {
                    if (silinecek[3].equals("Giyecek")) {
                        kiyafet.stokSilme(silinecek[2]);
                    } else if (silinecek[3].equals("Yiyecek")) {
                        yiyecek.stokSilme(silinecek[2]);
                    } else if (silinecek[3].equals("Aksesuar")) {
                        aksesuar.stokSilme(silinecek[2]);
                    }
                    new anaMenu();
                }
            }
        });

        geriButonu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goruntulemeMenusu.dispose();
                new anaMenu();
            }
        });
    }
}

class BirimEklemeIslemleri {
    protected JFrame birimEkleme;
    protected JFrame uyariEkrani = new JFrame("Uyari");
    protected JTextField adGirdi = new JTextField();
    protected JTextField soyadGirdi = new JTextField();
    protected JTextField tckimliknoGirdi = new JTextField();
    protected JButton ekleButon = new JButton("Ekle");
    protected JButton geriButon = new JButton("Geri Don");

    public BirimEklemeIslemleri() {
        birimEkleme = new JFrame("Ekleme");
        birimEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        birimEkleme.setLayout(new GridLayout(3,2));
        birimEkleme.add(new JLabel("Adi: "));
        birimEkleme.add(adGirdi);
        birimEkleme.add(new JLabel("Soyadi: "));
        birimEkleme.add(soyadGirdi);
        birimEkleme.add(new JLabel("TC Kimlik No: "));
        birimEkleme.add(tckimliknoGirdi);

        geriButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                birimEkleme.dispose();
                new calisanMenusu();
            }
        });
    }
}

class StajyerEklemeIslemleri extends BirimEklemeIslemleri{


    public StajyerEklemeIslemleri() {
        super();
       
        birimEkleme.getContentPane().add(ekleButon);
        birimEkleme.getContentPane().add(geriButon);
        birimEkleme.setSize(400, 400);
        birimEkleme.setVisible(true);

        ekleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Stajyer stajyer = new Stajyer();

                String isim = adGirdi.getText();
                String soyisim = soyadGirdi.getText();
                String tckn = tckimliknoGirdi.getText();


                if(stajyer != null) {
                    stajyer.calisanEkle(isim, soyisim, tckn);
                    stajyer.dosyayaEkle();
                    JOptionPane.showMessageDialog(uyariEkrani, "Stajyer Eklendi");
                }

                birimEkleme.dispose();
                new calisanMenusu();
            }
        });
    }
}

class PersonelEklemeIslemleri extends BirimEklemeIslemleri{

    public PersonelEklemeIslemleri() {
        super();

        birimEkleme.getContentPane().add(ekleButon);
        birimEkleme.getContentPane().add(geriButon);
        birimEkleme.setSize(400, 400);
        birimEkleme.setVisible(true);

        ekleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Personel personel = new Personel();

                String isim = adGirdi.getText();
                String soyisim = soyadGirdi.getText();
                String tckn = tckimliknoGirdi.getText();

                if(personel != null) {
                    personel.calisanEkle(isim, soyisim, tckn);
                    personel.dosyayaEkle();
                    JOptionPane.showMessageDialog(uyariEkrani, "Personel Eklendi");
                }

                birimEkleme.dispose();
                new calisanMenusu();
            }
        });
    }
}

class MudurEklemeIslemleri extends BirimEklemeIslemleri{

    private JButton ekleButon = new JButton("Ekle");
    private JButton geriButon = new JButton("Geri Don");

    public MudurEklemeIslemleri() {
        super();
    
        birimEkleme.getContentPane().add(ekleButon);
        birimEkleme.getContentPane().add(geriButon);
        birimEkleme.setSize(600, 600);
        birimEkleme.setVisible(true);

        ekleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mudur mudur = new Mudur();

                String isim = adGirdi.getText();
                String soyisim = soyadGirdi.getText();
                String tckn = tckimliknoGirdi.getText();


                if(mudur != null) {
                    mudur.calisanEkle(isim, soyisim, tckn);
                    mudur.dosyayaEkle();
                    JOptionPane.showMessageDialog(uyariEkrani, "Mudur Eklendi");
                }

                birimEkleme.dispose();
                new calisanMenusu();
            }
        });
    }
}

class StokEklemeIslemleri {
    protected JFrame stokEkleme = new JFrame("Stok Ekleme");
    protected JFrame uyariEkrani = new JFrame("Uyari");
    protected JTextField stokIsmiGirdi = new JTextField();
    protected JTextField stokAdediGirdi = new JTextField();
    protected JTextField stokNoGirdi = new JTextField();
    protected JButton ekleButon = new JButton("Ekle");
    protected JButton geriButon = new JButton("Geri Don");

    public StokEklemeIslemleri(final String stokTipi) {
        stokEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stokEkleme.setLayout(new GridLayout(3,2));
        stokEkleme.add(new JLabel("Stok Adi: "));
        stokEkleme.add(stokIsmiGirdi);
        stokEkleme.add(new JLabel("Stok Adedi: "));
        stokEkleme.add(stokAdediGirdi);
        stokEkleme.add(new JLabel("Stok No: "));
        stokEkleme.add(stokNoGirdi);
        stokEkleme.getContentPane().add(ekleButon);
        stokEkleme.getContentPane().add(geriButon);
        stokEkleme.setSize(600, 600);
        stokEkleme.setVisible(true);

        ekleButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String isim = stokIsmiGirdi.getText();
                String adet = stokAdediGirdi.getText();
                String no = stokNoGirdi.getText();

                if (stokTipi.equals("Giyecek")) {
                    Kiyafet giyecek = new Kiyafet();

                    if(giyecek != null) {
                        giyecek.stokEkle(isim, adet, no);
                        giyecek.stokDosyayaEkle();
                        JOptionPane.showMessageDialog(uyariEkrani, "Giyecek Eklendi");
                    }
                } else if (stokTipi.equals("Yiyecek")) {
                    Yiyecek yiyecek = new Yiyecek();

                    if(yiyecek != null) {
                        yiyecek.stokEkle(isim, adet, no);
                        yiyecek.stokDosyayaEkle();
                        JOptionPane.showMessageDialog(uyariEkrani, "Yiyecek Eklendi");
                    }
                } else if (stokTipi.equals("Aksesuar")) {
                    Aksesuar aksesuar = new Aksesuar();

                    if(aksesuar != null) {
                        aksesuar.stokEkle(isim, adet, no);
                        aksesuar.stokDosyayaEkle();
                        JOptionPane.showMessageDialog(uyariEkrani, "Aksesuar Eklendi");
                    }
                }

                stokEkleme.dispose();
                new stokMenusu();
            }
        });

        geriButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stokEkleme.dispose();
                new stokMenusu();
            }
        });
    }
}

