package tr.edu.medipol.vizeproje.yucel_ozalp;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class KitapEkleForm extends javax.swing.JFrame {

    public KitapEkleForm() throws FileNotFoundException, IOException {
        initComponents();
        ArrayList<String> yevleri = new ArrayList<>();
        
        /*OZKANS DUZELTME*/ File file = new File(".\\config\\yayinEvi.txt");
        FileReader fileReader = new FileReader(file);
        String line;
        BufferedReader br = new BufferedReader(fileReader);
        boolean bayrak = false;
        while ((line = br.readLine()) != null) {
               String[] b = line.split(",");
               yevleri.add(b[0]);
               bayrak = true;
        }
        br.close();
        
        if (bayrak) {
            jButton1.setEnabled(true);
        }
        else {
            jButton1.setEnabled(false);
            jLabel7.setText("Lütfen Yayın Evi giriniz!");
        }
        
        for (int i = 0; i < yevleri.size(); i++) {
            jComboBox1.addItem(yevleri.get(i));
        }
     
    }
    
    public static boolean isStringNumeric( String str )
{
    DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
    char localeMinusSign = currentLocaleSymbols.getMinusSign();

    if ( !Character.isDigit( str.charAt( 0 ) ) && str.charAt( 0 ) != localeMinusSign ) return false;

    boolean isDecimalSeparatorFound = false;
    char localeDecimalSeparator = currentLocaleSymbols.getDecimalSeparator();

    for ( char c : str.substring( 1 ).toCharArray() )
    {
        if ( !Character.isDigit( c ) )
        {
            if ( c == localeDecimalSeparator && !isDecimalSeparatorFound )
            {
                isDecimalSeparatorFound = true;
                continue;
            }
            return false;
        }
    }
    return true;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ktpAdi = new javax.swing.JTextField();
        ktpYazari = new javax.swing.JTextField();
        ktpTuru = new javax.swing.JTextField();
        ktpSayfaSayisi = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kitap Ekle - Kütüphane Otomasyonu");
        setLocation(new java.awt.Point(600, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Kitap Ekleme");

        jLabel2.setText("Kitap Adı");

        jLabel3.setText("Kitap Yazarı");

        jLabel4.setText("Kitap Türü");

        jLabel5.setText("Sayfa Sayısı");

        jLabel6.setText("Yayın Evi");

        jButton1.setText("KİTAP EKLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));

        jButton2.setText("GERİ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ktpTuru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                            .addComponent(ktpAdi, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ktpYazari, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ktpSayfaSayisi)))))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ktpAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ktpYazari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ktpTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ktpSayfaSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String kitapAdi = ktpAdi.getText();
        String kitapYazari = ktpYazari.getText();
        String kitapTuru = ktpTuru.getText();
        String kitapSayfaSayisi = ktpSayfaSayisi.getText();
        String yayinEvi = jComboBox1.getSelectedItem().toString();
        
        if (kitapAdi.isEmpty() || kitapYazari.isEmpty() || kitapTuru.isEmpty() || kitapSayfaSayisi.isEmpty() || !isStringNumeric(kitapSayfaSayisi)) {
            Component frame = null;
                JOptionPane.showMessageDialog(frame,
                        "Lütfen alanları doğru bir şekilde doldurunuz!!",
                        "Uyarı!",
                        JOptionPane.ERROR_MESSAGE);
        }
        else {
                try {
                	/*OZKANS DUZELTME*/File file = new File(".\\config\\kitaplar.txt");
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write(kitapAdi + "," + kitapYazari + "," + kitapTuru + "," + kitapSayfaSayisi + "," + yayinEvi);
                    bWriter.newLine();
                    bWriter.close();

                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,
                     "Başarıyla kitap oluşturuldu!");
                    
                } catch (Exception e) {
                    
                }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            KitapEkleForm ktpEkleForm = new KitapEkleForm();
            Kutuphane kkhaneForm = new Kutuphane();
            kkhaneForm.setVisible(true);
            ktpEkleForm.pack();
            ktpEkleForm.setLocationRelativeTo(null);
            ktpEkleForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(KitapEkleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KitapEkleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KitapEkleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KitapEkleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitapEkleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new KitapEkleForm().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(KitapEkleForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField ktpAdi;
    private javax.swing.JTextField ktpSayfaSayisi;
    private javax.swing.JTextField ktpTuru;
    private javax.swing.JTextField ktpYazari;
    // End of variables declaration//GEN-END:variables
}
