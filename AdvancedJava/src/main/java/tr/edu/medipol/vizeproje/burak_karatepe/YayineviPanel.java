package tr.edu.medipol.vizeproje.burak_karatepe;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class YayineviPanel extends JPanel{
	ArrayList<Yayinevi>  list = new ArrayList<Yayinevi>();
	JTextField ad = new JTextField(10);
	JTextField eposta = new JTextField(10);
	JLabel sonuc= new JLabel("");
	JButton button= new JButton("Ekle");
	JScrollPane scrollPane = new JScrollPane();
	JTable  table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	db database=new db();
	
	 JPopupMenu popupMenu = new JPopupMenu();
	 JMenuItem deleteItem = new JMenuItem("Delete");
	YayineviPanel() {
		super();
		this.setVisible(true);
		
		deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int index=table.getSelectedRow();
                list.remove(index);
                database.setYayinevleri(list);
                model.removeRow(index);
            }
        });
        popupMenu.add(deleteItem);
        table.setComponentPopupMenu(popupMenu);
        
		sonuc.setOpaque(true);
		JPanel adpanel=new JPanel();
		adpanel.add(new JLabel("Adı"));
		adpanel.add(ad);
		this.add(adpanel);
		JPanel epostapanel=new JPanel();
		epostapanel.add(new JLabel("E posta"));
		epostapanel.add(eposta);
		this.add(epostapanel);
		YayineviPanel base=this;
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!base.isValidEmailAddress(eposta.getText())) {
            		sonuc.setBackground(Color.red);
            		sonuc.setText("Geçersiz email!");
            		return;
            	}else if(ad.getText() == null || ad.getText().isEmpty()) {
            		sonuc.setBackground(Color.red);
            		sonuc.setText("Geçersiz Ad!");
            		return;
            	}
            	sonuc.setBackground(Color.green);
            	Yayinevi yeniyayin = new Yayinevi();
            	yeniyayin.setAd(ad.getText());
            	yeniyayin.setEposta(eposta.getText());
            	list.add(yeniyayin);
            	database.setYayinevleri(list);
            	ad.setText("");
            	eposta.setText("");
            	model.addRow(new Object[]{yeniyayin.getAd(), yeniyayin.getEposta()});
            	sonuc.setText("Eklendi!");
            }
        });
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
	     model.addColumn("E POSTA");
	     
	    
	}
	public void reflesh() {
		 sonuc.setText("");
		 model.setRowCount(0);
		 list=database.getYayinevleri();
		 for(Yayinevi item : database.getYayinevleri()) {
				model.addRow(new Object[]{item.getAd(), item.getEposta()});
			}
	}
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}

}
