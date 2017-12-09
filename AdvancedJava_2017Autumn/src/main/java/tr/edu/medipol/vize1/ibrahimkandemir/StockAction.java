package tr.edu.medipol.vize1.ibrahimkandemir;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class StockAction implements ActionListener{
	
	private JTextField productTitle_TF;
	private JTextField productStatement_TF;
	private JTextField productBrand_TF;
	private JTextField productPrice_TF;
		
	private JTextField productDelete_TF;
	private JComboBox<String> productType = new JComboBox<>();
	
	private List<Store> storeList = new ArrayList<>();
	
	private static String path = System.getProperty("user.home");
	
	private PrintWriter fileWriter;
	
	
	public StockAction(JTextField productTitle_TF, JTextField productStatement_TF, JTextField productBrand_TF,
	JTextField productPrice_TF, JComboBox<String> productType) {
		this.productTitle_TF = productTitle_TF;
		this.productStatement_TF = productStatement_TF;
		this.productBrand_TF = productBrand_TF;
		this.productPrice_TF = productPrice_TF;
		this.productType = productType;
	}
	
	public StockAction(JTextField productDelete_TF) {
		this.productDelete_TF = productDelete_TF;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		File dir = new File(path + File.separator + "StoreManagementSystem");
		
		if(!dir.exists())
			dir.mkdirs();
		
		File file = new File (dir + File.separator + "Store.txt");	
		
		
		
		
		String productTitle = null;
		String productStatement = null;
		String productBrand = null;
		String productPrice = null;
		String type = (String) productType.getSelectedItem();
		
		try{
			if( (type.equals("Select the type of product")) ){
			
				JOptionPane.showMessageDialog(null,"Required fields cannot be left blank.","Error",JOptionPane.ERROR_MESSAGE);
					return;
			}
				
		}catch(NullPointerException n){
			JOptionPane.showMessageDialog(null,"Enter a valid unit.","Error",JOptionPane.ERROR_MESSAGE);
		}
		
				
			
		if(productTitle_TF.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"The product title cannot be blank","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			productTitle = productTitle_TF.getText();
		}

		if(productStatement_TF.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Product description cannot be left blank","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			productStatement = productStatement_TF.getText();
		}
		
		if(productBrand_TF.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Part of product brand cannot be left blank","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			productBrand = productBrand_TF.getText();
		}
		
		if(productPrice_TF.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"The product price field cannot be left blank","Error",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			productPrice = productPrice_TF.getText();
		}
		
				
		
		
		if( !(productTitle_TF.getText().isEmpty()) && 
				!(productStatement_TF.getText().isEmpty()) && 
					!(productBrand_TF.getText().isEmpty()) && 
						!(productPrice_TF.getText().isEmpty())){
		
									JOptionPane.showMessageDialog(null,"The product has been successfully saved","Info",JOptionPane.INFORMATION_MESSAGE);
		}
		
	
		Store store = null;
		
		if(type.equals("Computer")){
			store = new Computer(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Phone")){
			store = new Phone(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Printer")){
			store = new Printer(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Electronic")){
			store = new Electronic(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Television")){
			store = new Television(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Clothing")){
			store = new Clothing(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Woman Clothing")){
			store = new WomanClothing(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Man Clothing")){
			store = new ManClothing(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Kids Clothing")){
			store = new KidsClothing(productTitle, productStatement, productBrand, productPrice, type);
		}
		else if(type.equals("Accessory")){
			store = new Accessory(productTitle, productStatement, productBrand, productPrice, type);
		}
		
		storeList.add(store);

		
		try {
			fileWriter = new PrintWriter(new FileOutputStream (file, true));
			
			for (Store str : storeList) {
				fileWriter.println(str.productTitle);
				fileWriter.println(str.productStatement);
				fileWriter.println(str.productBrand);
				fileWriter.println(str.productPrice);
				fileWriter.println(str.productType);

			}
			
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
