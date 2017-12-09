package tr.edu.medipol.vize1.dogankoc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
//import ileriJavaVizeProjesi.DepoPersoneli;
//import ileriJavaVizeProjesi.KasaPersoneli;
//import ileriJavaVizeProjesi.Mudur;
//import ileriJavaVizeProjesi.Personel;
//import ileriJavaVizeProjesi.PersonelSefi;
//import ileriJavaVizeProjesi.ReyonPersoneli;
//import ileriJavaVizeProjesi.SahaPersoneli;
//import ileriJavaVizeProjesi.SatisSorumlusu;
//import ileriJavaVizeProjesi.Stajyer;
import java.awt.EventQueue;

public class PersonelIslemleri extends JFrame  implements ActionListener{
	static PersonelIslemleri program;
	static String path = System.getProperty("user.home") + File.separator + "Documents";
	
	private static FileInputStream fileInputStream;
	private static InputStreamReader inputStreamReader;
	private static BufferedReader bufferedReader;
	
	private static FileOutputStream fileOutputStream;
	private static OutputStreamWriter outputStreamWriter;
	private static BufferedWriter bufferedWriter;
	
	private static ArrayList<Personel> personeller=new ArrayList<Personel>();
	private static Long id=0L;
	
	JMenuBar menuBar=new JMenuBar();
	JMenu menu=new JMenu("Program");
	JMenuItem kaydetMenuItem ;
	
	StokIslemleri  stokislemleri;
	
	JComboBox<String> secim=new JComboBox<String>();
	JButton Git=new JButton("Git");
	JButton kaydet=new JButton("kaydet");
	JButton sil=new JButton("sil");
	JButton listele=new JButton("listele");
	JButton stokCikisi=new JButton("stokCikisi");
	JButton stokGirisi=new JButton("stokGirisi");


	JPanel panelIslemler=new JPanel();
	static JLabel labelArama=new JLabel();
	static JLabel labelId=new JLabel();
    JLabel label1=new JLabel();
    JLabel label2=new JLabel();
    JLabel label3=new JLabel();
    JLabel label4=new JLabel();
    JLabel label5=new JLabel();
    JLabel label6=new JLabel();

	JTextField ad= new JTextField();
	JTextField soyad= new JTextField();
    JTextField tc= new JTextField();
	JTextField yas= new JTextField();
	JTextField maas= new JTextField();
	JComboBox<String> pozisyon=new JComboBox<String>();
	static JTextField mesajEkrani=new JTextField("MESAJ");
	JTextField aranan=new JTextField();
	
	JEditorPane editorPane = new JEditorPane();
	JScrollPane scrollPane;
	
