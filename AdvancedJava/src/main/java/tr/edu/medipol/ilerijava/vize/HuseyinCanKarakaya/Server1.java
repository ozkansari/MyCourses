package tr.edu.medipol.ilerijava.vize.HuseyinCanKarakaya;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server1 extends JFrame implements ActionListener {
    static ServerSocket server;
    static Socket socket;
    JPanel panel;
    JTextField textField;
    JTextArea textArea;
    JButton button;
    DataInputStream dis;
    DataOutputStream dos;

    public Server1() throws UnknownHostException, IOException {

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
        this.setTitle("Server");
        button.addActionListener(this);
        server = new ServerSocket(2000, 1, InetAddress.getLocalHost());
        textArea.setText("Waiting for Client");
        socket = server.accept();
        textArea.setText(textArea.getText() + '\n' + " Found");
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String string = dis.readUTF();
                textArea.setText(textArea.getText() + '\n' + "Client:"
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
            textArea.setText(textArea.getText() + '\n' + "Server:"
                    + textField.getText());
            try {
                DataOutputStream dos = new DataOutputStream(
                        socket.getOutputStream());
                dos.writeUTF(textField.getText());
            } catch (Exception e1) {
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
        new Server1();
    }
}