 /* �skende Uzuner H5160012 */

package tr.edu.medipol.vizeproje.iskender_uzuner;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.awt.GridLayout;


public class Main implements Runnable, ActionListener
{
  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenuItem kitapEkleItem;
  private JMenuItem yayinEviEkleItem;
  private JMenuItem kitapListeleItem;
  private JTable table;
 
  
  
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Main());
  }

  public void run()
  {
    frame = new JFrame("Kutuphane Uygulamas�");
    menuBar = new JMenuBar();
   

    fileMenu = new JMenu("��lemler");
    
    yayinEviEkleItem = new JMenuItem("Yayin Evi Ekle");
    yayinEviEkleItem.addActionListener(this);
    
    kitapEkleItem = new JMenuItem("Kitap Ekle");
    kitapEkleItem.addActionListener(this);
    
    kitapListeleItem = new JMenuItem("Kitaplar� Listele");
    kitapListeleItem.addActionListener(this);
   
    fileMenu.add(yayinEviEkleItem);
    fileMenu.add(kitapEkleItem);
    fileMenu.add(kitapListeleItem);

    menuBar.add(fileMenu);

    frame.setJMenuBar(menuBar);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(400, 300));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    

	JLabel Welcome = new JLabel("K�t�phane Uygulamas�   -   �skender Uzuner H5160012",JLabel.CENTER);
	Welcome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
	frame.add(Welcome);

	
  }

