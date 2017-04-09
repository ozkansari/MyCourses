package tr.edu.medipol.ogrenciler.dogankoc.odev4;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import javax.*;
import javax.swing.*;
public class Main extends JFrame {
    private JTextField etiket1=new JTextField();
    private JLabel etiket2=new JLabel("TC NO:");
    private JLabel etiket3=new JLabel("SICIL NO:");
    private JLabel etiket4=new JLabel("ISE GIRIS  YILI:");
    private JLabel etiket5=new JLabel("UCRET:");
    private static JTextField girisAdSoyad=new JTextField();
    private static JTextField girisTcNo=new JTextField();
    private static JTextField girisSicilNo=new JTextField();
    private static JTextField girisYil=new JTextField();
    private static JTextField girisUcret=new JTextField();
    private JComboBox<String> kategori=new JComboBox<String>();
    private static JTextArea aciklama=new JTextArea("Aciklama:");
    static JTextArea mesajEkrani=new JTextArea("MESAJ:");
    private JLabel etiket6=new JLabel("BULMAK ISTEDIGINIZ PERSONELIN SICIL NUMARASINI GIRIN:");
    private static JTextField arama=new JTextField();
     
    private JButton kaydet=new JButton("Kaydet");
    private JButton listele=new JButton("Listele");
    private JButton bul=new JButton("Bul");
    private JButton sil=new JButton("Sil");
   

	public static void main(String args[]) {
		
		Main prog=new Main();
		prog.make();//�nce bu fonksiyon �a��r�lmassa i�inde olu�turulan objeleri bilmedi�inden pencere olu�turuldu�unda objeler penceredeki yerini alm�yor 
		prog.setTitle("Personel Kayit Programi");
		prog.setSize(1000,600);
		prog.setVisible(true);
		prog.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void make(){
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(20,2));
		etiket1.setText("AD SOYAD:");
		etiket1.setEditable(false);
		mesajEkrani.setEditable(false);
		panel.add(etiket1);
		panel.add(girisAdSoyad);
		panel.add(etiket2);
		panel.add(girisTcNo);
		panel.add(etiket3);
		panel.add(girisSicilNo);
		panel.add(etiket4);
		panel.add(girisYil);
		panel.add(etiket5);
		panel.add(girisUcret);
		kategori.addItem("Saha Personeli");
		kategori.addItem("Muhendis");
		kategori.addItem("Teknisyen");
		kategori.addItem("Sef");
		kategori.addItem("Yonetici");
		panel.add(kategori);
		panel.add(aciklama);
		panel.add(kaydet);
		panel.add(mesajEkrani);
		panel.add(listele);
		panel.add(etiket6);
		panel.add(arama);
		panel.add(bul);
		panel.add(sil);
		add(panel);

		Aksiyon ok=new Aksiyon(kategori,girisAdSoyad,girisTcNo,girisSicilNo,girisYil,girisUcret,aciklama,arama);
		kaydet.addActionListener(ok);
        listele.addActionListener(ok);
        bul.addActionListener(ok);
        sil.addActionListener(ok);
	}
	static JTextArea getMesajEkrani(){
		return mesajEkrani;
	}
	/*static void setMesajEkrani2(StringBuilder sb){ ayn� sayfada istedi�im gibi t�m bilgieri
		String liste=sb.toString();                  listeliyebilece�im bir s�n�f nesnesi �retemedi�im
		String yeniSatir=" \n";                      i�in listele butonu i�in actionPerformed da yeni
		mesajEkrani.append(liste+yeniSatir);         frame  olu�turdum....
	}*/
	static void setMesajEkrani(String mesajGecici){	
		mesajEkrani.setText(mesajGecici);
	}
	 static void setGirisAdSoyad(){
		girisAdSoyad.setText("");
	}
	 static void setGirisTcNo(){
		girisTcNo.setText("");
	}
	static void setSicilNo(){
		girisSicilNo.setText("");
	}
	
	static void setGirisYil(){
	    girisYil.setText("");
	}

	static void setGirisUcret(){
	    girisUcret.setText("");
	}
	
	static void setAciklama(){
		aciklama.setText("Aciklama:");
	}

	}

