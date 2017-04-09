package tr.edu.medipol.ogrenciler.dogankoc.odev4;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Aksiyon implements ActionListener{
	private JComboBox sinifGecici;
	private JTextField adSoyadGecici;
	private JTextField tcnoGecici;
	private JTextField sicilnoGecici;
	private JTextField girisyiliGecici;
	private JTextField maasGecici;
	private JTextArea aciklamaGecici;
	private JTextField aramaGecici;
	public  ArrayList<Personel> personelList=new ArrayList<Personel>();
	public StringBuilder sBuild=new StringBuilder();
	public StringBuilder sBuildTek=new StringBuilder();
	public StringBuilder sBuildSef=new StringBuilder();
	public StringBuilder sBuildMuh=new StringBuilder();
	public StringBuilder sBuildYont=new StringBuilder();
	public Aksiyon(JComboBox sinif,JTextField adsoyad,JTextField tcno ,JTextField sicilno,JTextField girisyili,JTextField maas,JTextArea aciklama,JTextField arama ) {
		sinifGecici=sinif;        adSoyadGecici=adsoyad;       tcnoGecici=tcno;  aramaGecici=arama;
		sicilnoGecici=sicilno;    girisyiliGecici=girisyili; maasGecici=maas;   aciklamaGecici=aciklama;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		JButton gelenNesne=(JButton)arg0.getSource();
		String butonAdi=gelenNesne.getText();
		if(butonAdi=="Kaydet"){
			String personelSinifi=(String)sinifGecici.getSelectedItem();
			String sicilno = sicilnoGecici.getText();
			String adSoyad = adSoyadGecici.getText();
			String tcNo = tcnoGecici.getText();
			String girisYili = girisyiliGecici.getText();
			String maas = maasGecici.getText();
			String aciklama=aciklamaGecici.getText();
			//Main get=new Main();
			Main.setMesajEkrani("");
			Main.setGirisAdSoyad();
			Main.setGirisTcNo();
			Main.setSicilNo();
			Main.setGirisYil();
			Main.setGirisUcret();
			Main.setAciklama();
			Main.setMesajEkrani("Kay�t Girildi...");

			if(personelSinifi.equals("Saha Personeli")){
				personelList.add(new Saha(sicilno,personelSinifi,adSoyad,tcNo,girisYili,maas,aciklama));
		    }
			else if(personelSinifi.equals("Teknisyen")){
				personelList.add(new Teknisyen(sicilno,personelSinifi,adSoyad,tcNo,girisYili,maas,aciklama));
		    }
			else if(personelSinifi.equals("Sef")){
				personelList.add(new Sef(sicilno,personelSinifi,adSoyad,tcNo,girisYili,maas,aciklama));
		    }
			else if(personelSinifi.equals("Muhendis")){
				personelList.add(new Muhendis(sicilno,personelSinifi,adSoyad,tcNo,girisYili,maas,aciklama));
		    }
			else if(personelSinifi.equals("Yonetici")){
				personelList.add(new Yonetici(sicilno,personelSinifi,adSoyad,tcNo,girisYili,maas,aciklama));
		    }
		}

		if(butonAdi=="Listele"){
	
				Main.mesajEkrani.setText("");
				Main.setMesajEkrani("Listeleniyor");
				JTextArea listArea=new JTextArea();
				listArea.setEditable(false);
				JFrame listEkrani =new JFrame("Personeller");
				listEkrani.setVisible(true);
				listEkrani.setLocation(50, 60);
				listEkrani.setSize(1000,500);
				listEkrani.add(listArea);
				listEkrani.setDefaultCloseOperation(1);
				String prslst = null;
				for(int i=0 ;i< personelList.size();i++){
					Personel p=personelList.get(i);
					
					if(p.personelSinifi.equals("Saha Personeli")){
					sBuild.append(((Saha) p).getEleman()); //�nerilen String ekleme i�lemi..
					sBuild.append(" \n");
					}
					if(p.personelSinifi.equals("Teknisyen")){
						sBuild.append(((Teknisyen) p).getTeknisyen());
						sBuild.append(" \n");
					}
					if(p.personelSinifi.equals("Sef")){
						sBuild.append(((Sef) p).getSef());
						sBuild.append(" \n");

					}
					if(p.personelSinifi.equals("Muhendis")){
						sBuild.append(((Muhendis) p).getMuhendis());
						sBuild.append(" \n");
					}
					if(p.personelSinifi.equals("Yonetici")){
						sBuild.append(((Yonetici) p).getYonetici());
						sBuild.append(" \n");
					}	
					//String toplam = null;
					//buffer.append(p.getEleman());   ****eski denemeler***
					//toplam+=p.getEleman();  sak�cal� toplama �ekli
					//Main.mesajEkrani.setText(toplam);
					//Main.setMesajEkrani2(personelList);
					prslst=new String(sBuild.toString());
	
				}
				listArea.setText(prslst);
				sBuild.delete(0, sBuild.length());
		}
		
		if(butonAdi=="Bul"){
			String arananPrsnlTipi;
			String personel = new String();
			for(int i=0 ;i< personelList.size();i++){
				Personel pAra=personelList.get(i);
				String scn=aramaGecici.getText();
				if(scn.equals(pAra.sicilno)){
					Main.mesajEkrani.setText("");
					Main.setMesajEkrani("Aranan Personel Bulundu");
					JTextArea bulArea=new JTextArea();
					bulArea.setText("");
					bulArea.setEditable(false);
					JFrame bulEkran =new JFrame("Personel Arama...");
					bulEkran.setVisible(true);
					bulEkran.setLocation(50, 60);
					bulEkran.setSize(1000,500);
					bulEkran.add(bulArea);
					bulEkran.setDefaultCloseOperation(1);
					
					arananPrsnlTipi=pAra.personelSinifi;
				if(arananPrsnlTipi.equals("Saha Personeli")){
					personel=new String( ((Saha) pAra).getEleman());
				}
				if(arananPrsnlTipi.equals("Teknisyen")){
					personel=new String( ((Teknisyen) pAra).getTeknisyen());
				}
				if(arananPrsnlTipi.equals("Sef")){
					personel=new String( ((Sef) pAra).getSef() );
				}
				if(arananPrsnlTipi.equals("Muhendis")){
					personel=new String( ((Muhendis) pAra).getMuhendis() );
				}
				if(arananPrsnlTipi.equals("Yonetici")){
					personel=new String( ((Yonetici) pAra).getYonetici() );		
				}	
					bulArea.setText(personel);
				}
				else{
					Main.mesajEkrani.setText("Arad���n�z personel Bulunamad�...");
				}
			}
			
		}

		
		if(butonAdi=="Sil"){
			Main.mesajEkrani.setText("");
			
			for(int i=0 ;i< personelList.size();i++){
				Personel pSil=personelList.get(i);
				String psilinen=aramaGecici.getText();
				if(psilinen.equals(pSil.sicilno)){
					personelList.remove(pSil);
					Main.setMesajEkrani(psilinen+": Sicil Nolu Personel Silindi... ");
				}
				else{
					Main.mesajEkrani.setText("B�yle bir Personel yok..");
				}
		    }
		
	    }

	}

}