/**
   Action ��lemleri Sayfalar�n A��lma K�sm�
   */
  public void actionPerformed(ActionEvent ev)
  {
	// OZKANS if (ev.getActionCommand() == yayinEviEkleItem.getActionCommand()) { kontrolu eklenebilirdi
	yayinEviEkleSayfasi yayinEviSayfa = new yayinEviEkleSayfasi();
	yayinEviSayfa.setModal(true);
	yayinEviSayfa.setVisible(true);
	  
    kitapEkleSayfasi sayfa = new kitapEkleSayfasi();    
    sayfa.setModal(true);
    sayfa.setVisible(true);
    
    kitapListeleSayfasi kitapSayfa = new kitapListeleSayfasi();    
    kitapSayfa.setModal(true);
    kitapSayfa.setVisible(true);
 
  }


  /**
   * Yay�n Evi Ekle Sayfas� Menu ��eri�i.
   */
  
  
  private class yayinEviEkleSayfasi extends JDialog implements ActionListener
  {
	  /* Yay�n evi ekle k�sm�n�n butonlar� inputlar� */
	  
    JTextField yayinEviAdiTextField = new JTextField();
	JLabel yayinEviAdiLabel = new JLabel("Yay�n Evi Ad�");
	JTextField ePostaTextField = new JTextField();
	JLabel ePostaLabel = new JLabel("E-posta");
	JButton kaydetButton = new JButton("Kaydet");
	
	FileWriter yaz; // Dosya yazma degiskeni belirledik.

    private yayinEviEkleSayfasi()
    {
    
      super(frame, "Yay�n Evi Ekle", true);
      JPanel panelYayin = new JPanel(new FlowLayout());
  	  GridLayout size = new GridLayout();
	  size.setColumns(3);
	  size.setRows(13);
	  panelYayin.setLayout(size);
      
	  kaydetButton.addActionListener(this);
	  
	  panelYayin.add(yayinEviAdiLabel);
	  panelYayin.add(yayinEviAdiTextField);
	  
	  panelYayin.add(ePostaLabel);
	  panelYayin.add(ePostaTextField);
	  panelYayin.add(kaydetButton);
      getContentPane().add(panelYayin);
      setPreferredSize(new Dimension(900,600));
      pack();
      setLocationRelativeTo(frame);
    }

    public void actionPerformed(ActionEvent ev)
    {
      setVisible(false);
      /* Butona bas�ld�g�nda Dosya yazma i�lemi yap�l�yor */
      if(ev.getActionCommand() == kaydetButton.getActionCommand()) {
    	  try {
    		  yaz = new FileWriter("C:\\Users\\isko\\Desktop\\yayinevi.txt");
    		  yaz.write(yayinEviAdiTextField.getText()+",");
    		  yaz.write(ePostaTextField.getText());
    		  yaz.close();
    		  JOptionPane.showMessageDialog(null, "Dosya Yaz�ld�");
    		  
    	  }catch(Exception e) {JOptionPane.showMessageDialog (null, e+"");}
      }
    }
  }
  
  
  private class kitapEkleSayfasi extends JDialog implements ActionListener
  {
	 /* Kitap Ekle k�sm�n�n butonlar� ve inputlar� */
    JTextField kitapAdiTextField = new JTextField();
	JTextField yazarTextField = new JTextField();
	JTextField turuTextField = new JTextField();
	JTextField yayinEviTextField = new JTextField();
	JTextField sayfaSayisiTextField = new JTextField();
	JLabel kitapAdiLabel = new JLabel("Kitap Ad�");
	JLabel yazarLabel = new JLabel("Yazar Ad�");
	JLabel turuLabel = new JLabel("T�r�");
	JLabel yayinEviLabel = new JLabel("Yay�n Evi");
	JLabel sayfaSayisiLabel = new JLabel("Sayfa Say�s�");
	JButton kaydetButton = new JButton("Kaydet");
	FileWriter yaz; // Dosya yazma degiskeni belirledik.

    private kitapEkleSayfasi()
    {
    
      super(frame, "Kitap Ekle", true);
      JPanel panel = new JPanel(new FlowLayout());
  	  GridLayout size = new GridLayout();
	  size.setColumns(3);
	  size.setRows(13);
	  panel.setLayout(size);
      
	  kaydetButton.addActionListener(this);
	  
      panel.add(kitapAdiLabel);
      panel.add(kitapAdiTextField);
      panel.add(yazarLabel);
      panel.add(yazarTextField);
      panel.add(turuLabel);
      panel.add(turuTextField);
      panel.add(yayinEviLabel);
      panel.add(yayinEviTextField);
      panel.add(sayfaSayisiLabel);
      panel.add(sayfaSayisiTextField);
      panel.add(kaydetButton);
      getContentPane().add(panel);
      setPreferredSize(new Dimension(900,600));
      pack();
      setLocationRelativeTo(frame);
    }

    public void actionPerformed(ActionEvent ev)
    {
      setVisible(false);
      if(ev.getActionCommand() == kaydetButton.getActionCommand()) {
    	  try {
    		  yaz = new FileWriter("C:\\Users\\isko\\Desktop\\kitaplar.txt");
    		  yaz.write(kitapAdiTextField.getText()+",");
    		  yaz.write(yazarTextField.getText()+",");
    		  yaz.write(turuTextField.getText()+",");
    		  yaz.write(yayinEviTextField.getText()+",");
    		  yaz.write(sayfaSayisiTextField.getText());
    		  yaz.close();
    		  JOptionPane.showMessageDialog(null, "Dosya Yaz�ld�");
    		  
    	  }catch(Exception e) {JOptionPane.showMessageDialog (null, e+"");}
      }
    }
  }
  
  private class kitapListeleSayfasi extends JDialog
  {

    private kitapListeleSayfasi()
    {
    
      super(frame, "Kitap Listele", true);
	  setBounds(500, 100, 450, 300);
      JPanel panelListele = new JPanel(new FlowLayout());
  	  GridLayout size = new GridLayout();
  	  
  	  panelListele.setBorder(new EmptyBorder(10, 10, 10, 10));
      setContentPane(panelListele);
      panelListele.setLayout(null);
	  
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 23, 414, 183);
      panelListele.add(scrollPane);
      
	  panelListele.setLayout(size);
	  
	  table = new JTable();
      scrollPane.setViewportView(table);
      
      // Verileri .txt dosyas�ndan �ekemedim o y�zden KitapListele Class i�ine elle yazdim.
      KitapListele listele=new KitapListele();
      String kitaplarim[][]=new String [listele.getKitaplar().size()][];
      for(int i=0;i<listele.getKitaplar().size();i++){
          kitaplarim[i]=new String[]{
        		  String.valueOf(listele.getKitaplar().get(i).getId()),
                  listele.getKitaplar().get(i).getKitapAdi(),
                  listele.getKitaplar().get(i).getYazari(),                
                  listele.getKitaplar().get(i).getTuru(),
                  listele.getKitaplar().get(i).getYayinEvi(),
                  String.valueOf(listele.getKitaplar().get(i).getSayfaSayisi())
          };
      }
      
      //Ba�l�klar� elimizle girdik.
      String basliklar[]={"id"," Kitap ad�","Yazar�","T�r�","Yay�n Evi","Sayfa Say�s�"};
      //TableModelimiz
      TableModel tbmodel=new DefaultTableModel(kitaplarim,basliklar);
      //Tabloya Modelimizi aktar�yoruz.
      table.setModel(tbmodel);
	  
	
    }


  }
  
  
}
