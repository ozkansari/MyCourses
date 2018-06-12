package tr.edu.medipol.vizeproje.yucel_ozalp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class KitapListelemeForm extends javax.swing.JFrame {

   
    public KitapListelemeForm() {
        initComponents();
        importTxtFile();
    }
    
    ArrayList<KitapClass> ktpClass = new ArrayList<>();
    
    public void importTxtFile() {
        try {
        	/*OZKANS DUZELTME*/File file = new File(".\\config\\kitaplar.txt");
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            while ((line = br.readLine()) != null) {
                KitapClass a = new KitapClass();
                String[] b = line.split(",");
                a.KitapAdi = b[0];
                a.KitapYazari = b[1];
                a.KitapTuru = b[2];
                a.KitapSayfaSayisi = b[3];
                a.YayinEvi = b[4];
                ktpClass.add(a);
                model.addRow(b);
                jComboBox1.addItem(a.KitapAdi);
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kitaplar - Kutuphane Otomasyonu");
        setLocation(new java.awt.Point(600, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("KiTAPLAR");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap Adi", "Kitap Yazari", "Kitap Turu", "Kitap Sayfa Sayisi", "Kitap Yayin Evi"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("KiTABI SiL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("GERi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ktpClass.remove(jComboBox1.getSelectedIndex());
        jComboBox1.removeAllItems();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int rowCount = model.getRowCount();
        
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for(int i=0 ; i<ktpClass.size() ; i++){
            String[] b = new String[5];
            b[0] = ktpClass.get(i).KitapAdi;
            b[1] = ktpClass.get(i).KitapYazari;
            b[2] = ktpClass.get(i).KitapTuru;
            b[3]= ktpClass.get(i).KitapSayfaSayisi;
            b[4] = ktpClass.get(i).YayinEvi;
            model.addRow(b);
            jComboBox1.addItem(b[0]);
        }
        try {
        	/*OZKANS DUZELTME*/File file = new File(".\\config\\kitaplar.txt");
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            for(int i=0 ; i<ktpClass.size() ; i++){
                bWriter.write(ktpClass.get(i).KitapAdi + "," + ktpClass.get(i).KitapYazari +
                    "," + ktpClass.get(i).KitapTuru + "," + ktpClass.get(i).KitapSayfaSayisi 
                    + "," + ktpClass.get(i).YayinEvi);
                bWriter.newLine();
            }
            bWriter.close();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            KitapListelemeForm ktpListeleme = new KitapListelemeForm();
            Kutuphane kkhaneForm = new Kutuphane();
            kkhaneForm.setVisible(true);
            ktpListeleme.pack();
            ktpListeleme.setLocationRelativeTo(null);
            ktpListeleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
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
            java.util.logging.Logger.getLogger(KitapListelemeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KitapListelemeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KitapListelemeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KitapListelemeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KitapListelemeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
