package tr.edu.medipol.vizeproje.numan_gungor;

import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Proje {

	public static void main(String args[]) {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Kutuphane Otomasyonu");
		Container con = new Container();
		JPanel Panel = new JPanel();
		Panel.setLayout(new GridLayout(3, 0));
		// OZKANS SIL-->Scanner scanner = new Scanner(System.in);

		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);

		JMenu yayieviekle = new JMenu("YayinEvi Ekle");
		menu.add(yayieviekle);

		JMenu kitapekle = new JMenu("KitapEkle");
		menu.add(kitapekle);

		ArrayList Kitaplistesi = new ArrayList();

		// OZKANS SIL--> while (scanner.hasNext()) {
		// OZKANS SIL-->	String satir1 = scanner.nextLine();
		// OZKANS SIL-->	String[] alanlar = satir1.split(",");
		// OZKANS SIL-->	Object[] sutun = { "kitap adi", "yazari", "tiri", "yayin evi", "sayfa sayisi" };
		// OZKANS SIL-->	Kitaplistesi.add(satir1);
		// OZKANS SIL--> }

		JMenu kitaplistele = new JMenu("KitaplariListele");
		menu.add(kitaplistele);
		JButton button3 = new JButton("Kitaplari Listele");

		kitaplistele.add(button3);
		JButton button4 = new JButton("Kitap Sil");
		con.add(button4);
		kitaplistele.add(button4);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, "Kitaplariniz listeleniyor");

			}
		});

		JMenu Cikis = new JMenu("iikis");
		menu.add(Cikis);

		JButton button2 = new JButton("Programdan iik");
		Cikis.add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop2 = new JOptionPane();
				jop2.showMessageDialog(null, "Programdan Cikis yapiyorsunuz");
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

			}
		});

		frame.setSize(300, 300);

		frame.add(Panel);
		frame.setVisible(true);

		JLabel label = new JLabel("Yayin Evi:");
		label.setHorizontalAlignment(2);
		label.setLocation(70, 20);
		label.setSize(80, 50);
		Panel.add(label);

		JTextField textfield = new JTextField();
		textfield.setLocation(70, 20);
		textfield.setSize(120, 30);
		Panel.add(textfield);

		JLabel label2 = new JLabel("Eposta adres:");
		label.setHorizontalAlignment(2);
		label.setLocation(70, 45);
		label.setSize(120, 30);
		Panel.add(label2);

		JTextField textfield2 = new JTextField();
		textfield.setLocation(70, 20);
		textfield.setSize(120, 30);
		Panel.add(textfield2);

		JButton button = new JButton("Ekle");
		button.setSize(120, 20);
		button.setLocation(70, 45);
		button.setHorizontalTextPosition(4);
		Panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "sayfaniz aiiliyor");
				JFileChooser fileopen = new JFileChooser();
				fileopen.showOpenDialog(null);
			}
		});

	}
}
