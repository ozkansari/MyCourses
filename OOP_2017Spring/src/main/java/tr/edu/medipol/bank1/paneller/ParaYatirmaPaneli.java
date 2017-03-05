package tr.edu.medipol.bank1.paneller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ParaYatirmaPaneli extends OrtakPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel yatirilacakMiktarEtiketi = new JLabel("YATIRILACAK MIKTAR");
	private JTextField yatirilacakMiktarGirilen = new JTextField();
	
	private static final String PARA_YATIR_ADIMI = "PARA YATIR";
	private JButton paraYatirButonu = new JButton(PARA_YATIR_ADIMI);
	
	public ParaYatirmaPaneli(AnaPanel anaPanel) {
		super(anaPanel);
		
		setLayout(new GridLayout(5, 2));
		
		add(yatirilacakMiktarEtiketi);
		add(yatirilacakMiktarGirilen);
		add(paraYatirButonu);
		paraYatirButonu.addActionListener(this);
		addBackButton();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);
		String str = ae.getActionCommand();
		if (str.equals(PARA_YATIR_ADIMI)) {
			int yatirilacak = Integer.valueOf(yatirilacakMiktarGirilen.getText());
			anaPanel.paraYatir(yatirilacak );
			yatirilacakMiktarGirilen.setText("");
		}
	}

}
