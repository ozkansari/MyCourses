package tr.edu.medipol.vize1.dogankoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//import ileriJavaVizeProjesi.Baza;
//import ileriJavaVizeProjesi.Bilgisayar;
//import ileriJavaVizeProjesi.Buzdolabi;
//import ileriJavaVizeProjesi.Ceket;
//import ileriJavaVizeProjesi.CepTelefonu;
//import ileriJavaVizeProjesi.Elektronik;
//import ileriJavaVizeProjesi.Firin;
//import ileriJavaVizeProjesi.Gardolap;
//import ileriJavaVizeProjesi.Gomlek;
//import ileriJavaVizeProjesi.IcGiyim;
//import ileriJavaVizeProjesi.Koltuk;
//import ileriJavaVizeProjesi.Masa;
//import ileriJavaVizeProjesi.Pantolon;
//import ileriJavaVizeProjesi.Televizyon;
//import ileriJavaVizeProjesi.Urun;

public class StokIslemleri extends JFrame implements ActionListener{
	
	static String path = System.getProperty("user.home") + File.separator + "Documents";
	private static FileInputStream fileInputStream;
	private static InputStreamReader inputStreamReader;
	private static BufferedReader bufferedReader;
	
	private static FileOutputStream fileOutputStream;
	private static OutputStreamWriter outputStreamWriter;
	private static BufferedWriter bufferedWriter;
	
	private static ArrayList<Urun> urunler=new ArrayList<Urun>();
	
	JComponent panelElektronik,panelGiyim,panelMobilya;
	JTabbedPane tabbedPane = new JTabbedPane();
	
