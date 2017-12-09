package tr.edu.medipol.vize1.cihangunacti;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.*;
import javax.swing.*;
public class Main  extends JFrame implements ActionListener {
	private static Main proje;
	private static JButton  CalisanEkle;
	private static JButton  StokEkle;
	private static JButton  Cikis;
	private static JButton Kaydet;
	private static JButton  Sil;
	private static JButton  Listele;
	private static JButton  Geri;
	private Action button;
	private ActionStok button2;
	private static JLabel label=new JLabel("AD SOYAD");
	private static JLabel label1=new JLabel("TC NO");
	private static JLabel label2=new JLabel("Maa_");
	private static JLabel label3=new JLabel("__e Giri_ Y_l_");
	private static JLabel label4=new JLabel("Silmek istedi_iniz Personelin Ad_'n_ ve Soyad_'n_ giriniz");
	private static JTextField girdiAd_Soyad=new JTextField();
	private static JTextField TC_NO=new JTextField();
	private static JTextField _cret=new JTextField();
	private static JTextField Giri_Y_l_=new JTextField();
	private static JTextField silPersonel=new JTextField();
	private JTextArea PersonelTextArea=new JTextArea();
	private JComboBox<String>secim=new JComboBox<String>();
	
	//STOK EKLE//
	
	
	private static JButton stokKaydet=new JButton("Kaydet");
	private static JButton stokListele=new JButton("Listele");
	private static JButton stokSil=new JButton("Sil");
	private static JLabel label5=new JLabel("Stok Ad_");
	private static JTextField label5_girdi=new JTextField();
	private static JLabel label6=new JLabel("Stok Kodu");
	private static JTextField label6_girdi=new JTextField();
	private static JLabel label7=new JLabel("KDV");
	private static JLabel label8=new JLabel("Marka");
	private static JLabel label9=new JLabel("Model");
	private static JLabel label10=new JLabel("Stok A__klama");
	private static JLabel label11=new JLabel("_zel Kod");
	private static JLabel label12=new JLabel("Silmek istedi_iniz Stok Ad_n_ giriniz");
	private static JTextField label7_girdi=new JTextField();
	private static JTextField label8_girdi=new JTextField();
	private static JTextField label9_girdi=new JTextField();
	private static JTextField label10_girdi=new JTextField();
	private static JTextField label11_girdi=new JTextField();
	private static JTextField label12_girdi=new JTextField();
	private static JTextArea StokTextArea=new JTextArea();
	
	private JComboBox<String>secim2=new JComboBox<String>();
	

	class geri {
	    public geri() {
	    	ekran1();
	    }
	}
	
