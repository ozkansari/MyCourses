package tr.edu.medipol.odevler3.keremarca.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tr.edu.medipol.odevler3.keremarca.db.ogrenciDB;
import tr.edu.medipol.odevler3.keremarca.test.gui;

public class anasayfaPencere extends JFrame implements gui {
	
	//ogrenciDB baglanti = new ogrenciDB();
	
	// OZKANS EKLEME
	public static void main(String[] args) {
		new anasayfaPencere();
	}
	// OZKANS EKLEME
	
	public anasayfaPencere() {
		pencere();
	}

	
	public void pencere() {

		JPanel panel = Panel();
		JMenuBar menu = Menu();
		
		add(panel);
		setJMenuBar(menu);
		setTitle("��renci Uygulamas�");
		setSize(400,500);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	public JPanel Panel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel bulPanel = new JPanel();

		JList ogrencilerList = new JList();
		JScrollPane pane = new JScrollPane(ogrencilerList);
		
		//ogrencilerList.setListData(baglanti.listele().toArray());
		
		panel.add(pane,BorderLayout.CENTER);
		panel.add(bulPanel,BorderLayout.NORTH);
	
		
		return panel;
	}

	public JMenuBar Menu() {
	
		JMenuBar menu = new JMenuBar();
		JMenu dosyaJMenu = new JMenu("Men�");
		menu.add(dosyaJMenu);
		JMenuItem kayitYapItem = new JMenuItem("��renci Ekle");
		dosyaJMenu.add(kayitYapItem);
		kayitYapItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new KayitYapGui();
				
			}
		});
		return menu;
	}

}
