package tr.edu.medipol.bank1.paneller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HesapPaneli extends OrtakPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel paraCekmePaneli; 
	private JPanel paraYatirmaPaneli;
	
	private static final String PARA_CEKME_ADIMI = "PARA CEKME";
	private JButton paraCekmeButonu = new JButton(PARA_CEKME_ADIMI);
	
	private static final String PARA_YATIRMA_ADIMI = "PARA YATIRMA";
	private JButton paraYatirmaButonu = new JButton(PARA_YATIRMA_ADIMI);
	
	public HesapPaneli(AnaPanel anaPanel, JPanel paraCekmePaneli, JPanel paraYatirmaPaneli) {
		
		super(anaPanel);
		
		setLayout(new GridLayout(5, 2));
		
		this.anaPanel = anaPanel;
		this.paraCekmePaneli = paraCekmePaneli;
		this.paraYatirmaPaneli = paraYatirmaPaneli;
		
		add(paraCekmeButonu);
		paraCekmeButonu.addActionListener(this);
		
		add(paraYatirmaButonu);
		paraYatirmaButonu.addActionListener(this);
		
		addBackButton();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);
		String str = ae.getActionCommand();
		if (str.equals(PARA_CEKME_ADIMI)) {
			anaPanel.ekranaGec(this,paraCekmePaneli);
		} else if (str.equals(PARA_YATIRMA_ADIMI)) {
			anaPanel.ekranaGec(this,paraYatirmaPaneli);
		}
	}
	
}