	public PersonelIslemleri() throws FileNotFoundException,IOException
	{
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(100,20,1000,600);

	    Icon saveIcon = UIManager.getIcon("FileView.floppyDriveIcon");
        //JMenu...
	    JMenuItem personelIslemleri=new JMenuItem("Personel ��lemleri");
	    menu.add(personelIslemleri);
	    
	    JMenuItem stokIslemleri=new JMenuItem("Stok ��lemleri");
	    menu.add(stokIslemleri);
	    
        kaydetMenuItem = new JMenuItem("save", saveIcon);
        menu.add(kaydetMenuItem);
        
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        
		panelIslemler.setLayout(null);
		panelIslemler.setBounds(0,50,1000,600);
        getContentPane().add(panelIslemler);
         
        mesajEkrani.setEditable(false);
            
        scrollPane=new JScrollPane(editorPane);
        scrollPane.setBounds(550,0,400,400);
        editorPane.setEditable(false);
        
        Border etched= BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.blue,Color.gray);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etched,"..Listeleme Ekran�..",
        		                    TitledBorder.CENTER,TitledBorder.TOP,new Font("Serif", Font.BOLD,20),Color.GREEN);
        scrollPane.setBorder(titledBorder);
       
        personelIslemleri.addActionListener(e->{

			panelIslemler.removeAll();
			panelIslemler.repaint();
			label1.setBounds(0,0,200,30);
			label2.setBounds(0,40,200,30);
			label3.setBounds(0,80,200,30);
			label4.setBounds(0,120,200,30);
			label5.setBounds(0,160,200,30);
			label6.setBounds(0,200,200,30);
			labelArama.setBounds(0,240,200,30);
			aranan.setBounds(200,240,200,30);
			label1.setText("Ad:");
			panelIslemler.add(label1);
			label2.setText("Soyad:");
			panelIslemler.add(label2);
			label3.setText("Tc Numaras�:");
			panelIslemler.add(label3);
			label4.setText("Ya�:");
			panelIslemler.add(label4);
			label5.setText("Maa�:");
			panelIslemler.add(label5);
			label6.setText("Pozisyon:");
			panelIslemler.add(label6);
			labelArama.setText("S�L:(Tc veya Id gir)");
			panelIslemler.add(labelArama);
			panelIslemler.add(aranan);
			
			ad.setBounds(200,0,200,30);
			soyad.setBounds(200,40,200,30); 
			tc.setBounds(200,80,200,30);
			yas.setBounds(200,120,200,30);
			maas.setBounds(200,160,200,30);
			pozisyon.setBounds(200,200,200,30);
			mesajEkrani.setBounds(0,300,500,100);
			panelIslemler.add(ad);
			panelIslemler.add(soyad);
			panelIslemler.add(tc);
			panelIslemler.add(yas);
			panelIslemler.add(maas);
			pozisyon.addItem("M�d�r");
			pozisyon.addItem("Personel �efi");
			pozisyon.addItem("Reyon Personeli");
			pozisyon.addItem("Kasa Personeli");
			pozisyon.addItem("Sat�� Sorumlusu");
			pozisyon.addItem("Stajyer");
			pozisyon.addItem("Depo Personeli");	
			panelIslemler.add(pozisyon);
			panelIslemler.add(mesajEkrani);
			panelIslemler.add(scrollPane);
			
		    kaydet.setBounds(420, 0, 80, 60);
		    panelIslemler.add(kaydet);
            listele.setBounds(420, 80, 80, 40);
            panelIslemler.add(listele);
			sil.setBounds(420, 140, 80, 40);
			panelIslemler.add(sil);
            labelId.setBounds(420,240,80,40);
            panelIslemler.add(labelId);
            labelId.setText("ID: "+id);
        });
        stokIslemleri.addActionListener(e->{
			this.dispose();
			stokislemleri=new StokIslemleri();
			stokislemleri.setSize(1000,600);
			stokislemleri.setDefaultCloseOperation(1);
			stokislemleri.setVisible(true);
			stokislemleri.setLocationRelativeTo(null);
        });
        kaydetMenuItem.addActionListener(e->{
				program.kaydetPersonel();

        });
     
	    Git.addActionListener(this);
	    kaydet.addActionListener(this);
	    sil.addActionListener(this);
        listele.addActionListener(this);
        
	    this.setVisible(true);
	    addWindowListener(new Kapat());

	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		JButton tiklanan=(JButton) e.getSource();
		String tiklananButonAdi=tiklanan.getText();
		String islemAdi=String.valueOf(secim.getSelectedItem());
		if(tiklananButonAdi.equals("kaydet")){
						program.kaydetPersonel();
											
				}else if(tiklananButonAdi.equals("listele")){
					try {
						program.listele();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(tiklananButonAdi.equals("sil")){
					   program.sil();
				}			
	}
	
	public void sil() 
	{
		
		String aranan=this.aranan.getText();
        boolean silinecekmi=false;
		StringBuilder strbuild=new StringBuilder();
	
		for( Personel p:personeller)
		{
		    if(p.getId().equals(aranan)||p.getTc().equals(aranan))
		    {
		    	if(p.getPozisyon().equals("M�d�r")){
		    		Mudur o=(Mudur)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.bolum);
		    	}else if(p.getPozisyon().equals("Personel �efi")){
		    		PersonelSefi o=(PersonelSefi)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.bolum);
		    	}else if(p.getPozisyon().equals("Sat�� Sorumlusu")){
		    		SatisSorumlusu o=(SatisSorumlusu)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.bolum);
		    	}else if(p.getPozisyon().equals("Reyon Personeli")){
		    		ReyonPersoneli o=(ReyonPersoneli)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.bolum);
		    	}else if(p.getPozisyon().equals("Stajyer")){
		    		Stajyer o=(Stajyer)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.bolum);
		    	}else if(p.getPozisyon().equals("Depo Personeli")){
		    		DepoPersoneli o=(DepoPersoneli)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.getBolum());
		    	}else if(p.getPozisyon().equals("Kasa Personeli")){
		    		KasaPersoneli o=(KasaPersoneli)p;
		    		strbuild.append(o.getId()+" "+o.ad+" "+o.soyad+" "+o.tc+" "+o.yas+" "+o.maas+" "+o.bolum);
		    	}
				int cevap=JOptionPane.showConfirmDialog(this, strbuild.toString(),"bu personeli silmek istedi�inize eminmisiniz",1,1,null);
				if(cevap==0){
					mesajEkrani.setText("Silindi");
					personeller.remove(p);
				}
				
		        return;
		    }
      

		}

		mesajEkrani.setText("Arad���n�z Personel Bulunamad�");

	}
	

	public  void kaydetPersonel() 
	{
		String ad,soyad,tc,yas,maas,pozisyon;
		ad=this.ad.getText();
		soyad=this.soyad.getText();
		tc=this.tc.getText();
		yas=this.yas.getText();
		maas=this.maas.getText();
		pozisyon=(String) this.pozisyon.getSelectedItem();
		
	    if(ad.isEmpty()||soyad.isEmpty()||tc.isEmpty()||yas.isEmpty()||yas.isEmpty()||maas.isEmpty()){
	    	mesajEkrani.setText("Hi� Bir Alan Bo� B�rak�lamaz");
	    	return;
	    }

        if(pozisyon.equals("Depo Personeli"))
        	personeller.add(new DepoPersoneli(String.valueOf(id),ad,soyad,tc,yas,maas));
        	
        else if(pozisyon.equals("Stajyer"))
        	personeller.add(new Stajyer(String.valueOf(id),ad,soyad,tc,yas,maas));    

        else if(pozisyon.equals("Sat�� Sorumlusu"))
        	personeller.add(new SatisSorumlusu(String.valueOf(id),ad,soyad,tc,yas,maas));     
        	
        else if(pozisyon.equals("Kasa Personeli"))
        	personeller.add(new KasaPersoneli(String.valueOf(id),ad,soyad,tc,yas,maas));      
        	      
        else if(pozisyon.equals("Reyon Personeli"))
        	personeller.add(new ReyonPersoneli(String.valueOf(id),ad,soyad,tc,yas,maas));
        
        else if(pozisyon.equals("Personel �efi"))
        	personeller.add(new PersonelSefi(String.valueOf(id),ad,soyad,tc,yas,maas));
              	
        else if(pozisyon.equals("M�d�r"))
        	personeller.add(new Mudur(String.valueOf(id),ad,soyad,tc,yas,maas));
        	
		id+=1;
		mesajEkrani.setText("kaydedildi..");
        labelId.setText("ID: "+id);
	}
	
	static void verileriYedekle() throws IOException
	{
		
        File dir=new File(path+"\\MTakip"); 
        if(!dir.exists())
        	dir.mkdir();
        
        File file=new File(path+"\\MTakip\\personeller.txt");
        if(!file.exists())
        	file.createNewFile();
        
        
        fileOutputStream=new FileOutputStream(file);
        outputStreamWriter=new OutputStreamWriter(fileOutputStream);
        bufferedWriter=new BufferedWriter(outputStreamWriter);
        
        for(Personel p:personeller){
            if(p.getPozisyon().equals("Depo Personeli")){
            		SahaPersoneli sp=(SahaPersoneli)p;
            		DepoPersoneli dp=(DepoPersoneli)sp;
            		
            		bufferedWriter.write(String.valueOf(id)+" "+dp.ad+" "+dp.soyad+" "+
            	            dp.tc+" "+dp.yas+" "+
            	        			dp.maas+" "+dp.getBolum());
            	
            }
            	
            else if(p.getPozisyon().equals("Stajyer")){
        			Stajyer s=(Stajyer)p;          		
            		bufferedWriter.write(String.valueOf(id)+" "+s.ad+" "+s.soyad+" "+
            	            s.tc+" "+s.yas+" "+
            	        			s.maas+" "+s.bolum);

            }

            else if(p.getPozisyon().equals("Sat�� Sorumlusu")){
        			SahaPersoneli sp=(SahaPersoneli)p;
        			SatisSorumlusu ss=(SatisSorumlusu)sp;
            		
            		bufferedWriter.write(ss.getId()+" "+ss.ad+" "+ss.soyad+" "+
            	            ss.tc+" "+ss.yas+" "+
            	        			ss.maas+" "+ss.bolum);           	
            }
            	
            else if(p.getPozisyon().equals("Kasa Personeli")){
        			SahaPersoneli sp=(SahaPersoneli)p;
        			KasaPersoneli ks=(KasaPersoneli)sp;
            		
            		bufferedWriter.write(ks.getId()+" "+ks.ad+" "+ks.soyad+" "+
            				ks.tc+" "+ks.yas+" "+
            				ks.maas+" "+ks.bolum);          	
            }
            	      
            else if(p.getPozisyon().equals("Reyon Personeli")){
        			SahaPersoneli sp=(SahaPersoneli)p;
        			ReyonPersoneli rp=(ReyonPersoneli)sp;
            		
            		bufferedWriter.write(rp.getId()+" "+rp.ad+" "+rp.soyad+" "+
            				rp.tc+" "+rp.yas+" "+
            				rp.maas+" "+rp.getBolum());          	
            }

            else if(p.getPozisyon().equals("Personel �efi")){
            		PersonelSefi ps=(PersonelSefi)p;         		
            		bufferedWriter.write(ps.getId()+" "+ps.ad+" "+ps.soyad+" "+
            				ps.tc+" "+ps.yas+" "+
            				ps.maas+" "+ps.bolum);            	
            }
            	
            else if(p.getPozisyon().equals("M�d�r")){
            		Mudur md=(Mudur)p;
            		
            		bufferedWriter.write(md.getId()+" "+md.ad+" "+md.soyad+" "+
            				md.tc+" "+md.yas+" "+
            				md.maas+" "+md.bolum);
            }
            	
            bufferedWriter.newLine();
        }

 	    
		bufferedWriter.close();
		
		mesajEkrani.setText("kaydedildi..");
	}
	
	static void verileriAl() throws IOException
	{
		File filePersoneller=new File(path+"\\MTakip\\personeller.txt");
		if(!filePersoneller.exists()){//exists dosya yoksa false d�ner
			return;
		}

		fileInputStream=new FileInputStream(filePersoneller);
		inputStreamReader=new InputStreamReader(fileInputStream);
		bufferedReader=new BufferedReader(inputStreamReader);
		String satir=null;

		while((satir=bufferedReader.readLine())!=null){
			if(!satir.isEmpty()){
				String[] veriler=satir.split(" ");
				String pozisyon=veriler[veriler.length-1];
				if(veriler.length==8)
					pozisyon=veriler[veriler.length-2]+" "+veriler[veriler.length-1];
				    if(pozisyon.equals("Depo Personeli")){
			        	personeller.add(new DepoPersoneli(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
				    }
			        else if(pozisyon.equals("Stajyer")){
			        	personeller.add(new Stajyer(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
			        }
			        else if(pozisyon.equals("Sat�� Sorumlusu")){
			        	personeller.add(new SatisSorumlusu(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
			        }
			        else if(pozisyon.equals("Kasa Personeli")){
			        	personeller.add(new KasaPersoneli(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
			        }
			        else if(pozisyon.equals("Reyon Personeli")){
			        	personeller.add(new ReyonPersoneli(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
			        }
			        else if(pozisyon.equals("Personel �efi")){
			        	personeller.add(new PersonelSefi(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));
			        }
			        else if(pozisyon.equals("M�d�r")){
			        	personeller.add(new Mudur(veriler[0],veriler[1],veriler[2],veriler[3],veriler[4],veriler[5]));		        	
			        }
				    id=Long.valueOf(veriler[0]);
			}
		}
		
	    id+=1;
		bufferedReader.close();
		
		mesajEkrani.setText("Veriler Al�nd�");
	}
	
	public void listele() throws IOException
	{
		
		if(personeller.size()<=0){
			mesajEkrani.setText("Listelenecek veri yok");
			return;
		}
		/*	
		File file= new File(path+"\\MTakip\\personeller.txt");
		Scanner scn=new Scanner(file);
		int index=0;
		String satir=new String();
			
		while(scn.hasNextLine()){
			System.out.println(personeller.size());	
			
			satir=scn.nextLine();
			if(!satir.isEmpty()){//bo�sa true d�ner
				String veriler[]=satir.split(" ");
				System.out.println(personeller.size());
				tumVeriler.append(veriler[index]+" "+veriler[index+1]+" "+veriler[index+2]
						+" "+veriler[index+3]+" "+veriler[index+4]+" "+veriler[index+5]+" "+veriler[index+6]);
				tumVeriler.append("\n");
			}
			}scn.close();
          
		*/
		System.out.println(personeller.size());
		StringBuilder tumVeriler=new StringBuilder();
		for(Personel p:personeller){
			if(p.getPozisyon().equals("M�d�r")){
				Mudur md=(Mudur)p;
				tumVeriler.append( md.getId()+" "+md.ad+" "+md.soyad+" "+md.tc+" "+md.yas+" "+md.maas+" "+md.bolum);
				tumVeriler.append("\n");
			}else if(p.getPozisyon().equals("Personel �efi")){
				PersonelSefi ps=(PersonelSefi)p;
				tumVeriler.append( ps.getId()+" "+ps.ad+" "+ps.soyad+" "+ps.tc+" "+ps.yas+" "+ps.maas+" "+ps.bolum);
				tumVeriler.append("\n");
			}else if(p.getPozisyon().equals("Reyon Personeli")){
				SahaPersoneli sp=(SahaPersoneli)p;
    			ReyonPersoneli rp=(ReyonPersoneli)sp;
				tumVeriler.append( rp.getId()+" "+rp.ad+" "+rp.soyad+" "+rp.tc+" "+rp.yas+" "+rp.maas+" "+rp.bolum);
				tumVeriler.append("\n");
			}else if(p.getPozisyon().equals("Sat�� Sorumlusu")){
    			SahaPersoneli sp=(SahaPersoneli)p;
    			SatisSorumlusu ss=(SatisSorumlusu)sp;
				tumVeriler.append( ss.getId()+" "+ss.ad+" "+ss.soyad+" "+ss.tc+" "+ss.yas+" "+ss.maas+" "+ss.bolum);
				tumVeriler.append("\n");
			}else if(p.getPozisyon().equals("Kasa Personeli")){
    			SahaPersoneli sp=(SahaPersoneli)p;
    			KasaPersoneli kp=(KasaPersoneli)sp;
				tumVeriler.append( kp.getId()+" "+kp.ad+" "+kp.soyad+" "+kp.tc+" "+kp.yas+" "+kp.maas+" "+kp.bolum);
				tumVeriler.append("\n");
			}else if(p.getPozisyon().equals("Depo Personeli")){
				SahaPersoneli sp=(SahaPersoneli)p;
				DepoPersoneli dp=(DepoPersoneli)sp;
				tumVeriler.append( dp.getId()+" "+dp.ad+" "+dp.soyad+" "+dp.tc+" "+dp.yas+" "+dp.maas+" "+dp.getBolum());
				tumVeriler.append("\n");
			}else if(p.getPozisyon().equals("Stajyer")){
				Stajyer st=(Stajyer)p;
				tumVeriler.append( st.getId()+" "+st.ad+" "+st.soyad+" "+st.tc+" "+st.yas+" "+st.maas+" "+st.bolum);
				tumVeriler.append("\n");
			}
		}
		
		editorPane.setText(tumVeriler.toString());
	}


	
	public static void main(String[] args) throws IOException {
		
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	program=new PersonelIslemleri();
	                	program.setLocationRelativeTo(null);
	                	program.setVisible(true);             	  
	                    PersonelIslemleri.verileriAl();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
		
		
	}


	class Kapat extends WindowAdapter{
		
		  public void windowClosing(WindowEvent event){
			    try {
					PersonelIslemleri.verileriYedekle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}      
				System.exit(1);

		  }

		}

}








