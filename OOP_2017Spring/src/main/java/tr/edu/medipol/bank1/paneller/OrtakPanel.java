package tr.edu.medipol.bank1.paneller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class OrtakPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	protected AnaPanel anaPanel;
	
	private JPanel oncekiPanel;
	
	private static final String GERI_DON = "GERI DON";
	private JButton geriButonu = new JButton(GERI_DON);
	
	public OrtakPanel(AnaPanel anaPanel) {
		this.anaPanel = anaPanel;
	}
	
	public void setOncekiPanel(JPanel oncekiPanel) {
		this.oncekiPanel = oncekiPanel;
	}

	protected void addBackButton() {
		geriButonu.addActionListener(this);
		add(geriButonu);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals(GERI_DON)) {
			anaPanel.ekranaGec(this, oncekiPanel);
		}
	}

}
