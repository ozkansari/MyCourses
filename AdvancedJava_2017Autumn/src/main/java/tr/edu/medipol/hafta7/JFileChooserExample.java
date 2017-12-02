package tr.edu.medipol.hafta7;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JEditorPane;

public class JFileChooserExample extends JFrame {

    private JPanel contentPane;

    public JFileChooserExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        final JEditorPane editorPane = new JEditorPane();
        editorPane.setBounds(20, 50, 387, 187);
        contentPane.add(editorPane);
        JButton btnNewButton = new JButton("Open File");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }
        });
        btnNewButton.setBounds(10, 11, 89, 23);
        contentPane.add(btnNewButton);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFileChooserExample frame = new JFileChooserExample();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
