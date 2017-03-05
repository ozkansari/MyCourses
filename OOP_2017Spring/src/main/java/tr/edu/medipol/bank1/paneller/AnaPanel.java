package tr.edu.medipol.bank1.paneller;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import tr.edu.medipol.bank1.BakiyeYetersizHatasi;
import tr.edu.medipol.bank1.BankaHesabi;

/**
 * 
 */
public class AnaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel mesajPaneli;
	
	/**
	 * Ekranda gosterilecek mesaj icin ayrilmis alan 1
	 */
	private JLabel mesajAlani1 = new JLabel("");
	
	/**
	 * Ekranda gosterilecek mesaj icin ayrilmis alan 2
	 */
	private JLabel mesajAlani2 = new JLabel("");
	
	/**
	 * Mevcut Banka Hesabi
	 */
	private BankaHesabi bankaHesabi;
	
	/**
	 * 
	 */
	public AnaPanel() {
		setLayout(new GridLayout(2, 0));
		setVisible(true);
		
		// Mesaj panelini olustur
		mesajPaneli = new JPanel();
		mesajPaneli.add(mesajAlani1);
		mesajPaneli.add(mesajAlani2);
	}
	
	/**
	 * 
	 * @param hesapOlusturmaPaneli
	 * @param sonrakiPanel
	 */
	public void ekranaGec(JPanel oncekiPanel, JPanel sonrakiPanel) {
		remove(oncekiPanel);
		remove(mesajPaneli);
		add(sonrakiPanel);
		mesajPaneliEkle();
		repaint();
		revalidate();
	}

	public void mesajPaneliEkle() {
		add(mesajPaneli);
	}

	/**
	 * 
	 * @param mesaj
	 */
	public void setAnaMesaj(String mesaj) {
		mesajAlani1.setText(mesaj);
	}
	
	/**
	 * 
	 * @param mesaj
	 */
	public void setEkMesaj(String mesaj) {
		mesajAlani2.setText(mesaj);
	}
	
	/* ----------------------------------------------------------------------------- */
	/* HESAP ISLEMLERI */
	/* ----------------------------------------------------------------------------- */

	/**
	 * 
	 * @param hesapNo
	 * @param bakiye
	 */
	public void hesapOlustur(int hesapNo, int bakiye) {
		bankaHesabi = new BankaHesabi( hesapNo, bakiye);
		setAnaMesaj("HESAP : " + bankaHesabi.getHesapNo() + ", BAKIYE : " + bankaHesabi.getBakiye());
	}
	
	/**
	 * Para yatirma islemlerini gerceklestir
	 * 
	 * @param yatirilacak
	 * @return
	 */
	public String paraYatir(int yatirilacak) {
		String msg = "Islem Basarili";
		
		if (yatirilacak>0) {
			bankaHesabi.paraYatir(yatirilacak);
		}
		
		setEkMesaj(msg);
		setAnaMesaj("HESAP : " + bankaHesabi.getHesapNo() + ", BAKIYE : " + bankaHesabi.getBakiye());
		
		return msg;
	}
	
	/**
	 * Para cekme islemlerini gerceklestir
	 * 
	 * @param cekilecek
	 * @return
	 */
	public String paraCek(int cekilecek) {
		String msg = "Islem Basarili";

		if (cekilecek>0) {
			try {
				bankaHesabi.paraCek(cekilecek);
			} catch (BakiyeYetersizHatasi fe) {
				fe = new BakiyeYetersizHatasi(bankaHesabi.getBakiye(), cekilecek);
				msg = String.valueOf(fe);
			}
		}
		
		setEkMesaj(msg);
		setAnaMesaj("HESAP : " + bankaHesabi.getHesapNo() + ", BAKIYE : " + bankaHesabi.getBakiye());
		
		return msg;
	}

}
