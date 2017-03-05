package tr.edu.medipol.bank1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import tr.edu.medipol.bank1.paneller.AnaPanel;
import tr.edu.medipol.bank1.paneller.HesapOlusturmaPaneli;
import tr.edu.medipol.bank1.paneller.HesapPaneli;
import tr.edu.medipol.bank1.paneller.ParaCekmePaneli;
import tr.edu.medipol.bank1.paneller.ParaYatirmaPaneli;

public class BankaProgrami extends JFrame {

	/* ------------------------------------------------------- */
	/* TANIMLAR ve DEGISKENLER */
	/* ------------------------------------------------------- */
	
	/**
	 * Sinif ID
	 */
	private static final long serialVersionUID = 1L;
	
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

		AnaPanel anaPanel = new AnaPanel();
		add(anaPanel);
		
		ParaCekmePaneli paraCekmePaneli = new ParaCekmePaneli(anaPanel);
		ParaYatirmaPaneli paraYatirmaPaneli = new ParaYatirmaPaneli(anaPanel);
		
		HesapPaneli hesapPaneli = new HesapPaneli(anaPanel, paraCekmePaneli, paraYatirmaPaneli);
		paraCekmePaneli.setOncekiPanel(hesapPaneli);
		paraYatirmaPaneli.setOncekiPanel(hesapPaneli);
		
		HesapOlusturmaPaneli hesapOlusturmaPaneli = new HesapOlusturmaPaneli(anaPanel, hesapPaneli);
		hesapPaneli.setOncekiPanel(hesapOlusturmaPaneli);
		anaPanel.add(hesapOlusturmaPaneli);
		anaPanel.mesajPaneliEkle();
	
	}

}



