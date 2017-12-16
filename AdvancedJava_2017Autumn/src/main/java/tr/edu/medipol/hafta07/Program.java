package tr.edu.medipol.hafta07;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    final JEditorPane editorPane = new JEditorPane();
    
    public LoginPencere() {

        JScrollPane editorScroll = new JScrollPane(editorPane);
        editorScroll.setBounds(10, 10, 700, 200);
        loginPencere.getContentPane().add(editorScroll);

        // JButon
        okButon.setBounds(10, 220, 100, 50);
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
        label.setBounds(10, 250, 700, 200);

        // JSlider
        JSlider slider = new JSlider(0, 150, 0);
        slider.setPreferredSize(new Dimension(150, 30));
        slider.setBounds(10, 450, 100, 100);
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
        } );
        loginPencere.getContentPane().add(slider);

        MenuBarOlustur();
        
        
        loginPencere.setLayout(null);
        loginPencere.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        loginPencere.getContentPane().add(okButon);
        loginPencere.getContentPane().add(label);
        loginPencere.setSize(800, 800);
        // loginPencere.setLocation(700, 700);
        loginPencere.setLocationRelativeTo(null);
        loginPencere.setVisible(true);
    }

    private void MenuBarOlustur() {
        // JMenuBar
        
        Icon fileIcon = UIManager.getIcon("FileView.fileIcon");
        JMenuItem dosyaAceMenuItem = new JMenuItem("Dosya Ac", fileIcon);
        dosyaAceMenuItem.addActionListener(e -> {
            JFileChooser fileopen = new JFileChooser();

            FileFilter filter = new FileNameExtensionFilter("txt files", "txt");
            fileopen.addChoosableFileFilter(filter);
            int answer = fileopen.showDialog(null, "Open file");
            if (answer == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                try {
                    editorPane.setPage("File:///" + file);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        // ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));
        Icon icon = UIManager.getIcon("OptionPane.errorIcon");
        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.addActionListener(event -> {
            System.exit(0);
        });

        JMenu filemenu = new JMenu("File");
        filemenu.add(dosyaAceMenuItem);
        filemenu.add(eMenuItem);

        JMenuBar menubar = new JMenuBar();
        loginPencere.setJMenuBar(menubar);
        menubar.add(filemenu);
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
