package tr.edu.medipol.bank1;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BankaProgrami extends JFrame implements ActionListener {

	/* ------------------------------------------------------- */
	/* TANIMLAR ve DEGISKENLER */
	/* ------------------------------------------------------- */
	
	private static final int IDX_CEKILECEK = 3;

	private static final int IDX_YATIRILACAK = 2;

	private static final int IDX_ILKBAKIYE = 1;

	private static final int IDX_HESAPNO = 0;

	/**
	 * Sinif ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Islem yapma butonu icin belirtec
	 */
	private static final String ISLEM_GERCEKLESTIR_ADIMI = "ISLEM YAP";

	/**
	 * Hesap olusturma butonu icin belirtec
	 */
	private static final String HESAP_OLUSTURMA_ADIMI = "HESAP OLUSTUR";

	/**
	 * Ekranda gosterilecek mesaj icin ayrilmis alan 1
	 */
	private JLabel mesajAlani1 = new JLabel(
			"                                                                                                                                          ");
	/**
	 * Ekranda gosterilecek mesaj icin ayrilmis alan 2
	 */
	private JLabel mesajAlani2 = new JLabel(
			"                                                                                                                                          ");
	
	private JTextField girisAlanlari[] = new JTextField[4];
	private JLabel ekranEtiketleri[] = new JLabel[4];
	private JButton hesapOlusturButonu = new JButton(HESAP_OLUSTURMA_ADIMI);
	private JButton islemButonu = new JButton(ISLEM_GERCEKLESTIR_ADIMI);
	
	/**
	 * Mevcut Banka Hesabi
	 */
	private BankaHesabi bankaHesabi;

	/**
	 * Pencere aktivitelerini dinleme amacli ic sinif
	 * 
	 * - windowClosing: Pencere kapat tusuna basildiginda
	 */
	private class PencereAktiviteDinleyici extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
	
	/**
	 * Program giris noktasi
	 * @param arg
	 */
	public static void main(String arg[]) {
		BankaProgrami at = new BankaProgrami();
		at.setTitle("Banka Programi");
		at.setSize(600, 200);
		at.setVisible(true);
	}
	
	/* ------------------------------------------------------- */
	/* YAPILANDIRICI */
	/* ------------------------------------------------------- */
	
	/**
	 * Program yapilandirici (Constructor)
	 */
	public BankaProgrami() {
		addWindowListener(new PencereAktiviteDinleyici());
		setLayout(new GridLayout(2, 0));
		
		// Ekrandaki etiketler belirleniyor
		ekranEtiketleri[IDX_HESAPNO] = new JLabel("HESAP NO");
		ekranEtiketleri[IDX_ILKBAKIYE] = new JLabel("ILK BAKIYE");
		ekranEtiketleri[IDX_YATIRILACAK] = new JLabel("YATIRILACAK MIKTAR");
		ekranEtiketleri[IDX_YATIRILACAK].setVisible(false);
		ekranEtiketleri[IDX_CEKILECEK] = new JLabel("CEKILECEK MIKTAR");
		ekranEtiketleri[IDX_CEKILECEK].setVisible(false);
		
		// Ekrandaki giris alanlari belirleniyor
		JPanel anaPanel = new JPanel();
		anaPanel.setLayout(new GridLayout(5, 2));
		for (int i = 0; i < 4; i++) {
			girisAlanlari[i] = new JTextField(10);
			anaPanel.add(ekranEtiketleri[i]);
			anaPanel.add(girisAlanlari[i]);
		}
		girisAlanlari[IDX_YATIRILACAK].setVisible(false);
		girisAlanlari[IDX_CEKILECEK].setVisible(false);
		
		// Buton aktiviteleri belirleniyor
		hesapOlusturButonu.addActionListener(this);
		islemButonu.addActionListener(this);
		
		// Butonlar ekleniyor
		islemButonu.setVisible(false);
		anaPanel.add(hesapOlusturButonu);
		anaPanel.add(islemButonu);

		// Ana panel ekleniyor
		add(anaPanel);
		
		// Mesaj panelini olustur
		JPanel mesajPaneli = new JPanel();
		mesajPaneli.add(mesajAlani2);
		mesajPaneli.add(mesajAlani1);
		add(mesajPaneli);
		
		
	}

	/* ------------------------------------------------------- */
	/* TANIMLAR ve DEGISKENLER */
	/* ------------------------------------------------------- */
	
	/**
	 * Para yatirma ve cekme islemlerini gerceklestir
	 * 
	 * @param yatirilacak
	 * @param cekilecek
	 * @return
	 */
	private String islemGerceklestir(int yatirilacak, int cekilecek) {
		String msg = "Islem Basarili";
		
		if (yatirilacak>0) {
			bankaHesabi.paraYatir(yatirilacak);
		}
		
		if (cekilecek>0) {
			try {
				bankaHesabi.paraCek(cekilecek);
			} catch (BakiyeYetersizHatasi fe) {
				fe = new BakiyeYetersizHatasi(bankaHesabi.getBakiye(), cekilecek);
				msg = String.valueOf(fe);
			}
		}
		return msg;
	}

	/**
	 * Butona tiklayinca ne yapilacagini belirler
	 */
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals(HESAP_OLUSTURMA_ADIMI)) {
			bankaHesabi = new BankaHesabi(Integer.parseInt(girisAlanlari[IDX_HESAPNO].getText()), Integer.parseInt(girisAlanlari[IDX_ILKBAKIYE].getText()));
			islemButonu.setVisible(true);
			ekranEtiketleri[2].setVisible(true);
			ekranEtiketleri[3].setVisible(true);
			girisAlanlari[IDX_YATIRILACAK].setVisible(true);
			girisAlanlari[IDX_CEKILECEK].setVisible(true);
			hesapOlusturButonu.setVisible(false);
			ekranEtiketleri[0].setVisible(false);
			ekranEtiketleri[1].setVisible(false);
			girisAlanlari[IDX_HESAPNO].setVisible(false);
			girisAlanlari[IDX_ILKBAKIYE].setVisible(false);
			mesajAlani2.setText("HESAP : " + bankaHesabi.getHesapNo() + ", BAKIYE : " + bankaHesabi.getBakiye());
			return;
		} else {
			String kullaniciGirisYatirilacakPara = girisAlanlari[IDX_YATIRILACAK].getText().isEmpty() ? "0" : girisAlanlari[IDX_YATIRILACAK].getText();
			String kullaniciGirisCekilecekPara = girisAlanlari[IDX_CEKILECEK].getText().isEmpty() ? "0" : girisAlanlari[IDX_CEKILECEK].getText();
			mesajAlani1.setText(islemGerceklestir(Integer.parseInt(kullaniciGirisYatirilacakPara), Integer.parseInt(kullaniciGirisCekilecekPara)));
			mesajAlani2.setText("HESAP : " + bankaHesabi.getHesapNo() + ", BAKIYE : " + bankaHesabi.getBakiye());
		}
	}

	
}