	public static void ekran1() 
	{
		 proje =new Main();
	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        JButton button = new JButton("Position Test");
	        panel.setBackground(Color.cyan);
			proje.add(panel);
			proje.pack();
	        proje.setTitle("Ma_aza Y_netim Program_");
	        proje.setSize(400,400);
	        proje.setResizable(false);
	        proje.setVisible(true);
	        proje.setLocationRelativeTo(null);
	        panel.setLayout(null);
	        CalisanEkle = new JButton("_al__an Ekle");
	        StokEkle=new JButton("Stok Ekle");
	        Cikis=new JButton("__k__");
	        panel.add(CalisanEkle);
	        panel.add(StokEkle);
	        panel.add(Cikis);
	        CalisanEkle.setBounds(40, 90, 300, 40);
	        StokEkle.setBounds(40,145,300,40);
	        Cikis.setBounds(40,200,300,40);
	        CalisanEkle.addActionListener(proje);
	      
	        StokEkle.addActionListener(proje);
	        Cikis.addActionListener(proje);
	        proje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ekran1();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 /*CalisanEkle=(JButton) e.getSource();
		 String basilanButonAdi=CalisanEkle.getText();
		 
		 StokEkle=(JButton) e.getSource();
		 String basilanButonAdi1=StokEkle.getText();*/
		 JButton basilan=(JButton) e.getSource();
		 String basilanButonAdi=basilan.getText();
		 
		 
		 if (basilanButonAdi=="_al__an Ekle"){
		proje.dispose();
		 Main proje2=new Main();
		 JPanel panel =new JPanel();
		 panel.setLayout(new GridLayout(20,2));
		 panel.setBackground(Color.cyan);
 		 proje2.add(panel);
         proje2.setTitle("_al__an Ekle");
         proje2.setSize(300,350);
         proje2.setResizable(false);
         proje2.setVisible(true);
         proje2.setLocationRelativeTo(null);
         panel.add(label);
         panel.add(girdiAd_Soyad);
         panel.add(label1);
         panel.add(TC_NO);
         panel.add(label2);
         panel.add(_cret);
         panel.add(label3);
         panel.add(Giri_Y_l_);
         secim.addItem("L_tfen _al__an T_r_n_ Giriniz...");
         secim.addItem("M_d_r");
         secim.addItem("Tasar_mci");
         secim.addItem("IT");
         secim.addItem("Stajyer");
         secim.addItem("G_venlik");
         secim.addItem("Muhasebeci");
         panel.add(secim);
         Kaydet =new JButton("Kaydet");
         panel.add(Kaydet);
         panel.add(label4);
         panel.add(silPersonel);
         Sil = new JButton("Sil");
         panel.add(Sil);
         Listele =new JButton("Listele");
         panel.add(Listele);
         panel.add(PersonelTextArea);
         Kaydet.addActionListener(proje2);
         button=new Action(girdiAd_Soyad,TC_NO,_cret,Giri_Y_l_,secim,PersonelTextArea,silPersonel);
         Kaydet.addActionListener(button);
         button=new Action(girdiAd_Soyad,TC_NO,_cret,Giri_Y_l_,secim,PersonelTextArea,silPersonel);
         Listele.addActionListener(button);
         button=new Action(girdiAd_Soyad,TC_NO,_cret,Giri_Y_l_,secim,PersonelTextArea,silPersonel);
         Sil.addActionListener(button);
         Geri=new JButton("Geri");
         panel.add(Geri);
         Geri.addActionListener(ae -> {
             proje2.dispose();
             new geri();
     });
        }
         
         if(basilanButonAdi=="Stok Ekle") 
         {
        	 Main proje3=new Main();
    		 JPanel panel1 =new JPanel();
     		 panel1.setLayout(new GridLayout(20,2));
     		 panel1.setBackground(Color.cyan);
     		 proje3.add(panel1);
             proje3.setTitle("Ma_aza Y_netim Program_");
             proje3.setSize(300,350);
             proje3.setResizable(false);
             proje3.setVisible(true);
             proje3.setLocationRelativeTo(null);
             panel1.add(label5);
             panel1.add(label5_girdi);
             panel1.add(label6);
             panel1.add(label6_girdi);
             panel1.add(label7);
             panel1.add(label7_girdi);
             panel1.add(label8);
             panel1.add(label8_girdi);
             panel1.add(label10);
             panel1.add(label10_girdi);
             panel1.add(label11);
             panel1.add(label11_girdi);
             secim2.addItem("L_tfen Stok T_r_n_ Giriniz...");
             secim2.addItem("Plazma TV");
             secim2.addItem("Bula__k Makinesi");
             secim2.addItem("Cep Telefonu");
             secim2.addItem("_ama__r Makinesi");
             secim2.addItem("Bilgisayar");
             secim2.addItem("Buzdolab_");
             secim2.addItem("ibi_ mutfak robotu");
             secim2.addItem("Tablet");
             secim2.addItem("");
             panel1.add(secim2);
             panel1.add(stokKaydet);
             stokKaydet.addActionListener(proje3);
             button2=new ActionStok(label5_girdi, label6_girdi, label7_girdi, label8_girdi, label10_girdi, label11_girdi, secim2,StokTextArea,label12_girdi);
             stokKaydet.addActionListener(button2);
             panel1.add(label12);
             panel1.add(label12_girdi);
             panel1.add(StokTextArea);
             panel1.add(stokSil);
             stokSil.addActionListener(proje3);
             button2=new ActionStok(label5_girdi, label6_girdi, label7_girdi, label8_girdi, label10_girdi, label11_girdi, secim2,StokTextArea,label12_girdi);
             stokSil.addActionListener(button2);
             panel1.add(stokListele);
             stokListele.addActionListener(proje3);
             button2=new ActionStok(label5_girdi, label6_girdi, label7_girdi, label8_girdi, label10_girdi, label11_girdi, secim2,StokTextArea,label12_girdi);
             stokListele.addActionListener(button2);
             Geri=new JButton("Geri");
             panel1.add(Geri);
             Geri.addActionListener(ae -> {
                 proje3.dispose();
                 new geri();
         });
         }
         if(basilanButonAdi=="__k__") 
         {
        	 System.exit(0);
         }
}

}



