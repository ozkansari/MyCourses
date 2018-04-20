package tr.edu.medipol.vizeproje.betul_ozdemir;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;


public class YayinEviEkle extends YayinEvi  {

	public static void main(String[] args) {
	JTextField password, username;
	password = new JTextField(10);
	username = new JTextField(10);
	JFrame Cerceve = new JFrame("Yay�n Evi Ekle");
	
	Cerceve.setBackground(Color.pink);
	Cerceve.setLayout(new GridLayout()); 
	
	Cerceve.add(new JLabel("Yay�n Evi Ad�:"));
	Cerceve.add(username);
	
	Cerceve.add(new JLabel("E-posta Adresi:"));
	Cerceve.add(password);
	
	Cerceve.add(new JButton("Ekle"));
	
	if(username.equals("username")&&(password.equals(null)))
    {
	 
		YayinEvi frame = new YayinEvi();
		Cerceve.setVisible(true);
		Cerceve.pack(); 
    }
    else 
    {
     JOptionPane.showMessageDialog(null, "Hata.");
    }
	Cerceve.setVisible(true);
	Cerceve.pack();

	

}
}

