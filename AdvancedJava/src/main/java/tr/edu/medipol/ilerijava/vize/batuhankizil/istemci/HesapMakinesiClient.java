package tr.edu.medipol.ilerijava.vize.batuhankizil.istemci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class HesapMakinesiClient {

	private JFrame frame;
	private JTextField txtsayi1;
	private JTextField txtsayi2;
	private JTextField txtSonuc;
	private static final int PORT = 8091;
	 
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final HesapMakinesiClient window = new HesapMakinesiClient();
					window.frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HesapMakinesiClient() throws IOException {
		initialize();
	}
	
	private void initialize() throws IOException {
				
		final InetAddress address = InetAddress.getByName(null);
	    System.out.println("IP Adresi : " + address);

	    final Socket socket = new Socket(address,PORT);
	        
	    frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSayiyiGiriniz = new JLabel("1. Sayýyý Giriniz : ");
		lblSayiyiGiriniz.setBounds(70, 11, 132, 23);
		frame.getContentPane().add(lblSayiyiGiriniz);
		
		JLabel lblNewLabel = new JLabel("2. Sayýyý Giriniz : ");
		lblNewLabel.setBounds(70, 45, 132, 23);
		frame.getContentPane().add(lblNewLabel);
		
		txtsayi1 = new JTextField();
		txtsayi1.setBounds(179, 12, 215, 23);
		frame.getContentPane().add(txtsayi1);
		txtsayi1.setColumns(10);
		txtsayi1.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        e.consume();
		      }
		    }
		  });
		
		txtsayi2 = new JTextField();
		txtsayi2.setBounds(179, 46, 215, 22);
		frame.getContentPane().add(txtsayi2);
		txtsayi2.setColumns(10);
		txtsayi2.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        e.consume();
		      }
		    }
		  });
		
		
		
		JButton btnToplama = new JButton("+");
		btnToplama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{		
				String sonuc = null;
				try {
					sonuc = islemYap(txtsayi1.getText(),txtsayi2.getText(),"+",socket);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				txtSonuc.setText(String.valueOf(sonuc));
			}
		});
		btnToplama.setBounds(120, 94, 50, 25);
		frame.getContentPane().add(btnToplama);
		
		JButton btnCkarma = new JButton("-");
		btnCkarma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
				String sonuc = null;
				try {
					sonuc = islemYap(txtsayi1.getText(),txtsayi2.getText(),"-",socket);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				txtSonuc.setText(String.valueOf(sonuc));
			}
		});
		btnCkarma.setBounds(181, 94, 50, 25);
		frame.getContentPane().add(btnCkarma);
		
		JButton btnCarpma = new JButton("*");
		btnCarpma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sonuc = null;
				try {
					sonuc = islemYap(txtsayi1.getText(),txtsayi2.getText(),"*",socket);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				txtSonuc.setText(String.valueOf(sonuc));
			}
		});
		btnCarpma.setBounds(245, 94, 50, 25);
		frame.getContentPane().add(btnCarpma);
		
		JButton btnBolme = new JButton("/");
		btnBolme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sonuc = null;
				try {
					sonuc = islemYap(txtsayi1.getText(),txtsayi2.getText(),"/",socket);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				txtSonuc.setText(String.valueOf(sonuc));
			}
		});
		btnBolme.setBounds(310, 94, 50, 25);
		frame.getContentPane().add(btnBolme);
		
		JButton temizle = new JButton("Temizle");
		temizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				temizle();
			}
		});
		temizle.setBounds(200, 125, 80, 30);
		frame.getContentPane().add(temizle);
		
		
		JLabel lblSonuc = new JLabel("Sonuç : ");
		lblSonuc.setBounds(120, 167, 132, 23);
		frame.getContentPane().add(lblSonuc);
		
		txtSonuc = new JTextField();
		txtSonuc.setBounds(179, 170, 215, 23);
		frame.getContentPane().add(txtSonuc);
		txtSonuc.setColumns(10);
		}
	
	    
	public String islemYap(final String text1, final String text2, final String islem, final Socket socket) throws IOException {
	     
		
		if(txtsayi1.getText().equals("") && txtsayi2.getText().equals("")) {
			hataMesajiGoster("1. Sayý ve 2. Sayý Boþ Olamaz!");
			return "";
		}
		
		else if(txtsayi1.getText().equals("")) { 
			hataMesajiGoster("1. Sayýyý Girmediniz!");
			return "";
		} 
		
		else if(txtsayi2.getText().equals("")) { 
			hataMesajiGoster("2. Sayýyý Girmediniz!");
			return "";
		} 
		
		
		
		final double sayi1=Double.parseDouble(txtsayi1.getText());
		final double sayi2=Double.parseDouble(txtsayi2.getText());		
		
		if(sayi2 == 0 && islem.equals("/")) {
			hataMesajiGoster("ikinci sayi 0 olamaz !");
			return "";
		}
		
		try{
	            System.out.println("Socket : " + socket);
	            final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

	                    final String hesapla = sayi1 + "" + islem + "" + sayi2;
	                    out.println(hesapla);
	                    
	                    final String str = in.readLine();
	                    return str;
	        }catch(final IOException ex) {            
	        			ex.printStackTrace();		
	        }finally {
	            System.out.println("Socket Kapatýlýyor");
	        }
		return "";
	}
	
	private void temizle() {
		txtsayi1.setText(null);
		txtsayi2.setText(null);
		txtSonuc.setText(null);
	}
	
	private void hataMesajiGoster(final String s) {
		final JOptionPane optionPane = new JOptionPane(s,JOptionPane.WARNING_MESSAGE);
		final JDialog dialog = optionPane.createDialog("Hata!");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		temizle();
	}
}