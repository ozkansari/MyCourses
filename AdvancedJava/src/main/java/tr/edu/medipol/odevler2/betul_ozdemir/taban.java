package tr.edu.medipol.odevler2.betul_ozdemir;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;

public class taban extends JFrame implements KeyListener {
      private JButton ekle;
      private JLabel lbul,lgirisyili,ladi,lsoyadi,lbolum,logrencilist;
      private JTextField tbul,tgirisyili,tadi,tsoyadi,tbolum;
      private TextArea togrenci;
      private Container pencere;
      
 
      public taban()
      {

 
          pencere= getContentPane();
        
          pencere.setLayout(new FlowLayout());
         
 
          lbul =new JLabel("��renci No Giriniz");
          pencere.add(lbul);
          tbul =new JTextField(35);
          pencere.add(tbul);
 

          lgirisyili =new JLabel("Giri� Y�l� Giriniz:");
          pencere.add(lgirisyili);
         
          tgirisyili =new JTextField(35);
          pencere.add(tgirisyili);
        
 
          ladi =new JLabel(" Ad�");
          pencere.add(ladi);
 
          tadi =new JTextField(35);
          pencere.add(tadi);
         
 
          lsoyadi =new JLabel("Soyad�  ");
          pencere.add(lsoyadi);
 
          tsoyadi =new JTextField(35);
          pencere.add(tsoyadi);
 
          lbolum =new JLabel("B�l�m�");
          pencere.add(lbolum);
 
          tbolum =new JTextField(35);
          pencere.add(tbolum);

 
          ekle =new JButton("Ekle");
          pencere.add(ekle);
          ekle.setEnabled(true);
          
          logrencilist =new JLabel("��renci Listesi");
          pencere.add(logrencilist);
          togrenci=new TextArea(20,20);
          pencere.add(togrenci);
 

 
         
          //tbul.addKeyListener(this);
          tgirisyili.addKeyListener(this);
          tadi.addKeyListener(this);
          tsoyadi.addKeyListener(this);
          tbolum.addKeyListener(this);
          tbul.addKeyListener(this);
 
          ekle.addActionListener( new ActionListener() {
 
                public void actionPerformed( ActionEvent event )
                {  
           
                    try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conTest = DriverManager.getConnection("jdbc:mysql://localhost/javaornek","root","1");
            Statement komut= conTest.createStatement();
            ResultSet rs = komut.executeQuery("SELECT * FROM ogrenci");

            while(rs.next())
            {
             
                   tgirisyili.setText(rs.getString("giri� y�l�"));
                   tadi.setText(rs.getString("adi"));
                   tsoyadi.setText(rs.getString("soyadi"));
                   tbolum.setText(rs.getString("bolum"));
                   tbul.setText("");                                                  
                   ekle.setEnabled(true);
                   tgirisyili.setEnabled(false);
                   break;
               }
            }
            
        
                   
        catch (Exception hata)
        {
            System.out.println("SURUCU YUKLENEMEDI..."+hata.getMessage());
        }

 
                } 
 
             } 
 
          );
          ekle.addActionListener( new ActionListener() {
        	  
              public void actionPerformed( ActionEvent event )
              {
        
                  try
      {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          Connection conTest = DriverManager.getConnection("jdbc:mysql://localhost/javaornek","root","1");
          Statement komut= conTest.createStatement();
          ResultSet bs = komut.executeQuery("SELECT * FROM ogrenci");
     
            String sql="INSERT INTO ogrenci VALUES('";
            sql+= tgirisyili.getText();
            sql+="','";
            sql+= tadi.getText();
            sql+="','";
            sql+= tsoyadi.getText();
            sql+="','";
            sql+=tbolum.getText();
            sql+="')";
                  boolean rs = komut.execute(sql);
                       tgirisyili.setText("");
                       tadi.setText("");
                       tsoyadi.setText("");
                       tbolum.setText("");
                       ekle.setEnabled(true);
                       tbul.setText("");
                       tgirisyili.setEnabled(true);
      }

      catch (Exception hata)
      {
          System.out.println("SURUCU YUKLENEMEDI..."+hata.getMessage());
      }


              } 

           }
        );

    }


  public static void main(String[] args) {
      
      taban cikar = new taban();
       cikar.setSize(410,350);
      cikar.setVisible(true);
      cikar.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public void keyTyped(KeyEvent e) {
    
   }


  public void keyPressed(KeyEvent e) {
     
      if (e.getSource()==tbul)
      {  String a=tbul.getText();
      if(e.getKeyChar()!=KeyEvent.VK_BACK_SPACE &&(e.getKeyChar()<'0' || e.getKeyChar()>'9'))
      {  JOptionPane.showMessageDialog(null, "Sadece Rakam Giri�i Yap�n�z");
         tbul.setText(a);
      }
      }

      if (e.getSource()==tgirisyili)
      {  String a=tgirisyili.getText();
      if(e.getKeyChar()!=KeyEvent.VK_BACK_SPACE &&(e.getKeyChar()<'0' || e.getKeyChar()>'9'))
      {  JOptionPane.showMessageDialog(null, "Sadece Rakam Giri�i Yap�n�z");
         tgirisyili.setText(a);
      }
      }


      if (e.getSource()==tadi)
      {  String a=tadi.getText();
      if( ( e.getKeyCode()!=KeyEvent.VK_CAPS_LOCK && e.getKeyCode()!=KeyEvent.VK_SHIFT && e.getKeyChar()!= KeyEvent.VK_BACK_SPACE && e.getKeyChar()!= KeyEvent.VK_SPACE && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�'  ) && ((e.getKeyChar()<'a' || e.getKeyChar()>'z') && (e.getKeyChar()<'A' || e.getKeyChar()>'Z'))  )
      {  JOptionPane.showMessageDialog(null, "Sadece Harf Giri�i Yap�n�z");
         tadi.setText(a);
      }
      }

      if (e.getSource()==tsoyadi)
      {  String a=tsoyadi.getText();
      if( ( e.getKeyCode()!=KeyEvent.VK_CAPS_LOCK && e.getKeyCode()!=KeyEvent.VK_SHIFT && e.getKeyChar()!= KeyEvent.VK_BACK_SPACE && e.getKeyChar()!= KeyEvent.VK_SPACE && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�') && ((e.getKeyChar()<'a' || e.getKeyChar()>'z') && (e.getKeyChar()<'A' || e.getKeyChar()>'Z'))  )
      {  JOptionPane.showMessageDialog(null, "Sadece Harf Giri�i Yap�n�z");
         tsoyadi.setText(a);
      }
      }

      if (e.getSource()==tbolum)
      {  String a=tbolum.getText();
      if( ( e.getKeyCode()!=KeyEvent.VK_CAPS_LOCK && e.getKeyCode()!=KeyEvent.VK_SHIFT && e.getKeyChar()!= KeyEvent.VK_BACK_SPACE && e.getKeyChar()!= KeyEvent.VK_SPACE && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�' && e.getKeyChar()!= '�') && ((e.getKeyChar()<'a' || e.getKeyChar()>'z') && (e.getKeyChar()<'A' || e.getKeyChar()>'Z'))  )
      {  JOptionPane.showMessageDialog(null, "Sadece Harf Giri�i Yap�n�z");
         tbolum.setText(a);
      }
      }
  }

  public void keyReleased(KeyEvent evt) {
    
  }

 

}

