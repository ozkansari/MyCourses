package tr.edu.medipol.vizeproje.yucel_ozalp;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Giris extends javax.swing.JFrame {

    public Giris() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        girisBtn = new javax.swing.JButton();
        passwordInput = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giriş - Kütüphane Otomasyonu");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(44, 62, 80));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(600, 200));

        jLabel1.setText("Kullanıcı adı:");
        jLabel1.setToolTipText("önceden belirlediğiniz kullancı adınız");

        jLabel2.setText("Şifre:");
        jLabel2.setToolTipText("önceden belirlediğiniz şifreniz");

        girisBtn.setText("Giriş yap");
        girisBtn.setToolTipText("");
        girisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(girisBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameInput)
                            .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(girisBtn)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void girisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisBtnActionPerformed

        String kullaniciAdi = usernameInput.getText();
        String sifre = passwordInput.getText();

        if (kullaniciAdi.isEmpty() && sifre.isEmpty()) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "Lütfen şifrenizi boş geçmeyiniz.",
                    "Uyarı!",
                    JOptionPane.WARNING_MESSAGE);

        } else {
            if (kullaniciAdi.contains("1") && sifre.contains("1")) {
                Giris girisForm = new Giris();
                Kutuphane kutuphaneForm = new Kutuphane();
                Component frame = null;
                JOptionPane.showMessageDialog(frame,
                        "Başarıyla giriş yaptınız!");
                kutuphaneForm.setVisible(true);
                girisForm.pack();
                girisForm.setLocationRelativeTo(null);
                girisForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            } else {
                System.out.println("Geçersiz Şifre!: " + kullaniciAdi + sifre);

                Component frame = null;
                JOptionPane.showMessageDialog(frame,
                        "Şifreniz geçersiz! lütfen tekrar deneyin!!",
                        "Uyarı!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_girisBtnActionPerformed

  
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton girisBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
