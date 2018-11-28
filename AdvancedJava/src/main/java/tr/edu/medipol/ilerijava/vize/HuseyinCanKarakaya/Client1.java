package tr.edu.medipol.ilerijava.vize.HuseyinCanKarakaya;

    import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client1 extends JFrame implements ActionListener {
    static Socket socket;
    JPanel panel;
    JTextField textField;
    JTextArea textArea;
    JButton button;

    public Client1() throws UnknownHostException, IOException {
        panel = new JPanel();
        textField = new JTextField();
        textArea = new JTextArea();
        button = new JButton("Send");
        this.setSize(500, 500);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        this.add(panel);
        textArea.setBounds(20, 20, 450, 360);
        panel.add(textArea);
        textField.setBounds(20, 400, 340, 30);
        panel.add(textField);
        button.setBounds(375, 400, 95, 30);
        panel.add(button);
        button.addActionListener(this);
        socket = new Socket(InetAddress.getLocalHost(), 2000);

        textArea.setText("Connected to Server");
        this.setTitle("Client");
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String string = dis.readUTF();
                textArea.setText(textArea.getText() + '\n' + "Server:"
                        + string);
            } catch (Exception e1) {
                textArea.setText(textArea.getText() + '\n'
                        + "Message sending fail:Network Error");
                try {
                    Thread.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if ((e.getSource() == button) && (textField.getText() != "")) {

            textArea.setText(textArea.getText() + '\n' + "User:"
                    + textField.getText());
            try {
                DataOutputStream dos = new DataOutputStream(
                        socket.getOutputStream());
                dos.writeUTF(textField.getText());
            } catch (Exception e1) {
                textArea.setText(textArea.getText() + '\n'
                        + "Message sending fail:Network Error");
                try {
                    Thread.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            }
            textField.setText("");
        }
    }

    public static void main(String[] args) throws UnknownHostException,
            IOException {
        Client1 chatForm = new Client1();
    }
}