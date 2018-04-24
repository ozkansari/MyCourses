package tr.edu.medipol.vizeproje.burak_karatepe;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.util.ArrayList;
public class KitaplarPanel extends JPanel{
	ArrayList<Kitap>  list = new ArrayList<Kitap>();
	ArrayList<Yayinevi>  yayinevleri = new ArrayList<Yayinevi>();
	JTextField ad = new JTextField(10);
	JTextField yazar = new JTextField(10);
	JTextField sayfasayisi = new JTextField(10);
	JLabel sonuc= new JLabel("");
	JButton button= new JButton("Ekle");
	JScrollPane scrollPane = new JScrollPane();
	JTable  table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JComboBox<Yayinevi> combo = new JComboBox<Yayinevi>();
	db database  =new db();
	
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem deleteItem = new JMenuItem("Delete");
	KitaplarPanel() {
		super();
		JPanel base=this;
		
		deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int index=table.getSelectedRow();
                list.remove(index);
                database.setKitaplar(list);
                model.removeRow(index);
            }
        });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
		sonuc.setOpaque(true);
		JPanel adpanel =new JPanel();
		adpanel.add(new JLabel("Adı"));
		adpanel.add(ad);
		this.add(adpanel);
		JPanel yazarpanel =new JPanel();
		yazarpanel.add(new JLabel("Yazar"));
		yazarpanel.add(yazar);
		this.add(yazarpanel);
		JPanel sayfapanel =new JPanel();
		sayfapanel.add(new JLabel("Kaç Sayfa"));
		sayfapanel.add(sayfasayisi);
		this.add(sayfapanel);
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(combo.getSelectedIndex()==-1) {
            		sonuc.setBackground(Color.red);
            		sonuc.setText("Geçersiz Yayınevi!");
            		return;
            	}else if(ad.getText() == null || ad.getText().isEmpty()) {
            		sonuc.setBackground(Color.red);
            		sonuc.setText("Geçersiz Ad!");
            		return;
            	}else if(yazar.getText() == null || yazar.getText().isEmpty()) {
            		sonuc.setBackground(Color.red);
            		sonuc.setText("Geçersiz Yazar!");
            		return;
            	}else if(sayfasayisi.getText() == null || !sayfasayisi.getText().matches("\\d+")) {
            		sonuc.setBackground(Color.red);
            		sonuc.setText("Sayfa sayısı giriniz.!");
            		return;
            	}
            	sonuc.setBackground(Color.green);
            	Kitap kitap = new Kitap();
            	kitap.setAdi(ad.getText());
            	kitap.setYazar(yazar.getText());
            	kitap.setSayfa(Integer.parseInt(sayfasayisi.getText()));
            	kitap.setYayinevi(yayinevleri.get(combo.getSelectedIndex()));
            	list.add(kitap);
            	database.setKitaplar(list);
            	ad.setText("");
            	yazar.setText("");
            	model.addRow(new Object[]{kitap.getAdi(),kitap.getYazar(),kitap.getSayfa(), kitap.getYayinevi().getAd()});
            	sonuc.setText("Eklendi!");
            }
        });
		JPanel yayinevipanel =new JPanel();
		yayinevipanel.add(new JLabel("Yayınevi:"));
		yayinevipanel.add(combo);
		this.add(yayinevipanel);
		JPanel sonucpanel =new JPanel();
		sonucpanel.add(button);
		button.setPreferredSize(new Dimension(350, 30));
		 
		 this.add(sonucpanel);
		 this.add(scrollPane);
		 this.add(sonuc);
	     scrollPane.setViewportView(table);
	     table.setModel(model);
	     //model.addColumn("ID");
	     model.addColumn("AD");
	     model.addColumn("YAZAR");
	     model.addColumn("SAYFA");
	     model.addColumn("Yayınevinin Adı");
	     
	     combo.setVisible(true);
		this.setVisible(true);
		
		this.reflesh();
	}

	public void reflesh() {
		sonuc.setText("");
		combo.removeAllItems();
		yayinevleri=database.getYayinevleri();
		for(Yayinevi item : database.getYayinevleri()) {
			combo.addItem(item);
		}
		model.setRowCount(0);
		list=database.getKitaplar();
		for(Kitap item : database.getKitaplar()) {
			model.addRow(new Object[]{item.getAdi(),item.getYazar(),item.getSayfa(), item.getYayinevi().getAd()});
		}
		
	}
	
}
