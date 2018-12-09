package tr.edu.medipol.ilerijava.vize.musademirci.istemci;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tr.edu.medipol.ilerijava.vize.musademirci.sunucu.SunucuEkrani2;

public class IstemciEkrani2 extends SunucuEkrani2 {

	private final JTextField saybir;
	private final JTextField sayiki;
	private final JTextField yap_islem;

	private final JButton mesajGonderBtn;

	public IstemciEkrani2(String title) {
		super(title);

		JPanel mesajGonderimPaneli = new JPanel();
		
		JLabel s1= new JLabel("1.Sayi:");
		mesajGonderimPaneli.add(s1);
		saybir = new JTextField(10);
		mesajGonderimPaneli.add(saybir);
		
		JLabel islem= new JLabel("Yapilacak Olan Islem:");
		mesajGonderimPaneli.add(islem);
		yap_islem = new JTextField(5);
		mesajGonderimPaneli.add(yap_islem);
		
		
		JLabel s2= new JLabel("2.Sayi:");
		mesajGonderimPaneli.add(s2);
		sayiki = new JTextField(10);
		mesajGonderimPaneli.add(sayiki);
		

		mesajGonderBtn = new JButton("Hesapla");
		mesajGonderimPaneli.add(mesajGonderBtn);

		String.valueOf(saybir);
		String.valueOf(sayiki);
		String.valueOf(yap_islem);

		mesajGonderBtn.addActionListener(event -> {
			getMesajKuyrugu().offer(saybir.getText());
			getMesajKuyrugu().offer(sayiki.getText());
			getMesajKuyrugu().offer(yap_islem.getText());

			saybir.setText("");
			sayiki.setText("");
			yap_islem.setText("");
		});

		add(mesajGonderimPaneli);
	}

}