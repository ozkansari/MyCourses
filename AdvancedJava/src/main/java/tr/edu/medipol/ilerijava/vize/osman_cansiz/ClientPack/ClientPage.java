package tr.edu.medipol.ilerijava.vize.osman_cansiz.ClientPack;

import javax.swing.*;

import tr.edu.medipol.ilerijava.vize.osman_cansiz.ServerPack.ServerPage;

public class ClientPage extends ServerPage {

	private static final long serialVersionUID = 1L;
	private final JTextField textField;
	private final JButton setMessageButton;

	public ClientPage(String title) {
		super(title);

		JPanel actionPanel = new JPanel();
		
		JLabel label1 = new JLabel("İşlem Giriniz");
		JLabel label2 = new JLabel("İşlem formatı : >> Sayi 1 (+  -  *  /) Sayi 2 << gibi olmalıdır.");

		actionPanel.add(label1);
		textField = new JTextField(10);
		actionPanel.add(textField);

		label2.setSize(100, 100);
		actionPanel.add(label2);

		setMessageButton = new JButton("GONDER");
		actionPanel.add(setMessageButton);

		setMessageButton.addActionListener(event -> {
			getMessageQueue().offer(textField.getText());
			textField.setText("");
		});

		add(actionPanel);
	}

}
