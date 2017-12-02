package tr.edu.medipol.hafta7;

import java.awt.*;
import javax.swing.*;

public class Program {

    public static void main(String[] args) {
        new LoginPencere();
    }
}

// Icon kullanimi: 
// - http://en-human-begin.blogspot.com.tr/2007/11/javas-icons-by-default.html
// - https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
class LoginPencere {

    private JFrame loginPencere = new JFrame("Login");
    private JButton okButon = new JButton("OK");

    public LoginPencere() {

        // JMenuBar

        // ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));
        Icon icon = UIManager.getIcon("OptionPane.errorIcon");
        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.addActionListener(event -> {
            System.exit(0);
        });
        
        Icon fileIcon = UIManager.getIcon("FileView.fileIcon");  
        JMenuItem dosyaAceMenuItem = new JMenuItem("Dosya Ac", fileIcon);
        dosyaAceMenuItem.addActionListener(e-> {
            JFileChooser fileopen = new JFileChooser();
            int answer = fileopen.showDialog(null, "Open file");
        });
        
        JMenu filemenu = new JMenu("File");
        filemenu.add(eMenuItem);
        filemenu.add(dosyaAceMenuItem);
        
        JMenuBar menubar = new JMenuBar();
        loginPencere.setJMenuBar(menubar);
        menubar.add(filemenu);
        

        // JButon
        okButon.setBounds(50, 60, 100, 50);
        okButon.addActionListener(eeee -> {
            pencere2Ac();
        });

        // JLabel
        String lyrics = "<html>It's way too late to think of<br>"
                + "Someone I would call now<br>"
                + "And neon signs got tired<br>"
                + "Red eye flights help the stars out<br>"
                + "I'm safe in a corner<br>"
                + "Just hours before me<br></html>";
        JLabel label = new JLabel(lyrics);
        label.setFont(new Font("Georgia", Font.PLAIN, 14));
        label.setForeground(new Color(50, 50, 25));
        label.setBounds(105, 129, 526, 200);

        // JSlider
        JSlider slider = new JSlider(0, 150, 0);
        slider.setPreferredSize(new Dimension(150, 30));
        slider.setBounds(300, 50, 100, 100);
        slider.addChangeListener(e -> {
            int value = slider.getValue();
            if (value == 0) {
                label.setText("<|");
            } else if (value > 0 && value <= 30) {
                label.setText("<|)");
            } else if (value > 30 && value < 80) {
                label.setText("<|))");
            } else {
                label.setText("<|)))");
            }
        }
        );
        loginPencere.getContentPane().add(slider);

        loginPencere.setLayout(null);
        loginPencere.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loginPencere.getContentPane().add(okButon);
        loginPencere.getContentPane().add(label);
        loginPencere.setSize(500, 600);
        // loginPencere.setLocation(700, 700);
        loginPencere.setLocationRelativeTo(null);
        loginPencere.setVisible(true);
    }

    private void pencere2Ac() {
        loginPencere.dispose();
        new Pencere2();
    }

}

class Pencere2 {

    private JFrame f = new JFrame("Second");

    public Pencere2() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}
