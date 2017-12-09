package tr.edu.medipol.vize1.ibrahimkandemir;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class StockManagement extends JFrame {
	
	private  JPanel stockPanel = new JPanel();
	private  JPanel stockList = new JPanel();
	private  JPanel stockDelete = new JPanel();
	
	private  JTabbedPane tabMenu = new JTabbedPane();
	
	private JLabel productTitle_L = new JLabel("Product Title:");
	private JLabel productStatement_L = new JLabel("Product Statement:");
	private JLabel productBrand_L = new JLabel("Brand:");
	private JLabel productPrice_L = new JLabel("Price:");
	private JLabel productType_L = new JLabel("Product Type:");
	
	private JTextField productTitle_TF = new JTextField();
	private JTextField productStatement_TF = new JTextField();
	private JTextField productBrand_TF = new JTextField();
	private JTextField productPrice_TF = new JTextField();
	
	private JComboBox<String> productType = new JComboBox<>();
	
	
	private static JButton home = new JButton("Home Screen");	
	private JButton productAdd_B = new JButton("Product Add");
	
	private JTextArea product_TxtArea = new JTextArea();
	private JButton productList_B = new JButton("Product List");
	
	private static String path = System.getProperty("user.home");
	
	private StockAction buttonAction;
	private Scanner fileReader;
	
	private JLabel productDelete_L = new JLabel("Produc Delete Title:");
	private JTextField productDelete_TF = new JTextField();
	private JButton productDelete_B = new JButton("Product Delete");
	
	public StockManagement() {
		
		
		stockPanel.setLayout(new GridLayout(18,1));
		stockPanel.setBackground(new Color(3,169,244));
		
		stockList.setLayout(null);
		stockList.setBackground(new Color(3,169,244));
		
		stockDelete.setLayout(new GridLayout(18,1));
		stockDelete.setBackground(new Color(3,169,244));
		
		productType.addItem("Select the type of product");
		productType.addItem("Computer");
		productType.addItem("Phone");
		productType.addItem("Printer");
		productType.addItem("Electronic");
		productType.addItem("Television");
		productType.addItem("Clothing");
		productType.addItem("Woman Clothing");
		productType.addItem("Man Clothing");
		productType.addItem("Kids Clothing");
		productType.addItem("Accessory");
		
		
		
		product_TxtArea.setBounds(0, 30, 590, 690);
		productList_B.setBounds(10, 2, 150, 25);
		
		product_TxtArea.setEditable(false);
		
		buttonAction = new StockAction(productTitle_TF, productStatement_TF, productBrand_TF,
				productPrice_TF, productType);
		
		
		productAdd_B.addActionListener(buttonAction);
		
		
		
		stockPanel.add(home);
		stockPanel.add(productTitle_L);
		stockPanel.add(productTitle_TF);
		stockPanel.add(productStatement_L);
		stockPanel.add(productStatement_TF);
		stockPanel.add(productBrand_L);
		stockPanel.add(productBrand_TF);
		stockPanel.add(productPrice_L);
		stockPanel.add(productPrice_TF);
		stockPanel.add(productType_L);
		stockPanel.add(productType);
		stockPanel.add(productAdd_B);
		
		stockList.add(productList_B);
		stockList.add(product_TxtArea);
		
		stockDelete.add(productDelete_L);
		stockDelete.add(productDelete_TF);
		stockDelete.add(productDelete_B);
		
		
		tabMenu.addTab("Stock Register", stockPanel);
		tabMenu.addTab("Stock List", stockList);
		tabMenu.addTab("Stock Delete", stockDelete);

		add(tabMenu);
		
		
		
		
			
		productList_B.addActionListener(e -> {
			product_TxtArea.setText("");
			
			File dir = new File(path + File.separator + "StoreManagementSystem");
			
			if(!dir.exists())
				dir.mkdirs();
			
			File file = new File (dir + File.separator + "Store.txt");	
			
			try {
				fileReader = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
					
			 while (fileReader.hasNextLine()) {
				 String currentLine = fileReader.nextLine();
	     			product_TxtArea.append(currentLine + "\n");
				
			}
			 fileReader.close();
		});
		
		
		productDelete_B.addActionListener(e -> {
			
		});
		
		
		home.addActionListener(e -> {
			this.dispose();
			new HomeScreen();
		});
		
	}

}
