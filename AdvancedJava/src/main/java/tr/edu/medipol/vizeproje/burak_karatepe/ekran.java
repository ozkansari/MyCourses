package tr.edu.medipol.vizeproje.burak_karatepe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class ekran extends JFrame {
	public JPanel anapanel = new JPanel();
	public KitaplarPanel kitaplarpanel=new KitaplarPanel();
	public YayineviPanel yayinevipanel=new YayineviPanel();
	public JTabbedPane tabbedPane = new JTabbedPane();
	private db database=new db();
	  ekran() {
		//this.setLayout();
		this.setTitle("Kutuphane - Burak Karatepe V.0.1");
		this.setSize(500,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    		database.saveYayinevi();
		    		database.saveKitap();
		            System.exit(0);
		        
		    }
		});
	        
		anapanel.setLayout(new BorderLayout());
		anapanel.setVisible(true);

		
		//anapanel.add(menupanel,BorderLayout.PAGE_START);
		tabbedPane.add("Kitaplar",kitaplarpanel);
		tabbedPane.add("Yayinevleri",yayinevipanel);
		
		ChangeListener changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int index = sourceTabbedPane.getSelectedIndex();
		        //System.out.println(index+"Tab changed to: " + sourceTabbedPane.getTitleAt(index));
		        if(index==0) {
		        	kitaplarpanel.reflesh();
		        }else if(index==1) {
		        	yayinevipanel.reflesh();
		        }
		      }
		    };
		tabbedPane.addChangeListener(changeListener);    
		this.add(tabbedPane);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ekran ek= new ekran();
	}
}
