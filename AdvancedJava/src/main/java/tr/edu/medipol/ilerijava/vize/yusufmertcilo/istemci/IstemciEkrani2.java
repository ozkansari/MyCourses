package tr.edu.medipol.ilerijava.vize.yusufmertcilo.istemci;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tr.edu.medipol.ilerijava.vize.yusufmertcilo.sunucu.SunucuEkrani2;

public class IstemciEkrani2 extends SunucuEkrani2 {

	private final JTextField sayi1;
	private final JTextField sayi2;
	private final JTextField operator;
	
	private final JButton mesajGonderBtn;
	
	public IstemciEkrani2(String title) {
		super(title);
		
		JPanel mesajGonderimPaneli = new JPanel();
		
		sayi1 = new JTextField(6);
		sayi2 = new JTextField(6);
		operator = new JTextField(1);
		
		mesajGonderimPaneli.add(sayi1);
		mesajGonderimPaneli.add(operator);
		mesajGonderimPaneli.add(sayi2);

		mesajGonderBtn = new JButton("HESAPLA");
		mesajGonderimPaneli.add(mesajGonderBtn);
		mesajGonderBtn.addActionListener(event -> {
			getMesajKuyrugu().offer(sayi1.getText() + " " + operator.getText() + " " + sayi2.getText());
			//this.mesajEkle(gonderilecekText);
			sayi1.setText("");
			sayi2.setText("");
			operator.setText("");	
		});
		
		add(mesajGonderimPaneli);
	}

}
