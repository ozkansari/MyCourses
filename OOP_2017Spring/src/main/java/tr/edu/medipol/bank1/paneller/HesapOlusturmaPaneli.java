package tr.edu.medipol.bank1.paneller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HesapOlusturmaPaneli extends OrtakPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel sonrakiPanel;
	
	private JLabel hesapNoEtiketi = new JLabel("HESAP NO");
	private JTextField hesapNoGirilen = new JTextField();
	
	private JLabel ilkBakiyeEtiketi = new JLabel("ILK BAKIYE");
	private JTextField ilkBakiyeGirilen = new JTextField();
	
	private static final String HESAP_OLUSTURMA_ADIMI = "HESAP OLUSTUR";
	private JButton hesapOlusturButonu = new JButton(HESAP_OLUSTURMA_ADIMI);
	
	/**
	 * 
	 * @param anaPanel
	 * @param oncekiPanel
	 * @param sonrakiPanel
	 */
	public HesapOlusturmaPaneli(AnaPanel anaPanel, JPanel sonrakiPanel){
		super(anaPanel);
		
		this.sonrakiPanel = sonrakiPanel;
		
		setLayout(new GridLayout(5, 2));
		
		add(hesapNoEtiketi);
		add(hesapNoGirilen);
		add(ilkBakiyeEtiketi);
		add(ilkBakiyeGirilen);
		add(hesapOlusturButonu);
		hesapOlusturButonu.addActionListener(this);
	}

	/**
	 * Butona tiklayinca ne yapilacagini belirler
	 */
	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);
		String str = ae.getActionCommand();
		if (str.equals(HESAP_OLUSTURMA_ADIMI)) {
			
			int hesapNo = Integer.parseInt(hesapNoGirilen.getText());
			int ilkBakiye = Integer.parseInt(ilkBakiyeGirilen.getText());
			
			anaPanel.hesapOlustur(hesapNo, ilkBakiye);
			anaPanel.ekranaGec(this,sonrakiPanel);
			return;
		}
	}

}
