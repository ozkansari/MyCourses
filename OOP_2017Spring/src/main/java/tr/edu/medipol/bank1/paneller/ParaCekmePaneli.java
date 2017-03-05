package tr.edu.medipol.bank1.paneller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ParaCekmePaneli extends OrtakPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel cekilecekMiktarEtiketi = new JLabel("CEKILECEK MIKTAR");
	private JTextField cekilecekMiktarGirilen = new JTextField();
	
	private static final String PARA_CEK_ADIMI = "PARA CEK";
	private JButton paraCekButonu = new JButton(PARA_CEK_ADIMI);
	
	public ParaCekmePaneli(AnaPanel anaPanel) {
		super(anaPanel);
		
		setLayout(new GridLayout(5, 2));
		
		add(cekilecekMiktarEtiketi);
		add(cekilecekMiktarGirilen);
		add(paraCekButonu);
		paraCekButonu.addActionListener(this);
		addBackButton();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);
		String str = ae.getActionCommand();
		if (str.equals(PARA_CEK_ADIMI)) {
			int cekilecek = Integer.valueOf(cekilecekMiktarGirilen.getText());
			anaPanel.paraCek(cekilecek);
			cekilecekMiktarGirilen.setText("");
		}
	}

}