	private static Long idUrun=0L;
	private static int cevapSil=33;
    Border etched= BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.blue,Color.gray);
    TitledBorder titledBorder = BorderFactory.createTitledBorder(etched,"..Listeleme Ekran�..",
    		                    TitledBorder.CENTER,TitledBorder.TOP,new Font("Serif", Font.BOLD,20),Color.GREEN);
    
	//Elektronik
	JButton kaydetElektronik=new JButton("kaydetElektronik");
	JButton silElektronik=new JButton("silElektronik");
	JButton listeleElektronik=new JButton("listeleElektronik");
	JButton geriElektronik=new JButton("geriElektronik");
	
	static JLabel labelAramaElektronik=new JLabel();
	static JLabel labelIdElektronik=new JLabel();
    JLabel label1=new JLabel();
    JLabel label2=new JLabel();
    JLabel label3=new JLabel();
    JLabel label4=new JLabel();
    JLabel label5=new JLabel();
    JLabel label6=new JLabel();

	JTextField seriNoElektronik= new JTextField();
	JTextField fiyatElektronik= new JTextField();
    JTextField markaElektronik= new JTextField();
	JTextField modelElektronik= new JTextField();
	JTextField ozelliklerElektronik= new JTextField();
	JComboBox<String> urunSecimiElektronik= new JComboBox<String>();
	static JTextField mesajEkraniElektronik=new JTextField("MESAJ");
	JTextField arananElektronik=new JTextField();
	
	JScrollPane scrollPaneElektronik;
	JEditorPane editorPaneElektronik=new JEditorPane();

	//Giyim
	JButton kaydetGiyim=new JButton("kaydetGiyim");
	JButton silGiyim=new JButton("silGiyim");
	JButton listeleGiyim=new JButton("listeleGiyim");
	JButton geriGiyim=new JButton("geriGiyim");
	
	static JLabel labelAramaGiyim=new JLabel();
	static JLabel labelIdGiyim=new JLabel();
    JLabel label1Giyim=new JLabel();
    JLabel label2Giyim=new JLabel();
    JLabel label3Giyim=new JLabel();
    JLabel label4Giyim=new JLabel();
    JLabel label5Giyim=new JLabel();
    JLabel label6Giyim=new JLabel();
    JLabel label7Giyim=new JLabel();
    JLabel label8Giyim=new JLabel();
	static JTextField mesajEkraniGiyim=new JTextField("MESAJ");
	JTextField urunKodu= new JTextField();
	JTextField fiyatGiyim= new JTextField();
    JTextField markaGiyim= new JTextField();
	JTextField modelGiyim= new JTextField();
	JTextField beden= new JTextField();
	JComboBox<String> renkGiyim= new JComboBox<String> ();
	JComboBox<String> urunSecimiGiyim= new JComboBox<String>();
	JTextField arananGiyim=new JTextField();
	
	JScrollPane scrollPaneGiyim;
	JEditorPane editorPaneGiyim=new JEditorPane();
	
    //Mobilya
	JButton kaydetMobilya=new JButton("kaydetMobilya");
	JButton silMobilya=new JButton("silMobilya");
	JButton listeleMobilya=new JButton("listeleMobilya");
	JButton geriMobilya=new JButton("geriMobilya");
	
	static JLabel labelAramaMobilya=new JLabel();
	static JLabel labelIdMobilya=new JLabel();
    JLabel label1Mobilya=new JLabel();
    JLabel label2Mobilya=new JLabel();
    JLabel label3Mobilya=new JLabel();
    JLabel label4Mobilya=new JLabel();
    JLabel label5Mobilya=new JLabel();
    JLabel label6Mobilya=new JLabel();
    JLabel label7Mobilya=new JLabel();
	static JTextField mesajEkraniMobilya=new JTextField("MESAJ");
	JTextField arananMobilya=new JTextField();
	JTextField ozelliklerMobilya= new JTextField();
	JTextField fiyatMobilya= new JTextField();
    JTextField markaMobilya= new JTextField();
	JTextField modelMobilya= new JTextField();
	JTextField seriNoMobilya= new JTextField();
	JComboBox<String> urunSecimiMobilya= new JComboBox<String>();
	JComboBox<String> renkMobilya= new JComboBox<String> ();

	JScrollPane scrollPaneMobilya;
	JEditorPane editorPaneMobilya=new JEditorPane();


	public StokIslemleri()
	{	
		scrollPaneElektronik=new JScrollPane(editorPaneElektronik);
		scrollPaneElektronik.setBounds(550,0,400,400);
		editorPaneElektronik.setEditable(false);
		scrollPaneElektronik.setBorder(titledBorder);
        
		panelElektronik=new JPanel();
		panelElektronik.setLayout(null);
		panelElektronik.add(scrollPaneElektronik);
		label1.setBounds(0,0,200,30);
		label2.setBounds(0,40,200,30);
		label3.setBounds(0,80,200,30);
		label4.setBounds(0,120,200,30);
		label5.setBounds(0,160,200,30);
		label6.setBounds(0,200,200,30);
		labelAramaElektronik.setBounds(0,240,200,30);
		arananElektronik.setBounds(200,240,200,30);
		
		mesajEkraniElektronik.setBounds(0,280,500,100);
		mesajEkraniElektronik.setEditable(false);
		
		label1.setText("Seri No:");
		panelElektronik.add(label1);
		label2.setText("Fiyat:");
		panelElektronik.add(label2);
		label3.setText("Marka:");
		panelElektronik.add(label3);
		label4.setText("Model:");
		panelElektronik.add(label4);
		label5.setText("�zellikler:");
		panelElektronik.add(label5);
		label6.setText("�r�n Se�imi:");
		panelElektronik.add(label6);
		labelAramaElektronik.setText("S�L:(Seri No. veya Id gir)");
		panelElektronik.add(labelAramaElektronik);
		panelElektronik.add(arananElektronik);
		panelElektronik.add(mesajEkraniElektronik);

		
		seriNoElektronik.setBounds(200,0,200,30);
		fiyatElektronik.setBounds(200,40,200,30); 
		markaElektronik.setBounds(200,80,200,30);
		modelElektronik.setBounds(200,120,200,30);
		ozelliklerElektronik.setBounds(200,160,200,30);
		urunSecimiElektronik.addItem("Televizyon");
		urunSecimiElektronik.addItem("Buzdolab�");
		urunSecimiElektronik.addItem("Bilgisayar");
		urunSecimiElektronik.addItem("F�r�n");
		urunSecimiElektronik.addItem("Cep Telefonu");
		urunSecimiElektronik.setBounds(200,200,200,30);

		panelElektronik.add(seriNoElektronik);
		panelElektronik.add(fiyatElektronik);
		panelElektronik.add(markaElektronik);
		panelElektronik.add(modelElektronik);
		panelElektronik.add(ozelliklerElektronik);
		panelElektronik.add(urunSecimiElektronik);

	    kaydetElektronik.setBounds(420, 0, 80, 60);   
	    panelElektronik.add(kaydetElektronik);
        listeleElektronik.setBounds(420, 80, 80, 40);
        panelElektronik.add(listeleElektronik);
		silElektronik.setBounds(420, 140, 80, 40);
		panelElektronik.add(silElektronik);
        labelIdElektronik.setBounds(420,240,80,40);
        labelIdElektronik.setText("ID: "+idUrun);
        panelElektronik.add(labelIdElektronik);
        geriElektronik.setBounds(0, 400, 100, 20);
        panelElektronik.add(geriElektronik);
		
		tabbedPane.addTab("Elektronik", panelElektronik);	
        
        geriElektronik.addActionListener(e->{
        	this.dispose();
        	try {
        		PersonelIslemleri.program=new PersonelIslemleri();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        
	//--Giyim ->TabbedPane	
		
        panelGiyim=new JPanel();
        
        panelGiyim.setLayout(null);
		scrollPaneGiyim=new JScrollPane(editorPaneGiyim);
		scrollPaneGiyim.setBounds(550,0,400,400);
		editorPaneGiyim.setEditable(false);
		scrollPaneGiyim.setBorder(titledBorder);
        panelGiyim.add(scrollPaneGiyim);
        
        label1Giyim.setBounds(0,0,200,30);
		label2Giyim.setBounds(0,40,200,30);
		label3Giyim.setBounds(0,80,200,30);
		label4Giyim.setBounds(0,120,200,30);
		label5Giyim.setBounds(0,160,200,30);
		label6Giyim.setBounds(0,200,200,30);
		label7Giyim.setBounds(0,240,200,30);
		labelAramaGiyim.setBounds(0,280,200,30);
		arananGiyim.setBounds(200,280,200,30);
		
		mesajEkraniGiyim.setBounds(0,400,500,50);
		label1Giyim.setText("�r�n Kodu:");
		panelGiyim.add(label1Giyim);
		label2Giyim.setText("Fiyat:");
		panelGiyim.add(label2Giyim);
		label3Giyim.setText("Marka:");
		panelGiyim.add(label3Giyim);
		label4Giyim.setText("Model:");
		panelGiyim.add(label4Giyim);
		label5Giyim.setText("Beden:");
		panelGiyim.add(label5Giyim);
		label6Giyim.setText("Renk:");
		panelGiyim.add(label6Giyim);
		label7Giyim.setText("�r�n Se�imi");
		panelGiyim.add(label7Giyim);
		labelAramaGiyim.setText("S�L:(Id veya �r�n Kodu gir)");
		panelGiyim.add(labelAramaGiyim);
		panelGiyim.add(arananGiyim);
		
		mesajEkraniGiyim.setBounds(0,320,500,100);
		mesajEkraniGiyim.setEditable(false);
		panelGiyim.add(mesajEkraniGiyim);

        urunKodu.setBounds(200,0,200,30);
		fiyatGiyim.setBounds(200,40,200,30); 
		markaGiyim.setBounds(200,80,200,30);
		modelGiyim.setBounds(200,120,200,30);
		beden.setBounds(200,160,200,30);
		renkGiyim.setBounds(200, 200, 200, 30);

		panelGiyim.add(urunKodu);
		panelGiyim.add(fiyatGiyim);
		panelGiyim.add(markaGiyim);
		panelGiyim.add(modelGiyim);
		panelGiyim.add(beden);
		renkGiyim.addItem("K�rm�z�");
		renkGiyim.addItem("Mavi");
		renkGiyim.addItem("Beyaz");
		renkGiyim.addItem("Siyah");
		renkGiyim.addItem("Sar�");
		renkGiyim.addItem("Ye�il");
		panelGiyim.add(renkGiyim);
	
		urunSecimiGiyim.addItem("Ceket");
		urunSecimiGiyim.addItem("Pantolon");
		urunSecimiGiyim.addItem("�� Giyim");
		urunSecimiGiyim.addItem("G�mlek");
		urunSecimiGiyim.setBounds(200,240,200,30);
		panelGiyim.add(urunSecimiGiyim);
		
		kaydetGiyim.setBounds(420, 0, 80, 60); 
	    panelGiyim.add(kaydetGiyim);
        listeleGiyim.setBounds(420, 80, 80, 40);
        panelGiyim.add(listeleGiyim);
		silGiyim.setBounds(420, 140, 80, 40);
		panelGiyim.add(silGiyim);
        labelIdGiyim.setBounds(420,240,80,40);
        labelIdGiyim.setText("ID: "+idUrun);
        panelGiyim.add(labelIdGiyim);
        geriGiyim.setBounds(0, 450, 100, 20);
        panelGiyim.add(geriGiyim);
        
        
        tabbedPane.addTab("Giyim", panelGiyim);
        
        
        geriGiyim.addActionListener(e->{
        	this.dispose();
        	try {
				 PersonelIslemleri.program=new PersonelIslemleri();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        //--JPanel Mobilya
        
        panelMobilya=new JPanel();
        panelMobilya.setLayout(null);
        editorPaneMobilya.setEditable(false);
		scrollPaneMobilya=new JScrollPane(editorPaneMobilya);
		scrollPaneMobilya.setBounds(550,0,400,400);	
		scrollPaneMobilya.setBorder(titledBorder);
		panelMobilya.add(scrollPaneMobilya);
        
	    label1Mobilya.setBounds(0,0,200,30);
		label2Mobilya.setBounds(0,40,200,30);
		label3Mobilya.setBounds(0,80,200,30);
		label4Mobilya.setBounds(0,120,200,30);
		label5Mobilya.setBounds(0,160,200,30);
		label6Mobilya.setBounds(0,200,200,30);
		label7Mobilya.setBounds(0,240,200,30);
			
		mesajEkraniMobilya.setBounds(0,400,500,50);
		label1Mobilya.setText("Seri No:");
		panelMobilya.add(label1Mobilya);
		label2Mobilya.setText("Fiyat:");
		panelMobilya.add(label2Mobilya);
		label3Mobilya.setText("Marka:");
		panelMobilya.add(label3Mobilya);
		label4Mobilya.setText("Model:");
		panelMobilya.add(label4Mobilya);
		label5Mobilya.setText("�zellikler:");
		panelMobilya.add(label5Mobilya);
		label6Mobilya.setText("Renk:");
		panelMobilya.add(label6Mobilya);
		label7Mobilya.setText("�r�n Se�imi");
		panelMobilya.add(label7Mobilya);
		labelAramaMobilya.setText("S�L:(Seri No. veya Id gir)");
			
		labelAramaMobilya.setBounds(0,280,200,30);
		panelMobilya.add(labelAramaMobilya);
			
		arananMobilya.setBounds(200,280,200,30);
		panelMobilya.add(arananMobilya);
			
		mesajEkraniMobilya.setBounds(0,320,500,100);
		mesajEkraniMobilya.setEditable(false);
		panelMobilya.add(mesajEkraniMobilya);

		
		seriNoMobilya.setBounds(200,0,200,30);
		fiyatMobilya.setBounds(200,40,200,30); 
		markaMobilya.setBounds(200,80,200,30);
		modelMobilya.setBounds(200,120,200,30);
		ozelliklerMobilya.setBounds(200,160,200,30);
		renkMobilya.setBounds(200, 200, 200, 30);

		panelMobilya.add(seriNoMobilya);
		panelMobilya.add(fiyatMobilya);
		panelMobilya.add(markaMobilya);
		panelMobilya.add(modelMobilya);
		panelMobilya.add(ozelliklerMobilya);
		renkMobilya.addItem("K�rm�z�");
		renkMobilya.addItem("Mavi");
		renkMobilya.addItem("Beyaz");
		renkMobilya.addItem("Siyah");
		renkMobilya.addItem("Sar�");
		renkMobilya.addItem("Ah�ap");
		panelMobilya.add(renkMobilya);
		
		urunSecimiMobilya.addItem("Masa");
		urunSecimiMobilya.addItem("Gardolap");
		urunSecimiMobilya.addItem("Baza");
		urunSecimiMobilya.addItem("Koltuk");
		urunSecimiMobilya.setBounds(200,240,200,30);
		panelMobilya.add(urunSecimiMobilya);
			
		kaydetMobilya.setBounds(420, 0, 80, 60); 
		panelMobilya.add(kaydetMobilya);
	    listeleMobilya.setBounds(420, 80, 80, 40);
	    panelMobilya.add(listeleMobilya);
		silMobilya.setBounds(420, 140, 80, 40);
		panelMobilya.add(silMobilya);
	    labelIdMobilya.setBounds(420,240,80,40);
	    labelIdMobilya.setText("ID: "+idUrun);
	    panelMobilya.add(labelIdMobilya);
	    geriMobilya.setBounds(0, 450, 100, 20);
	    panelMobilya.add(geriMobilya);
	        
	        
	    tabbedPane.addTab("Mobilya", panelMobilya);
	        
	        
	        geriMobilya.addActionListener(e->{
	        	this.dispose();
	        	try {
	        		 PersonelIslemleri.program=new PersonelIslemleri();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        });
	        
		//Son olarak ,tek tek JPanel leri ekledi�imiz JTabbedPane imizi Frame e ekliyoruz
    	setContentPane(tabbedPane);

    	//Elektronik
	    kaydetElektronik.addActionListener(this);
	    silElektronik.addActionListener(this);
        listeleElektronik.addActionListener(this);

        //Giyim
	    kaydetGiyim.addActionListener(this);
	    silGiyim.addActionListener(this);
        listeleGiyim.addActionListener(this);

        //Mobilya
	    kaydetMobilya.addActionListener(this);
	    silMobilya.addActionListener(this);
        listeleMobilya.addActionListener(this);

        try {
			verileriAl();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		labelIdElektronik.setText(String.valueOf(idUrun));
		labelIdGiyim.setText(String.valueOf(idUrun));
		labelIdMobilya.setText(String.valueOf(idUrun));
		
        addWindowListener(new Kapat());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton tiklanan=(JButton) e.getSource();
		String tiklananButonAdi=tiklanan.getText();
	   
		if(tiklananButonAdi.equals("kaydetElektronik"))
		{
			 String urunTipi=(String) urunSecimiElektronik.getSelectedItem();
			 String seriNo,fiyat,marka,model,ozellikler;
			 switch(urunTipi)
			 {
			     case "Televizyon":	 		
					seriNo=seriNoElektronik.getText();
					fiyat=fiyatElektronik.getText();
					marka=markaElektronik.getText();
					model=modelElektronik.getText();
					ozellikler=ozelliklerElektronik.getText();
					urunler.add(new Televizyon(String.valueOf(idUrun),seriNo,fiyat,marka,model,ozellikler));
				    break;
			     case "Buzdolab�":
					seriNo=seriNoElektronik.getText();
					fiyat=fiyatElektronik.getText();
					marka=markaElektronik.getText();
					model=modelElektronik.getText();
					ozellikler=ozelliklerElektronik.getText();
					urunler.add(new Buzdolabi(String.valueOf(idUrun),seriNo,fiyat,marka,model,ozellikler));
			    	break;
			     case "Bilgisayar":
					seriNo=seriNoElektronik.getText();
					fiyat=fiyatElektronik.getText();
					marka=markaElektronik.getText();
					model=modelElektronik.getText();
					ozellikler=ozelliklerElektronik.getText();
					urunler.add(new Bilgisayar(String.valueOf(idUrun),seriNo,fiyat,marka,model,ozellikler));
			    	break;
			     case "F�r�n":
					seriNo=seriNoElektronik.getText();
					fiyat=fiyatElektronik.getText();
					marka=markaElektronik.getText();
					model=modelElektronik.getText();
					ozellikler=ozelliklerElektronik.getText();
					urunler.add(new Firin(String.valueOf(idUrun),seriNo,fiyat,marka,model,ozellikler));
			    	break;
			     case "Cep Telefonu":
					seriNo=seriNoElektronik.getText();
					fiyat=fiyatElektronik.getText();
					marka=markaElektronik.getText();
					model=modelElektronik.getText();
					ozellikler=ozelliklerElektronik.getText();
					urunler.add(new CepTelefonu(String.valueOf(idUrun),seriNo,fiyat,marka,model,ozellikler));
			    	break;
			 }
			 idUrun+=1;
			 labelIdElektronik.setText(String.valueOf(idUrun));
			 labelIdGiyim.setText(String.valueOf(idUrun));
			 labelIdMobilya.setText(String.valueOf(idUrun));
			 mesajEkraniElektronik.setText("Kaydedildi");
		}
		else if(tiklananButonAdi.equals("kaydetGiyim"))
		{
			 String urunTipi=(String) urunSecimiGiyim.getSelectedItem();
			 String urunKodu_,fiyat,marka,model,beden_,renk_;
			 switch(urunTipi)
			 {
			     case "Ceket":	 		
			    	urunKodu_=urunKodu.getText();
					fiyat=fiyatGiyim.getText();
					marka=markaGiyim.getText();
					model=modelGiyim.getText();
					beden_=beden.getText();
					renk_=(String) renkGiyim.getSelectedItem();
					urunler.add(new Ceket(String.valueOf(idUrun),urunKodu_,fiyat,marka,model,beden_,renk_));
				    break;
			     case "Pantolon":
				    urunKodu_=urunKodu.getText();
					fiyat=fiyatGiyim.getText();
					marka=markaGiyim.getText();
					model=modelGiyim.getText();
					beden_=beden.getText();
					renk_=(String) renkGiyim.getSelectedItem();
					urunler.add(new Pantolon(String.valueOf(idUrun),urunKodu_,fiyat,marka,model,beden_,renk_));
			    	break;
			     case "�� Giyim":
					urunKodu_=urunKodu.getText();
					fiyat=fiyatGiyim.getText();
					marka=markaGiyim.getText();
					model=modelGiyim.getText();
					beden_=beden.getText();
					renk_=(String) renkGiyim.getSelectedItem();
					urunler.add(new IcGiyim(String.valueOf(idUrun),urunKodu_,fiyat,marka,model,beden_,renk_));
			    	break;
			     case "G�mlek":
						urunKodu_=urunKodu.getText();
						fiyat=fiyatGiyim.getText();
						marka=markaGiyim.getText();
						model=modelGiyim.getText();
						beden_=beden.getText();
						renk_=(String) renkGiyim.getSelectedItem();
						urunler.add(new Gomlek(String.valueOf(idUrun),urunKodu_,fiyat,marka,model,beden_,renk_));
				    	break;
			 }
			 idUrun+=1;
			 labelIdElektronik.setText(String.valueOf(idUrun));
			 labelIdGiyim.setText(String.valueOf(idUrun));
			 labelIdMobilya.setText(String.valueOf(idUrun));
			 mesajEkraniGiyim.setText("Kaydedildi");
		}
		else if(tiklananButonAdi.equals("kaydetMobilya"))
		{
			 String urunTipiMobilya=(String) urunSecimiMobilya.getSelectedItem();
			 String seriNoMobilya_,fiyatMobilya_,markaMobilya_,modelMobilya_,ozelliklerMobilya_,renkMobilya_;
			 switch(urunTipiMobilya)
			 {
			     case "Masa":	 		
			    	seriNoMobilya_=seriNoMobilya.getText();
			    	fiyatMobilya_=fiyatMobilya.getText();
			    	markaMobilya_=markaMobilya.getText();
			    	modelMobilya_=modelMobilya.getText();
			    	ozelliklerMobilya_=ozelliklerMobilya.getText();
			    	renkMobilya_=(String) renkMobilya.getSelectedItem();
					urunler.add(new Masa(String.valueOf(idUrun),seriNoMobilya_,fiyatMobilya_,markaMobilya_,modelMobilya_,ozelliklerMobilya_,renkMobilya_));
				    break;
			     case "Gardolap":
			    	seriNoMobilya_=seriNoMobilya.getText();
				    fiyatMobilya_=fiyatMobilya.getText();
				    markaMobilya_=markaMobilya.getText();
				    modelMobilya_=modelMobilya.getText();
				    ozelliklerMobilya_=ozelliklerMobilya.getText();
				    renkMobilya_=(String) renkMobilya.getSelectedItem();
					urunler.add(new Gardolap(String.valueOf(idUrun),seriNoMobilya_,fiyatMobilya_,markaMobilya_,modelMobilya_,ozelliklerMobilya_,renkMobilya_));
			    	break;
			     case "Baza":
			    	seriNoMobilya_=seriNoMobilya.getText();
				    fiyatMobilya_=fiyatMobilya.getText();
				    markaMobilya_=markaMobilya.getText();
				    modelMobilya_=modelMobilya.getText();
				    ozelliklerMobilya_=ozelliklerMobilya.getText();
				    renkMobilya_=(String) renkMobilya.getSelectedItem();
					urunler.add(new Baza(String.valueOf(idUrun),seriNoMobilya_,fiyatMobilya_,markaMobilya_,modelMobilya_,ozelliklerMobilya_,renkMobilya_));
			    	break;
			     case "Koltuk":
			    	seriNoMobilya_=seriNoMobilya.getText();
					fiyatMobilya_=fiyatMobilya.getText();
					markaMobilya_=markaMobilya.getText();
					modelMobilya_=modelMobilya.getText();
					ozelliklerMobilya_=ozelliklerMobilya.getText();
					renkMobilya_=(String) renkMobilya.getSelectedItem();
					urunler.add(new Koltuk(String.valueOf(idUrun),seriNoMobilya_,fiyatMobilya_,markaMobilya_,modelMobilya_,ozelliklerMobilya_,renkMobilya_));
			    	break;
			 }
			 idUrun+=1;
			 labelIdElektronik.setText(String.valueOf(idUrun));
			 labelIdGiyim.setText(String.valueOf(idUrun));
			 labelIdMobilya.setText(String.valueOf(idUrun));
			 mesajEkraniMobilya.setText("Kaydedildi");
		}
		else if(tiklananButonAdi.equals("listeleElektronik"))
		{
			if(urunler.size()<=0)
			{
				mesajEkraniElektronik.setText("Listelenecek Veri Yok");
				return;
			}
						
			StringBuilder strBuilder=new StringBuilder();
			for(Urun u : urunler)
			{
				String urunTipi=u.tur;
				switch(urunTipi)
				{
				    case "Televizyon":
				    	Televizyon t=(Televizyon)u;
				    	strBuilder.append(String.valueOf(t.id)+" "+t.seriNo+" "+t.fiyat+" "+t.marka+" "+t.model+" "+t.ozellikler+" "+t.sinif);
				    	strBuilder.append("\n");
				    	break;
				    case "Buzdolab�":
				    	Buzdolabi bzd=(Buzdolabi)u;
				    	strBuilder.append(String.valueOf(bzd.id)+" "+bzd.seriNo+" "+bzd.fiyat+" "+bzd.marka+" "+bzd.model+" "+bzd.ozellikler+" "+bzd.sinif);
				    	strBuilder.append("\n");
				    	break;
				    case "Bilgisayar":
				    	Bilgisayar blg=(Bilgisayar)u;
				    	strBuilder.append(String.valueOf(blg.id)+" "+blg.seriNo+" "+blg.fiyat+" "+blg.marka+" "+blg.model+" "+blg.ozellikler+" "+blg.sinif);
				    	strBuilder.append("\n");
				    	break;
				    case "F�r�n":
				    	Firin f=(Firin)u;
				    	strBuilder.append(String.valueOf(f.id)+" "+f.seriNo+" "+f.fiyat+" "+f.marka+" "+f.model+" "+f.ozellikler+" "+f.sinif);
				    	strBuilder.append("\n");
				    	break;
				    case "Cep Telefonu":
				    	CepTelefonu cp=(CepTelefonu)u;
				    	strBuilder.append(String.valueOf(cp.id)+" "+cp.seriNo+" "+cp.fiyat+" "+cp.marka+" "+cp.model+" "+cp.ozellikler+" "+cp.sinif);
				    	strBuilder.append("\n");
				    	break;
				}
			}
			editorPaneElektronik.setText(strBuilder.toString());
		}
		else if(tiklananButonAdi.equals("listeleGiyim"))
		{
			if(urunler.size()<=0)
			{
				mesajEkraniGiyim.setText("Listelenecek Veri Yok");
				return;
			}
						
			StringBuilder strBuilder=new StringBuilder();
			for(Urun u : urunler)
			{
				String urunTipi=u.tur;
				switch(urunTipi)
				{
				    case "Ceket":
				    	Ceket o=(Ceket)u;
				    	strBuilder.append(String.valueOf(o.id)+" "+o.urunKodu+" "+o.fiyat+" "+o.marka+" "+o.model+" "+o.beden+" "+o.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				    case "Pantolon":
				    	Pantolon p=(Pantolon)u;
				    	strBuilder.append(String.valueOf(p.id)+" "+p.urunKodu+" "+p.fiyat+" "+p.marka+" "+p.model+" "+p.beden+" "+p.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				    case "�� Giyim":
				    	IcGiyim ig=(IcGiyim)u;
				    	strBuilder.append(String.valueOf(ig.id)+" "+ig.urunKodu+" "+ig.fiyat+" "+ig.marka+" "+ig.beden+" "+ig.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				    case "G�mlek":
				    	Gomlek gm=(Gomlek)u;
				    	strBuilder.append(String.valueOf(gm.id)+" "+gm.urunKodu+" "+gm.fiyat+" "+gm.marka+" "+gm.beden+" "+gm.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				}
				
			}
			editorPaneGiyim.setText(strBuilder.toString());
		}
		
		else if(tiklananButonAdi.equals("listeleMobilya"))
		{
			if(urunler.size()<=0)
			{
				mesajEkraniMobilya.setText("Listelenecek Veri Yok");
				return;
			}
						
			StringBuilder strBuilder=new StringBuilder();
			for(Urun u : urunler)
			{
				String urunTipi=u.tur;
				switch(urunTipi)
				{
				    case "Masa":
				    	Masa o=(Masa)u;
				    	strBuilder.append(String.valueOf(o.id)+" "+o.seriNo+" "+o.fiyat+" "+o.marka+" "+o.model+" "+o.ozellikler+" "+o.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				    case "Gardolap":
				    	Gardolap grd=(Gardolap)u;
				    	strBuilder.append(String.valueOf(grd.id)+" "+grd.seriNo+" "+grd.fiyat+" "+grd.marka+" "+grd.model+" "+grd.ozellikler+" "+grd.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				    case "Baza":
				    	Baza bz=(Baza)u;
				    	strBuilder.append(String.valueOf(bz.id)+" "+bz.seriNo+" "+bz.fiyat+" "+bz.marka+" "+bz.model+" "+bz.ozellikler+" "+bz.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				    case "Koltuk":
				    	Koltuk kl=(Koltuk)u;
				    	strBuilder.append(String.valueOf(kl.id)+" "+kl.seriNo+" "+kl.fiyat+" "+kl.marka+" "+kl.model+" "+kl.ozellikler+" "+kl.renk+" "+urunTipi);
				    	strBuilder.append("\n");
				    	break;
				}
				
			}
			editorPaneMobilya.setText(strBuilder.toString());
		}
		else if(tiklananButonAdi.equals("silElektronik"))
		{
			if(urunler.size()<=0)
			{
				mesajEkraniElektronik.setText("Silinecek Veri Yok");
				return;
			}
			for(Urun u : urunler){
				//Iterator<Urun> ite=urunler.iterator(); ite.hasNext(); Urun o=ite.next();
				if((u.id).equals(arananElektronik.getText()) || (u.seriNo).equals(arananElektronik.getText())){
					cevapSil=JOptionPane.showConfirmDialog(this,u.id+" "+u.seriNo+" "+u.tur+" BU �R�N� S�LMEK �ST�YORMUSUNUZ","!!!!!!", 1,1,null);
				}
				if(cevapSil==0){
					urunler.remove(u);
					cevapSil=33;
					mesajEkraniElektronik.setText("�r�n Stokdan Silindi");
					return;
				}else if(cevapSil==1||cevapSil==2)
					return;       
			}
			mesajEkraniElektronik.setText("Arad���n�z �r�n Bulunamad�");		
		}
		
		else if(tiklananButonAdi.equals("silGiyim"))
		{
			if(urunler.size()<=0)
			{
				mesajEkraniGiyim.setText("Silinecek Veri Yok");
				return;
			}
			for(Urun u : urunler){
				if((u.id).equals(arananGiyim.getText()) || (u.seriNo).equals(arananGiyim.getText())){
					cevapSil=JOptionPane.showConfirmDialog(this,u.id+" "+u.seriNo+" "+u.tur+" BU �R�N� S�LMEK �ST�YORMUSUNUZ","!!!!!!", 1,1,null);
				}
				if(cevapSil==0){
					urunler.remove(u);
					cevapSil=33;
					mesajEkraniGiyim.setText("�r�n Stokdan Silindi");
					return;
				}else if(cevapSil==1||cevapSil==2)
					return;
			}
            
				
		           
			mesajEkraniGiyim.setText("Arad���n�z �r�n Bulunamad�");  
		}
		
		else if(tiklananButonAdi.equals("silMobilya"))
		{
			if(urunler.size()<=0)
			{
				mesajEkraniMobilya.setText("Silinecek Veri Yok");
				return;
			}
			for(Urun u : urunler){
				if((u.id).equals(arananMobilya.getText()) || (u.seriNo).equals(arananMobilya.getText())){
					cevapSil=JOptionPane.showConfirmDialog(this,u.id+" "+u.seriNo+" "+u.tur+" BU �R�N� S�LMEK �ST�YORMUSUNUZ","!!!!!!", 1,1,null);       
				}
				if(cevapSil==0){
					urunler.remove(u);
					cevapSil=33;
					mesajEkraniMobilya.setText("�r�n Stokdan Silindi");
					return;
				}else if(cevapSil==1||cevapSil==2)
					return;
			}

				
		    mesajEkraniMobilya.setText("Arad���n�z �r�n Bulunamad�");      		   
		}
		
	}
	
	
	private static void verileriAl() throws IOException
	{
		File filePersoneller=new File(path+"\\MTakip\\urunler.txt");
		if(!filePersoneller.exists()){//exists dosya yoksa false d�ner
			return;
		}

		fileInputStream=new FileInputStream(filePersoneller);
		inputStreamReader=new InputStreamReader(fileInputStream);
		bufferedReader=new BufferedReader(inputStreamReader);
		String satir=null;
		
		while((satir=bufferedReader.readLine())!=null)
		{
			String[] veriler=new String[satir.length()];
			if(!satir.isEmpty())
			{
					veriler=satir.split(" ");
					String tur=veriler[veriler.length-1];
					switch(tur){
					case"Televizyon":
						urunler.add(new Televizyon(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
						break;
					case"Baza":
						urunler.add(new Baza(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					case"Bilgisayar":
						urunler.add(new Bilgisayar(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
						break;
					case"Buzdolab�":
						urunler.add(new Buzdolabi(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
						break;
					case"Ceket":
						urunler.add(new Ceket(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					case"Telefonu":
						urunler.add(new CepTelefonu(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]+" "+veriler[6]));
						break;
					case"F�r�n":
						urunler.add(new Firin(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
						break;
					case"Gardolap":
						urunler.add(new Gardolap(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					case"G�mlek":
						urunler.add(new Gomlek(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					case"�� Giyim":
						urunler.add(new IcGiyim(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]+" "+veriler[7]));
						break;
					case"Koltuk":
						urunler.add(new Koltuk(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					case"Masa":
						urunler.add(new Masa(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					case"Pantolon":
						urunler.add(new Pantolon(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5],veriler[6]));
						break;
					}
					idUrun=Long.valueOf(veriler[0])+1;
			}
			
		}
		bufferedReader.close();

	}
	
	
	private static void verileriYedekle() throws IOException
	{
        if(urunler.size()<=0)
        	return;
	    File dir=new File(path+"\\MTakip"); 
        if(!dir.exists())
        	dir.mkdir();
        
        File file=new File(path+"\\MTakip\\urunler.txt");
        if(!file.exists())
        	file.createNewFile();
        
        fileOutputStream=new FileOutputStream(file);
        outputStreamWriter=new OutputStreamWriter(fileOutputStream);
        bufferedWriter=new BufferedWriter(outputStreamWriter);
        
        for(Urun u:urunler)
        {
        	String urunTipi= u.tur;
        	switch(urunTipi)
        	{
        	//Elektronik
        	case "Televizyon":
        		Televizyon t=(Televizyon)u;
        		bufferedWriter.write(t.id+" "+t.seriNo+" "+t.fiyat+" "+t.marka+" "+t.model+" "+t.ozellikler+" "+urunTipi);
        		break;
        	case "Cep Telefonu":
        	    CepTelefonu ct=(CepTelefonu)u;
        	    bufferedWriter.write(ct.id+" "+ct.seriNo+" "+ct.fiyat+" "+ct.marka+" "+ct.model+" "+ct.ozellikler+" "+urunTipi);
        	    break;
        	case "F�r�n":
        		Firin f=(Firin)u;
        		bufferedWriter.write(f.id+" "+f.seriNo+" "+f.fiyat+" "+f.marka+" "+f.model+" "+f.ozellikler+" "+urunTipi);
        		break;
        	case "Buzdolab�":
        		Buzdolabi bzd=(Buzdolabi)u;
        		bufferedWriter.write(bzd.id+" "+bzd.seriNo+" "+bzd.fiyat+" "+bzd.marka+" "+bzd.model+" "+bzd.ozellikler+" "+urunTipi);
        		break;
        	case "Bilgisayar":
        		Bilgisayar blg=(Bilgisayar)u;
        		bufferedWriter.write(blg.id+" "+blg.seriNo+" "+blg.fiyat+" "+blg.marka+" "+blg.model+" "+blg.ozellikler+" "+urunTipi);
        		break;
           	//Giyim
        	case "Pantolon":
        		Pantolon pnt=(Pantolon)u;
        		bufferedWriter.write(pnt.id+" "+pnt.urunKodu+" "+pnt.fiyat+" "+pnt.marka+" "+pnt.model+" "+pnt.beden+" "+pnt.renk+" "+urunTipi);
        		break;
        	case "G�mlek":
           		Gomlek gm=(Gomlek)u;
        		bufferedWriter.write(gm.id+" "+gm.urunKodu+" "+gm.fiyat+" "+gm.marka+" "+gm.model+" "+gm.beden+" "+gm.renk+" "+urunTipi);
        		break;
        	case "Ceket":
           		Ceket ckt=(Ceket)u;
        		bufferedWriter.write(ckt.id+" "+ckt.urunKodu+" "+ckt.fiyat+" "+ckt.marka+" "+ckt.model+" "+ckt.beden+" "+ckt.renk+" "+urunTipi);
        		break;
        	case "�� Giyim":
           		IcGiyim icg=(IcGiyim)u;
        		bufferedWriter.write(icg.id+" "+icg.urunKodu+" "+icg.fiyat+" "+icg.marka+" "+" "+icg.beden+" "+icg.renk+" "+urunTipi);
        		break;
        		//Mobilya
           	
        	case "Koltuk":
           		Koltuk kl=(Koltuk)u;
           		bufferedWriter.write(kl.id+" "+kl.seriNo+" "+kl.fiyat+" "+kl.marka+" "+kl.model+" "+kl.renk+" "+kl.ozellikler+" "+urunTipi);
           		break;
        	case "Masa":
           		Masa ms=(Masa)u;
           		bufferedWriter.write(ms.id+" "+ms.seriNo+" "+ms.fiyat+" "+ms.marka+" "+ms.model+" "+ms.renk+" "+ms.ozellikler+" "+urunTipi);
           		break;
        	case "Gardolap":
           		Gardolap gd=(Gardolap)u;
           		bufferedWriter.write(gd.id+" "+gd.seriNo+" "+gd.fiyat+" "+gd.marka+" "+gd.model+" "+gd.renk+" "+gd.ozellikler+" "+urunTipi);
           		break;
        	case "Baza":
           		Baza bz=(Baza)u;
           		bufferedWriter.write(bz.id+" "+bz.seriNo+" "+bz.fiyat+" "+bz.marka+" "+bz.model+" "+bz.renk+" "+bz.ozellikler+" "+urunTipi);
           		break;
        	}
     
        	bufferedWriter.newLine();
        }
        bufferedWriter.close();
		
	}
	class Kapat extends WindowAdapter{
		
		  public void windowClosing(WindowEvent event){
			    try {
					StokIslemleri.verileriYedekle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}      
				System.exit(1);

		  }

		}
}
